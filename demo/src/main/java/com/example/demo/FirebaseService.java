package com.example.demo;

import Models.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import org.springframework.stereotype.Service;

@Service
public class FirebaseService {


    public void registerClient(User user) throws FirebaseAuthException {
        FirebaseAuth auth = FirebaseAuth.getInstance();
        UserRecord.CreateRequest request = new UserRecord.CreateRequest();
        request.setEmail(user.getEmail());
        request.setPassword(user.getPassword());
        auth.createUser(request);
    }
}
