package com.shop.of.accounting.repository.session_factory;

import com.shop.of.accounting.model.Product;
import com.shop.of.accounting.model.User;
import com.shop.of.accounting.repository.ProductRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.time.LocalDate;
import java.util.List;

public class SessionFactoryProductRepositoryImpl implements ProductRepository {

    private SessionFactory sessionFactory;

    private Session openSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Product save(Product product, int userId) {
        if(!product.isNew() && get(product.getId(),userId) == null)
            return null;
        product.setUser(openSession().get(User.class, userId));
        if(product.isNew()){
            openSession().persist(product);
            return product;
        }else
            return (Product) openSession().merge(product);
    }

    @Override
    public boolean delete(int id, int userId) {
         /*     Query query = openSession()
                .createQuery("DELETE FROM Product p WHERE p.id=:id AND p.user.id=:userId");*/

        return openSession().createNamedQuery(Product.DELETE)
                .setParameter("id",id)
                .setParameter("userId",userId)
                .executeUpdate() != 0;
    }

    @Override
    public Product get(int id, int userId) {
        Product product = openSession().get(Product.class, id);
        return product != null && product.getUser().getId() == userId ? product : null;
    }

    @Override
    public List<Product> getAll(int userId) {
        return openSession().createNamedQuery(Product.ALL_SORTED, Product.class)
                .setParameter("userId",userId)
                .getResultList();
    }

    @Override
    public List<Product> getCategory(String category, int userId) {
             /*        Query query = openSession()
                .createQuery("SELECT c FROM Product p WHERE p.category=:category AND p.user.id=:userId ORDER BY p.goodsReceiptDate")
                .getResultList();*/

        return openSession().createNamedQuery(Product.GET_CATEGORY, Product.class)
                .setParameter("userId",userId)
                .setParameter("category",category)
                .getResultList();
    }

    @Override
    public List<Product> getSearchByProductName(String productName, String category, int userId) {
        return openSession().createNamedQuery(Product.GET_SEARCH_BY_PRODUCT_NAME, Product.class)
                .setParameter("userId",userId)
                .setParameter("productName",productName)
                .setParameter("category",category)
                .getResultList();
    }

    @Override
    public List<Product> getBetween(LocalDate startDate, LocalDate endDate, int userId) {
        return openSession().createNamedQuery(Product.GET_BETWEEN, Product.class)
                .setParameter("userId",userId)
                .setParameter("startDate",startDate)
                .setParameter("endDate",endDate)
                .getResultList();
    }
}
