package com.shop.of.accounting.service.service_impl;

import com.shop.of.accounting.model.User;
import com.shop.of.accounting.repository.UserRepository;
import com.shop.of.accounting.service.UserService;
import com.shop.of.accounting.util.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

import static com.shop.of.accounting.util.ValidationUtil.checkNotFound;
import static com.shop.of.accounting.util.ValidationUtil.checkNotFoundWithId;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User create(User user) {
        //Убедитесь, что объект отсутствует null.
        Assert.notNull(user,"user must not be null");
        return userRepository.save(user);
    }

    @Override
    public void delete(int id) throws NotFoundException {
        checkNotFoundWithId(userRepository.delete(id),id);
    }

    @Override
    public User get(int id) throws NotFoundException {
        return checkNotFoundWithId(userRepository.get(id),id);
    }

    @Override
    public User getByEmail(String email) throws NotFoundException {
        Assert.notNull(email,"email must not be null");
        return checkNotFound(userRepository.getByEmail(email),"email= "+email);
    }

    @Override
    public void update(User user) throws NotFoundException {
        Assert.notNull(user,"user must not be null");
        checkNotFoundWithId(userRepository.save(user),user.getId());
    }

    @Override
    public List<User> getAll() {
        return userRepository.getAll();
    }

    @Override
    public void enable(int id, boolean enable) {
        User user = get(id);
        user.setEnabled(enable);
        userRepository.save(user);
    }

    @Override
    public User getWithAlcohol(int id) {
        return checkNotFoundWithId(userRepository.getWithAlcohol(id),id);
    }
}
