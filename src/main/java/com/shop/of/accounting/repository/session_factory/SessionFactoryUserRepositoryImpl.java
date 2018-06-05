package com.shop.of.accounting.repository.session_factory;

import com.shop.of.accounting.model.User;
import com.shop.of.accounting.repository.UserRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.jpa.QueryHints;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

public class SessionFactoryUserRepositoryImpl implements UserRepository {

    @Autowired
    private SessionFactory sessionFactory;

    private Session openSession() {
        return sessionFactory.getCurrentSession();
    }
    @Override
    public User save(User user) {
        if(user.isNew()) {
            openSession().persist(user);
            return user;
        }else
            return (User) openSession().merge(user);
    }

    @Override
    public boolean delete(int id) {
       /* User userDelete = openSession().get(User.class,id);
        openSession().delete(userDelete);*/

       /* Query query = openSession().createQuery("DELETE FROM User u WHERE u.id=:id");
        return query.setParameter("id",id).executeUpdate() != 0;        */

        return openSession().createNamedQuery(User.DELETE)
                .setParameter("id",id)
                .executeUpdate() != 0;
    }

    @Override
    public User get(int id) {
        return openSession().get(User.class,id);
    }

    @Override
    public User getByEmail(String email) {
        List<User> users = openSession().createNamedQuery(User.BY_EMAIL, User.class)
                .setParameter(1, email)
                .setHint(QueryHints.HINT_PASS_DISTINCT_THROUGH, false)
                .getResultList();
        return (User) DataAccessUtils.singleResult(users);
    }

    @Override
    public List<User> getAll() {
        //return openSession().createQuery("SELECT u FROM User u ORDER BY u.name, u.email").getResultList();
        return openSession().createNamedQuery(User.ALL_SORTED,User.class).getResultList();
    }
}
