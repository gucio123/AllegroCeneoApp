package com.example.demo;

import Models.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AllegroCeneoController {

    private final CeneoService ceneoService;

    public AllegroCeneoController(CeneoService ceneoService) {
        this.ceneoService = ceneoService;
    }

    @GetMapping
    public String hello() {
        return "Main page for now";
    }

    @PostMapping("/getproducts")
    public ResponseEntity<List<Product>> getfindAllProducts(@RequestBody String input) {
        List<Product> products = ceneoService.findProducts(input);
        return new ResponseEntity<>(products, HttpStatus.OK);

    }


}
