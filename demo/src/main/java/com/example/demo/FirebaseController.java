package com.example.demo;


import com.google.firebase.auth.FirebaseAuthException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/firebase")
public class FirebaseController {
    private FirebaseService firebaseService;

    public FirebaseController(FirebaseService firebaseService) {
        this.firebaseService = firebaseService;
    }

    @GetMapping
    public String welcome(){
        return "Firebase endpoint";
    }

    @PostMapping("/add")
    public void register() throws FirebaseAuthException {
        firebaseService.registerClient();
    }
}
