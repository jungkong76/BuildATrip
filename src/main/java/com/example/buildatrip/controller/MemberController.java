package com.example.buildatrip.controller;

import com.example.buildatrip.entity.Member;
import com.example.buildatrip.security.dto.MemberDto;
import com.example.buildatrip.service.MemberService;
import com.example.buildatrip.serviceImpl.EmailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/member")
public class MemberController {
    private final EmailServiceImpl emailService;

    private final MemberService memberService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public MemberController(EmailServiceImpl emailService, MemberService memberService) {
        this.emailService = emailService;
        this.memberService = memberService;
    }

    @GetMapping("/join/joinForm")
    public void join() {
    }

    @ResponseBody
    @PostMapping("/join/checkEmail")
    public boolean checkEmail(String mem_id) {
        return memberService.countEmail(mem_id) == 0;
    }

    @ResponseBody
    @PostMapping("/join/sendCertCode")
    public Map<String, Object> sendCode(String mem_id) throws Exception {
        Map<String, Object> result = new HashMap<>();
        try {
            String signCode = emailService.sendCertificationMail(mem_id);
            result.put("success", true);
            result.put("signCode", signCode);
        } catch (Exception e) {
            result.put("success", false);
        }
        return result;
    }

    @ResponseBody
    @PostMapping("/join/checkNickName")
    public boolean checkName(String mem_name) {
        return memberService.countNickName(mem_name) == 0;
    }

    @PostMapping("/join/success")
    public String enrollSuccess(String memId, String memName, String memPw, String memGender, int memAge){
        Member member = Member.builder()
                .memId(memId)
                .memName(memName)
                .memPw(passwordEncoder.encode(memPw))
                .memGender(memGender)
                .memAge(memAge)
                .fromSocial(false)
                .memRole("USER")
                .createdAt(LocalDateTime.now())
                .build();
        System.out.println(member);
        memberService.enrollMember(member);
        return "/main";
    }
}
