package com.crudspringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class TestController {


    @GetMapping("/test")
    public String add() {
        return "users";
    }

    @GetMapping("/admin-page")
    public String add1() {
        return "users";
    }

//    @GetMapping("/login")
//    public String login() {
//        return "login";
//    }

    @GetMapping("/test2")
    public String hello() {
        return "user-page";
    }

    @GetMapping("/add-user")
    public String get1() {
        return "add-user";
    }

    @GetMapping("")
    public String update() {
        return "main-page";
    }
}
