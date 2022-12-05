package com.example.demo;

//import com.example.demo.EmailDetails;
//import com.example.demo.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController

public class EmailController {

    @Autowired
    private EmailService emailService;

    // status wyslanego maila /sendEmail
    @PostMapping("/sendMail")
    public String
    sendMail(@RequestBody EmailDetails details) {
        String status
                = emailService.sendSimpleMail(details);

        return status;
    }
}

    // email z attachmentem, ale to sie nie przyda raczej
//    @PostMapping("/sendMailWithAttachment")
//    public String sendMailWithAttachment(
//            @RequestBody EmailDetails details)
//    {
//        String status
//                = emailService.sendMailWithAttachment(details);
//
//        return status;
//    }
