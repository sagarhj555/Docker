package com.docker.java_demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DocController {

    @GetMapping
    public String greet(){
        return "Welcome to Java-Docker Project";
    }
}
