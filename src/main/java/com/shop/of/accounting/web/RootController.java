package com.shop.of.accounting.web;

import com.shop.of.accounting.AuthorizedUser;
import com.shop.of.accounting.model.User;
import com.shop.of.accounting.web.user.AbstractUserController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;

@Controller
public class RootController extends AbstractUserController{

    @GetMapping(value = "/login")
    public String login() {
        return "login";
    }

    @GetMapping("/")
    public String root()
    {
        return "goods";
    }

    @GetMapping("/test")
    public String test(){
        return "test";
    }

    @GetMapping("/goods")
    public String goods(){
        return "goods";
    }


    @GetMapping("/profile")
    public String profile() {
        return "profile";
    }

    @PostMapping("/profile")
    public String updateProfile(@Valid User user, BindingResult result, SessionStatus status) {
        if (result.hasErrors()) {
            return "profile";
        } else {
            super.update(user, AuthorizedUser.id());
            AuthorizedUser.setUser(user);
            status.setComplete();
            return "redirect:goods";
        }
    }

    @GetMapping("/register")
    public String register(ModelMap model) {
        model.addAttribute("user", new User());
        model.addAttribute("register", true);
        return "profile";
    }

    @PostMapping("/register")
    public String saveRegister(@Valid User user, BindingResult result, SessionStatus status, ModelMap model) {
        if (result.hasErrors()) {
            model.addAttribute("register", true);
            return "profile";
        } else {
            super.create(user);
            status.setComplete();
            return "redirect:login?&username=" + user.getEmail();
        }
    }
}
