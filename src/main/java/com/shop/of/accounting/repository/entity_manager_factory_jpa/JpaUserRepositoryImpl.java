package com.shop.of.accounting.repository.entity_manager_factory_jpa;

import com.shop.of.accounting.model.User;
import com.shop.of.accounting.repository.UserRepository;
import org.hibernate.jpa.QueryHints;
import org.springframework.dao.support.DataAccessUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class JpaUserRepositoryImpl implements UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User save(User user) {
        if(user.isNew()){
            entityManager.persist(user);
            return user;
        }else
            return entityManager.merge(user);
    }

    @Override
    public boolean delete(int id) {
     /*   User user = entityManager.find(User.class, id);
        entityManager.remove(user);*/

 /*       Query query = entityManager.createQuery("DELETE FROM User u WHERE u.id=:id");
        return query.setParameter("id",id).executeUpdate() != 0;*/
        return entityManager.createNamedQuery(User.DELETE)
                .setParameter("id", id)
                .executeUpdate() != 0;
    }

    @Override
    public User get(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public User getByEmail(String email) {
        List<User> users = entityManager.createNamedQuery(User.BY_EMAIL, User.class)
                .setParameter(1, email)
                .setHint(QueryHints.HINT_PASS_DISTINCT_THROUGH, false)
                .getResultList();
        return (User) DataAccessUtils.singleResult(users);
    }

    @Override
    public List<User> getAll() {
        return entityManager.createNamedQuery(User.ALL_SORTED, User.class).getResultList();
    }
}
