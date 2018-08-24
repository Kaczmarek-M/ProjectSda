package com.barterownia.controller;

import com.barterownia.model.dto.NewUserDto;
import com.barterownia.repository.AppUserRepository;
import com.barterownia.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/user")
public class AppUserController {

    @Autowired
    AppUserService appUserService;

    @GetMapping(path = "/register")
    public String getAddUser(Model model) {
        model.addAttribute("newUser", new NewUserDto());
        return "/register";
    }

    @PostMapping(path = "/register")
    public String addUser(Model model, NewUserDto newUserDto) {

        if (!newUserDto.getPassword().equals(newUserDto.getConfirmPassword())) {
            model.addAttribute("newUser", new NewUserDto());
            model.addAttribute("failMsg", "Passwords don't match!");
            return "/register";
        }

        boolean isNew = appUserService.addUser(newUserDto);

        if (!isNew) {
            model.addAttribute("newUser", new NewUserDto());
            model.addAttribute("failMsg", "Username is taken!");
            return "/register";
        }

        return "redirect:/home?login=true";
    }

}
