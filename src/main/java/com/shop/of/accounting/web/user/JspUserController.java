package com.shop.of.accounting.web.user;

import com.shop.of.accounting.AuthorizedUser;
import com.shop.of.accounting.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
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

/*    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String addUser(@RequestParam(value = "name", required = true) String name,
                          @RequestParam(value = "email", required = true) String email,
                          @RequestParam(value = "password", required = true) String password) {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        if(user.isNew()){
            super.create(user);
        }
        else{
            super.update(user,user.getId());
        }
        return "redirect:/users";
    }*/

    @PostMapping("/create")
    public String createOrUpdate(User user) {
        if (user.isNew()) {
            super.create(user);
        } else {
            super.update(user, user.getId());
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
