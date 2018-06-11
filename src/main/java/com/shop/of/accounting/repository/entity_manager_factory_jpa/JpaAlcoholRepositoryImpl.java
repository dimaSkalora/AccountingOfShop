package com.shop.of.accounting.repository.entity_manager_factory_jpa;

import com.shop.of.accounting.model.Alcohol;
import com.shop.of.accounting.model.User;
import com.shop.of.accounting.repository.AlcoholRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.util.List;

public class JpaAlcoholRepositoryImpl implements AlcoholRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Alcohol save(Alcohol alcohol, int userId) {
        if(!alcohol.isNew() && get(alcohol.getId(), userId) == null)
            return null;
        alcohol.setUser(entityManager.find(User.class, userId));
        if(alcohol.isNew()){
            entityManager.persist(alcohol);
            return alcohol;
        }else
            return entityManager.merge(alcohol);
    }

    @Override
    public boolean delete(int id, int userId) {
     /*  Query query = entityManager
                .createQuery("DELETE FROM Alcohol a WHERE a.id=:id AND a.user.id=:userId");*/

        return entityManager.createNamedQuery(Alcohol.DELETE)
                .setParameter("id",id)
                .setParameter("userId",userId)
                .executeUpdate() != 0;
    }

    @Override
    public Alcohol get(int id, int userId) {
        Alcohol alcohol = entityManager.find(Alcohol.class, id);
        return alcohol != null && alcohol.getUser().getId() == userId ? alcohol : null;
    }

    @Override
    public List<Alcohol> getAll(int userId) {
        return entityManager.createNamedQuery(Alcohol.ALL_SORTED, Alcohol.class)
                .setParameter("userId",userId)
                .getResultList();
    }

    @Override
    public List<Alcohol> getCategory(String category, int userId) {
/*        Query query = entityManager
                .createQuery("SELECT a FROM Alcohol a WHERE a.category=:category AND a.user.id=:userId ORDER BY a.goodsReceiptDate")
                .getResultList();*/

        return entityManager.createNamedQuery(Alcohol.GET_CATEGORY, Alcohol.class)
                .setParameter("userId",userId)
                .setParameter("category",category)
                .getResultList();
    }

    @Override
    public List<Alcohol> getSearchByProductName(String productName, String category, int userId) {
        return entityManager.createNamedQuery(Alcohol.GET_SEARCH_BY_PRODUCT_NAME, Alcohol.class)
                .setParameter("userId",userId)
                .setParameter("productName",productName)
                .setParameter("category",category)
                .getResultList();
    }

    @Override
    public List<Alcohol> getBetween(LocalDate startDate, LocalDate endDate, int userId) {
        return entityManager.createNamedQuery(Alcohol.GET_BETWEEN, Alcohol.class)
                .setParameter("userId",userId)
                .setParameter("startDate",startDate)
                .setParameter("endDate",endDate)
                .getResultList();
    }
}
