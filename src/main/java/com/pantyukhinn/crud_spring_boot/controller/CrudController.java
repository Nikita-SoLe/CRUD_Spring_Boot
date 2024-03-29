package com.pantyukhinn.crud_spring_boot.controller;

import com.pantyukhinn.crud_spring_boot.model.User;
import com.pantyukhinn.crud_spring_boot.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class CrudController {
    private final UserService service;

    public CrudController(UserService service) {
        this.service = service;
    }

    @GetMapping("")
    public String showAllUsers(Model model) {
        model.addAttribute("allUsers", service.getList());
        return "show-all-users";
    }

    @GetMapping("/askDetails")
    public String askUserDetails(Model model) {
        model.addAttribute("user", new User());
        return "ask-user-details-view";
    }

    @GetMapping("/showDetails")
    public String showUserDetails(@ModelAttribute("user") User user) {
        service.create(user);
        return "redirect:/";
    }

    @GetMapping("/deleteUser")
    public String deleteUser(@ModelAttribute("user") User user) {
        service.delete(user);
        return "redirect:/";
    }

    @RequestMapping("/viewUser")
    public String viewUser(@RequestParam("id") Long id, Model model) {
        model.addAttribute("user", service.read(id));
        return "show-user-details-view";
    }

    @RequestMapping("/updateUser")
    public String updateUser(@ModelAttribute("user") User user) {
        service.update(user);
        return "redirect:/";
    }
}
