package com.example.demo;

import Models.Product;
import com.google.api.Http;
import com.google.firebase.auth.FirebaseAuthException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    public ResponseEntity<List<Product>> getfindAllProducts(){
        List<Product> products = ceneoService.findAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}
