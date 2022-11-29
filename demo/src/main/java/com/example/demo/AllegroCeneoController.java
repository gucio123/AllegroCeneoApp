package com.example.demo;

import Models.Product;
import com.google.firebase.auth.FirebaseAuthException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AllegroCeneoController {

    CeneoService ceneoService;

    public AllegroCeneoController(CeneoService ceneoService) {
        this.ceneoService = ceneoService;
    }

    @GetMapping
    public String hello(){
        return "Main page for now";
    }

    @GetMapping("/getproducts")
    public Product[] getProducts(){
        return ceneoService.products();
    }
}
