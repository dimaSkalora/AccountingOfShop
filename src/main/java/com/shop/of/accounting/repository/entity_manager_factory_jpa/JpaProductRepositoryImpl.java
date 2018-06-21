package com.shop.of.accounting.repository.entity_manager_factory_jpa;

import com.shop.of.accounting.model.Product;
import com.shop.of.accounting.model.User;
import com.shop.of.accounting.repository.ProductRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.util.List;

public class JpaProductRepositoryImpl implements ProductRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Product save(Product cigarette, int userId) {
        if(!cigarette.isNew() && get(cigarette.getId(),userId) == null)
            return null;
        cigarette.setUser(entityManager.find(User.class, userId));
        if(cigarette.isNew()){
            entityManager.persist(cigarette);
            return cigarette;
        }else
            return (Product) entityManager.merge(cigarette);
    }

    @Override
    public boolean delete(int id, int userId) {
   /*     Query query = entityManager
                .createQuery("DELETE FROM Product p WHERE p.id=:id AND p.user.id=:userId");*/

        return entityManager.createNamedQuery(Product.DELETE)
                .setParameter("id",id)
                .setParameter("userId",userId)
                .executeUpdate() != 0;
    }

    @Override
    public Product get(int id, int userId) {
        Product product = entityManager.find(Product.class, id);
        return product != null && product.getUser().getId() == userId ? product : null;
    }

    @Override
    public List<Product> getAll(int userId) {
        return entityManager.createNamedQuery(Product.ALL_SORTED, Product.class)
                .setParameter("userId",userId)
                .getResultList();
    }

    @Override
    public List<Product> getCategory(String category, int userId) {
        /*        Query query = entityManager
                .createQuery("SELECT c FROM Product p WHERE p.category=:category AND p.user.id=:userId ORDER BY p.goodsReceiptDate")
                .getResultList();*/

        return entityManager.createNamedQuery(Product.GET_CATEGORY, Product.class)
                .setParameter("userId",userId)
                .setParameter("category",category)
                .getResultList();
    }

    @Override
    public List<Product> getSearchByProductName(String productName, String category, int userId) {
        return entityManager.createNamedQuery(Product.GET_SEARCH_BY_PRODUCT_NAME, Product.class)
                .setParameter("userId",userId)
                .setParameter("productName",productName)
                .setParameter("category",category)
                .getResultList();
    }

    @Override
    public List<Product> getBetween(LocalDate startDate, LocalDate endDate, int userId) {
        return entityManager.createNamedQuery(Product.GET_BETWEEN, Product.class)
                .setParameter("userId",userId)
                .setParameter("startDate",startDate)
                .setParameter("endDate",endDate)
                .getResultList();
    }
}
