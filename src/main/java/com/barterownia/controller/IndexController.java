package com.barterownia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping(path="/faq")
    public String faq(){
        return "faq";
    }
    @RequestMapping(path ="/contact")
    public String contact(){
        return "contact";
    }
    @RequestMapping(path = "/rules")
    public String statutes(){
        return "/rules";
    }

    @GetMapping(path = "/")
    public String home() {
        return "/mainPage";
    }


}
