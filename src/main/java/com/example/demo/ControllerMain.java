package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletRequest;

@RestController
public class ControllerMain {

    @GetMapping("/")
    public String index(ServletRequest servletRequest){
        return "index";
    }
}
