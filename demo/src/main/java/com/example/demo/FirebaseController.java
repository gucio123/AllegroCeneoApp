package com.example.demo;


import Models.User;
import com.google.firebase.auth.FirebaseAuthException;
import org.springframework.web.bind.annotation.*;

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
    public void register(@RequestBody User user) throws FirebaseAuthException {
        firebaseService.registerClient(user);
    }
}
