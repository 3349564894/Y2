package com.yq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class c {

    @RequestMapping("/login")
    public String login() {
        System.out.println("login");
        return "hahaha";
    }
}
