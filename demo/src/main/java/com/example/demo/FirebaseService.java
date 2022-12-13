package com.example.demo;

import Models.User;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.ActionCodeSettings;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import org.springframework.stereotype.Service;

import com.google.auth.oauth2.GoogleCredentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Service
public class FirebaseService {

    @Autowired
    private JavaMailSender javaMailSender;

    private FirebaseAuth firebaseAuth;


    @Value("firebase9yz23@gmail.com")
    private String sender;

    public void registerClient(User user) throws FirebaseAuthException {
        FirebaseAuth auth = FirebaseAuth.getInstance(); // pobieramy instancje uslugi Authentication z aplikacji firebase
        UserRecord.CreateRequest request = new UserRecord.CreateRequest(); // generujemy request usera, jest to tylko do dodania uzytkownika
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        request.setEmail(user.getEmail());
        request.setPassword(user.getPassword());
        auth.createUser(request); // wywołanie na instancji authentication dodania uzytkownika
        auth.generateEmailVerificationLink(user.getEmail());
        mailMessage.setFrom(sender);
        mailMessage.setTo(user.getEmail());
        mailMessage.setText("Hello, Follow this link to verify your email address. " + auth.generateEmailVerificationLink(user.getEmail()));
        mailMessage.setSubject("Account Verification");
        javaMailSender.send(mailMessage);
    }


    // PONIZEJ JAKIES INNE PODEJSCIE KTORE TEZ NIE DZIALAXD

    //    public FirebaseService() throws IOException {
//        FileInputStream serviceAccount = new FileInputStream("demo/src/main/resources/serviceAccountKey.json");
//
//        FirebaseOptions options = new FirebaseOptions.Builder()
//                .setCredentials(GoogleCredentials.fromStream(serviceAccount)).setDatabaseUrl("https://allegroceneo-2ac4f.firebaseio.com").build();
//
//        FirebaseApp.initializeApp(options);
//        firebaseAuth = FirebaseAuth.getInstance();
//    }

//    public void sendEmailVerification(String email) throws FirebaseAuthException, IOException {
//        firebaseAuth = FirebaseAuth.getInstance();
//        UserRecord user = firebaseAuth.getUserByEmail(email);
//        firebaseAuth.setCustomUserClaims(user.getUid(), Collections.singletonMap("email_verified", true));
//        firebaseAuth.sendEmailVerification(user.getUid());

//    }
}
//    public String sendSimpleMail(EmailDetails details) {
//
//        try {
//
//             Tworzenie maila
//            SimpleMailMessage mailMessage
//                    = new SimpleMailMessage();
//
//            mailMessage.setFrom(sender);
//            mailMessage.setTo(details.getRecipient());
//            mailMessage.setText(details.getMsgBody());
//            mailMessage.setSubject(details.getSubject());
//
//             golomp z przesylka leci
//            javaMailSender.send(mailMessage);
//            return "Mail Sent Successfully...";
//        }
//
//        catch (Exception e) {
//            return "Error while Sending Mail";
//        }
//    }

