package com.example.demo;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import org.springframework.stereotype.Service;

@Service
public class FirebaseService {


    public void registerClient() throws FirebaseAuthException {
        FirebaseAuth auth = FirebaseAuth.getInstance();
        UserRecord.CreateRequest request = new UserRecord.CreateRequest();
        request.setEmail("jslabyy@gmail.com");
        request.setPassword("abcdef");
        auth.createUser(request);
    }
}
