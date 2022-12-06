package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//import org.springframework.web.bind.annotation.RestController;


@Data
@AllArgsConstructor
@NoArgsConstructor


public class EmailDetails {

    private String recipient;
    private String msgBody;
    private String subject;
//    private String attachment;
}