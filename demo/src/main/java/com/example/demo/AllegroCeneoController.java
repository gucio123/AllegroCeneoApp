package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AllegroCeneoController {

    @GetMapping
    public String hello(){
        return "Helloooo!";
    }

}
