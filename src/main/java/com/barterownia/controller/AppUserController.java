package com.barterownia.controller;

import com.barterownia.model.dto.NewUserDTO;
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
        model.addAttribute("newUser", new NewUserDTO());
        return "/register";
    }

    @PostMapping(path = "/register")
    public String addUser(Model model, NewUserDTO newUserDto) {

        if (!newUserDto.getPassword().equals(newUserDto.getConfirmPassword())) {
            model.addAttribute("newUser", new NewUserDTO());
            model.addAttribute("failMsg", "Hasła są różne!");
            return "/register";
        }

        boolean isNew = appUserService.addUser(newUserDto);

        if (!isNew) {
            model.addAttribute("newUser", new NewUserDTO());
            model.addAttribute("failMsg", "Nazwa użytkownika zajęta!");
            return "/register";
        }

        return "redirect:/home?log=true";
    }

    @GetMapping(path = "/login")
    public String login(){
        return "redirect:/home?log=true";
    }

    @GetMapping(path = "/panel")
    public String userPanel(){
        return "/userPanel";
    }

}
