package com.kaz.spring.mvc_hibernate_aop.controller;

import com.kaz.spring.mvc_hibernate_aop.entity.User;
import com.kaz.spring.mvc_hibernate_aop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String showAllUsers(Model model) {

        userService.createUsersTable();
        List<User> users = userService.getAllUsers();
        model.addAttribute("allUsers", users);

        return "all-users";
    }

    @RequestMapping("/addNewUser")
    public String addNewUser(Model model) {

        User user = new User();
        model.addAttribute("user", user);

        return "user-info";
    }

    @RequestMapping("/saveNewUser")
    public String saveNewUser(@ModelAttribute("user") User user) {

        userService.saveNewUser(user);

        return "redirect:/";
    }

    @RequestMapping("/updateInfo")
    public String updateUser(@RequestParam("usrId") int id, Model model) {

        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "user-info";
    }

    @RequestMapping("/deleteUser")
    public String deleteUser(@RequestParam("usrId") int id) {

        userService.deleteUserById(id);
        return "redirect:/";
    }
}
