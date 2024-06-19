package com.thymeleafpractical.thymeleafpractical.controller;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MyController {
    @RequestMapping(value = "/about" , method = RequestMethod.GET)
    public String about(Model model) {
        // putting data in model
        model.addAttribute("name", "Raj Patani");
        model.addAttribute("currentDate", new Date());
        System.out.println("Inside about handler....");
        return "about";
        // /about.html
    }

    // handling iteration
    @GetMapping("/iterate")
    public String iterate(Model m) {
        // create a list , set or collection
        List<String> names = List.of("Ankit", "Anshul", "Shyam", "John");
        m.addAttribute("names", names);
        return "iterate";
    }
}
