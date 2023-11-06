package com.springboot.email.controller;

import com.springboot.email.service.SimpleMailService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleMailController {

    @Resource
    private SimpleMailService simpleMailService;


    @RequestMapping("sendSimpleMail")
    public void sendSimpleMail() {
        simpleMailService.sendSimpleMail();
        ;
    }

    @RequestMapping("sendFileMail")
    public void sendFileMail() {
        simpleMailService.sendFileMail();
    }

    @RequestMapping("sendThymleafMail")
    public void sendThymleafMail() {
        simpleMailService.sendThymleafMail();
    }
}
