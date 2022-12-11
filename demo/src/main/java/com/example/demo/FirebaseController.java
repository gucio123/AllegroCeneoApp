package com.example.demo;


import Models.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/firebase")
public class FirebaseController {
    private FirebaseService firebaseService;

    @Autowired
    public FirebaseController(FirebaseService firebaseService) {
        this.firebaseService = firebaseService;
    }

    @GetMapping
    public String welcome(){
        return "Firebase endpoint";
    }

    @PostMapping("/add")
    public void register(@RequestBody User user) throws FirebaseAuthException {
        firebaseService.registerClient(user);
        
    }
//    @PostMapping("verify-email")
//    public void verifyEmail(@RequestBody Map<String, String> body)
//        throws FirebaseAuthException, IOException {
//        String email = body.get("email");
//        firebaseService.sendEmailVerification(email);
//    }
}
