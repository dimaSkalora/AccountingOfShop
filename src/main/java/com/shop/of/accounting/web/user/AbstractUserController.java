package com.shop.of.accounting.web.user;

import com.shop.of.accounting.model.Role;
import com.shop.of.accounting.model.User;
import com.shop.of.accounting.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class AbstractUserController {
    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService service;

    public List<User> getAll() {
        log.info("getAll");
        return service.getAll();
    }

    public User get(int id) {
        log.info("get {}", id);
        return service.get(id);
    }

    public User create(User user) {
        log.info("create {}", user);
        if(!user.isNew())
            throw new IllegalArgumentException(user + " must be new (id=null)");
        Set<Role> role = new HashSet<>();
        role.add(Role.ROLE_USER);
        user.setRoles(role);
        System.out.println(user);
        return service.create(user);
    }

    public void delete(int id) {
        log.info("delete {}", id);
        service.delete(id);
    }

    public void update(User user, int id) {
        log.info("update {} with id={}", user, id);
        if (user.isNew()) {
            user.setId(id);
            Set<Role> role = new HashSet<>();
            role.add(Role.ROLE_USER);
            user.setRoles(role);
        } else if (user.getId() != id) {
            throw new IllegalArgumentException(user + " must be with id=" + id);
        }
        service.update(user);
    }

    public User getByMail(String email) {
        log.info("getByEmail {}", email);
        return service.getByEmail(email);
    }

    public void enable(int id, boolean enabled) {
        log.info((enabled ? "enable " : "disable ") + id);
        service.enable(id, enabled);
    }
}
