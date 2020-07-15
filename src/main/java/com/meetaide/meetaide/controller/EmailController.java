package com.meetaide.meetaide.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.meetaide.meetaide.service.MailchimpService;
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
    MailchimpService sendEmailService;
    @GetMapping
    public String sendEmail(@RequestParam("to") String email) throws JsonProcessingException {
        System.out.println(email);
        sendEmailService.sendTestEmail(email);
        return "SUCESS";
    }
}
