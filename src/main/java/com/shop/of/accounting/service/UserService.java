package com.shop.of.accounting.service;

import com.shop.of.accounting.model.User;
import com.shop.of.accounting.util.exception.NotFoundException;

import java.util.List;

public interface UserService {
    User create(User user);
    void delete(int id) throws NotFoundException;
    User get(int id) throws NotFoundException;
    User getByEmail(String email) throws NotFoundException;
    void update(User user)throws NotFoundException;
    List<User> getAll();
    void enable(int id, boolean enable);
    User getWithAlcohol(int id);
}
