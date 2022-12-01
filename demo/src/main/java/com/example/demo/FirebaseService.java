package com.example.demo;

import Models.User;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.*;
import com.google.firebase.auth.internal.FirebaseCustomAuthToken;
import com.google.firebase.auth.internal.FirebaseTokenFactory;
import com.google.firebase.cloud.FirestoreClient;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.iid.FirebaseInstanceId;
import org.springframework.stereotype.Service;
import com.google.firebase.messaging.*;
@Service
public class FirebaseService {


    public void registerClient(User user) throws FirebaseAuthException {
        FirebaseAuth auth = FirebaseAuth.getInstance();
        UserRecord.CreateRequest request = new UserRecord.CreateRequest();
        request.setEmail(user.getEmail());
        request.setPassword(user.getPassword());
        auth.generateEmailVerificationLink(user.getEmail());
        auth.createUser(request);
    }
}
