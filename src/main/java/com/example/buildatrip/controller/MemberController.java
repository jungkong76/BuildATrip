package com.example.buildatrip.controller;

import com.example.buildatrip.mail.service.EmailServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/member")
public class MemberController {
    private final EmailServiceImpl emailService;

    public MemberController(EmailServiceImpl emailService) {
        this.emailService = emailService;
    }

    @GetMapping("/join/joinForm")
    public void join(){}

    @ResponseBody
    @PostMapping("/join/sendCertCode")
    public String sendCode(String mem_id, String mem_name) throws Exception {
        return emailService.sendCertificationMail(mem_id,mem_name);
    }
}
