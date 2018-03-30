package com.shop.of.accounting.web;

import com.shop.of.accounting.AuthorizedUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RootController {

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

    @PostMapping("/setUser")
    public String setUser(HttpServletRequest request) {
        int userId = Integer.valueOf(request.getParameter("userId"));
        AuthorizedUser.setId(userId);

        return "redirect:alcohols";
    }

    @GetMapping("/goods")
    public String goods(){
        return "goods";
    }
}
