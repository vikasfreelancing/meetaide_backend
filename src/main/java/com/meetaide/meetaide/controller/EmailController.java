package com.meetaide.meetaide.controller;

import com.meetaide.meetaide.service.SendEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/email")
public class EmailController {

    @Autowired
    SendEmailService sendEmailService;
    @GetMapping
    public String sendEmail(@RequestParam("to") String email){
        System.out.println(email);
        sendEmailService.sendEmail(email);
        return "SUCESS";
    }
}
