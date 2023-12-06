package com.example.buildatrip.controller;

import com.example.buildatrip.security.dto.MemberDto;
import com.example.buildatrip.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@PropertySource("classpath:application-oauth.properties")
@RequiredArgsConstructor
public class MainController {
    @Value("${spring.security.oauth2.client.registration.kakao.client-id}")
    private String client_id;

    private final MemberService memberService;


    @GetMapping("/")
    public String toIndex(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = "";
        if (authentication != null && !(authentication instanceof AnonymousAuthenticationToken)) {
            MemberDto user = (MemberDto) authentication.getPrincipal();
            userName = user.getMemName();
            System.out.println(userName);
        }
        model.addAttribute("userName", userName);
        return "index.html";
    }

//    @ResponseBody  //oauth 인증중 ajax 실행되면 세션이 채워지지 않은 상태에서 userDetails를 불러오기 때문에 삭제했음.
//    @GetMapping("/getUserDetails")
//    public UserDetails getAuthMem(String userName){
//        System.out.println("-----------------------------user: "+ userName);
//        UserDetails user = userDetailsService.loadUserByUsername(userName);
//        return user;
//    }
}
