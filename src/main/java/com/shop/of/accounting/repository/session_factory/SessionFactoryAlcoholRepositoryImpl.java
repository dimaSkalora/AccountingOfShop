package com.shop.of.accounting.repository.session_factory;

import com.shop.of.accounting.model.Alcohol;
import com.shop.of.accounting.model.User;
import com.shop.of.accounting.repository.AlcoholRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import java.time.LocalDate;
import java.util.List;

public class SessionFactoryAlcoholRepositoryImpl implements AlcoholRepository {

    private SessionFactory sessionFactory;

    private Session openSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Alcohol save(Alcohol alcohol, int userId) {
        if(!alcohol.isNew() && get(alcohol.getId(), userId) == null)
            return null;
        alcohol.setUser(openSession().get(User.class, userId));
        if(alcohol.isNew()){
            openSession().persist(alcohol);
            return alcohol;
        }else
            return (Alcohol) openSession().merge(alcohol);
    }

    @Override
    public boolean delete(int id, int userId) {
     /*  Query query = openSession()
                .createQuery("DELETE FROM Alcohol a WHERE a.id=:id AND a.user.id=:userId");*/

        return openSession().createNamedQuery(Alcohol.DELETE)
                .setParameter("id",id)
                .setParameter("userId",userId)
                .executeUpdate() != 0;
    }

    @Override
    public Alcohol get(int id, int userId) {
        Alcohol alcohol = openSession().get(Alcohol.class, id);
        return alcohol != null && alcohol.getUser().getId() == userId ? alcohol : null;
    }

    @Override
    public List<Alcohol> getAll(int userId) {
        return openSession().createNamedQuery(Alcohol.ALL_SORTED, Alcohol.class)
                .setParameter("userId",userId)
                .getResultList();
    }

    @Override
    public List<Alcohol> getCategory(String category, int userId) {
/*        Query query = openSession()
                .createQuery("SELECT a FROM Alcohol a WHERE a.category=:category AND a.user.id=:userId ORDER BY a.goodsReceiptDate")
                .getResultList();*/

        return openSession().createNamedQuery(Alcohol.GET_CATEGORY, Alcohol.class)
                .setParameter("userId",userId)
                .setParameter("category",category)
                .getResultList();
    }

    @Override
    public List<Alcohol> getSearchByProductName(String productName, String category, int userId) {
        return openSession().createNamedQuery(Alcohol.GET_SEARCH_BY_PRODUCT_NAME, Alcohol.class)
                .setParameter("userId",userId)
                .setParameter("productName",productName)
                .setParameter("category",category)
                .getResultList();
    }

    @Override
    public List<Alcohol> getBetween(LocalDate startDate, LocalDate endDate, int userId) {
        return openSession().createNamedQuery(Alcohol.GET_BETWEEN, Alcohol.class)
                .setParameter("userId",userId)
                .setParameter("startDate",startDate)
                .setParameter("endDate",endDate)
                .getResultList();
    }
}
