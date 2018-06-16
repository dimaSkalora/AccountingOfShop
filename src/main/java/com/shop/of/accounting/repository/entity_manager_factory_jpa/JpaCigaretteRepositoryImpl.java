package com.shop.of.accounting.repository.entity_manager_factory_jpa;

import com.shop.of.accounting.model.Cigarette;
import com.shop.of.accounting.model.User;
import com.shop.of.accounting.repository.CigaretteRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.util.List;

public class JpaCigaretteRepositoryImpl implements CigaretteRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Cigarette save(Cigarette cigarette, int userId) {
        if(!cigarette.isNew() && get(cigarette.getId(),userId) == null)
            return null;
        cigarette.setUser(entityManager.find(User.class, userId));
        if(cigarette.isNew()){
            entityManager.persist(cigarette);
            return cigarette;
        }else
            return (Cigarette) entityManager.merge(cigarette);
    }

    @Override
    public boolean delete(int id, int userId) {
   /*     Query query = entityManager
                .createQuery("DELETE FROM Cigarette c WHERE c.id=:id AND c.user.id=:userId");*/

        return entityManager.createNamedQuery(Cigarette.DELETE)
                .setParameter("id",id)
                .setParameter("userId",userId)
                .executeUpdate() != 0;
    }

    @Override
    public Cigarette get(int id, int userId) {
        Cigarette cigarette = entityManager.find(Cigarette.class, id);
        return cigarette != null && cigarette.getUser().getId() == userId ? cigarette : null;
    }

    @Override
    public List<Cigarette> getAll(int userId) {
        return entityManager.createNamedQuery(Cigarette.ALL_SORTED, Cigarette.class)
                .setParameter("userId",userId)
                .getResultList();
    }

    @Override
    public List<Cigarette> getCategory(String category, int userId) {
        /*        Query query = entityManager
                .createQuery("SELECT c FROM Cigarette c WHERE c.category=:category AND c.user.id=:userId ORDER BY c.goodsReceiptDate")
                .getResultList();*/

        return entityManager.createNamedQuery(Cigarette.GET_CATEGORY, Cigarette.class)
                .setParameter("userId",userId)
                .setParameter("category",category)
                .getResultList();
    }

    @Override
    public List<Cigarette> getSearchByProductName(String productName, String category, int userId) {
        return entityManager.createNamedQuery(Cigarette.GET_SEARCH_BY_PRODUCT_NAME, Cigarette.class)
                .setParameter("userId",userId)
                .setParameter("productName",productName)
                .setParameter("category",category)
                .getResultList();
    }

    @Override
    public List<Cigarette> getBetween(LocalDate startDate, LocalDate endDate, int userId) {
        return entityManager.createNamedQuery(Cigarette.GET_BETWEEN, Cigarette.class)
                .setParameter("userId",userId)
                .setParameter("startDate",startDate)
                .setParameter("endDate",endDate)
                .getResultList();
    }
}
