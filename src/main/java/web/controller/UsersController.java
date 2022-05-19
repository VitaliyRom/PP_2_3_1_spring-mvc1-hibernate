package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.servise.UserService;


@Controller
public class UsersController {


    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @GetMapping(value = "/edit/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.getById(id));
        return "edit";
    }

    @GetMapping(value = "/add")
    public String newUser(@ModelAttribute("user") User user) {
        return "new";
    }

    @PostMapping(value = "/add")
    public String create(@ModelAttribute("user") User user) {
        userService.add(user);
        return "redirect:/";
    }

    @GetMapping(value = "/edit/{id}")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("person", userService.getById(id));
        return "edit";
    }

    @PostMapping(value = "/edit")
    public String update(@ModelAttribute("user") User user) {
        userService.edit(user);
        return "redirect:/";
    }

    @DeleteMapping(value = "/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        userService.delete(userService.getById(id));
        return "redirect:/";
    }
}


