package com.shop.of.accounting.web;

import com.shop.of.accounting.AuthorizedUser;
import com.shop.of.accounting.model.Role;
import com.shop.of.accounting.model.User;
import com.shop.of.accounting.service.UserService;
import com.shop.of.accounting.web.user.AbstractUserController;
import com.shop.of.accounting.web.user.JspUserController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.awt.print.Book;
import java.util.HashSet;
import java.util.Set;

@Controller
public class RootController {

    @GetMapping("/")
    public String root(){
        return "/index";
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
