package com.shop.of.accounting.service.service_impl;

import com.shop.of.accounting.AuthorizedUser;
import com.shop.of.accounting.model.User;
import com.shop.of.accounting.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//@Service
public class UserServiceLogin implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.getByEmail(s.toLowerCase());
        AuthorizedUser.setUser(user);
        System.out.println(" AuthorizedUser.setUser "+user);
        AuthorizedUser.setId(user.getId());
        System.out.println(" loadUserByUsername "+AuthorizedUser.id());
        System.out.println(user.getRoles());
        if (user == null) {
            throw new UsernameNotFoundException("User " + s + " is not found");
        }
        System.out.println("loadUserByUsername "+user.toString());
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), user.getRoles());

    }
}
