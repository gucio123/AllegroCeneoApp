package com.example.demo;

//package com.SpringBootEmail.Entity;

// Importing required classes
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//import org.springframework.web.bind.annotation.RestController;

// Annotations
@Data
@AllArgsConstructor
@NoArgsConstructor

// Class
public class EmailDetails {

    // Class data members
    private String recipient;
    private String msgBody;
    private String subject;
//    private String attachment;
}