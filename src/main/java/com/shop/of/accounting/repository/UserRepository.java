package com.shop.of.accounting.repository;

import com.shop.of.accounting.model.User;

import java.util.List;

public interface UserRepository {
    User save(User user);
    // false if not found
    boolean delete(int id);
    // null if not found
    User get(int id);
    // null if not found
    User getByEmail(String email);
    List<User> getAll();
    default User getWithAlcohol(int id){
        throw new UnsupportedOperationException();
    }
}
