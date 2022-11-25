package com.example.demo;

import com.google.firebase.auth.FirebaseAuthException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AllegroCeneoController {

    private FirebaseService firebaseService;

    public AllegroCeneoController(FirebaseService firebaseService) {
        this.firebaseService = firebaseService;
    }

    @GetMapping
    public String hello(){
        return "Hello!";
    }

    @PostMapping
    public void register() throws FirebaseAuthException {
        firebaseService.registerClient();
    }
}
