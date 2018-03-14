package com.shop.of.accounting.web.user;

import com.shop.of.accounting.AuthorizedUser;
import com.shop.of.accounting.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/users")
public class JspUserController extends AbstractUserController {

    @GetMapping
    public String users(Model model){
        model.addAttribute("user", new User());
        model.addAttribute("users",super.getAll());
        return "users";
    }

    @PostMapping("/create")
    public String addUser(@ModelAttribute("user") User user, int id){
        if(user.isNew()){
      /*      Set<Role> roleSet = new HashSet<>();
            roleSet.add(Role.ROLE_USER);
            user.setRoles(roleSet);*/
            super.create(user);
        }
        else{
            super.update(user,id);
        }
        return "redirect:/users";
    }

    @GetMapping("update/{id}")
    public String updateUser(@PathVariable("id")int id, Model model){
        User user = super.get(id);
        model.addAttribute("user", user);
        model.addAttribute("users",super.getAll());

        return "users";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id")int id){
        super.delete(id);
        return "redirect:/users";
    }
}
