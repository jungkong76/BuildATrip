package com.example.buildatrip.controller;

import com.example.buildatrip.security.dto.MemberDto;
import com.example.buildatrip.security.service.MemUserDetailsService;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    private final MemUserDetailsService userDetailsService;

    public MainController(MemUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }


    @GetMapping("/")
    public String toIndex(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = "";
        if (authentication != null && !(authentication instanceof AnonymousAuthenticationToken)) {
            MemberDto user = (MemberDto) authentication.getPrincipal();
            userName = user.getMemName();
            System.out.println(userName);
        } else {
            System.out.println("비로그인 상태");
        }
        model.addAttribute("userName", userName);
        return "index.html";
    }

//    @ResponseBody
//    @GetMapping("/getUserDetails")
//    public UserDetails getAuthMem(String userName){
//        System.out.println("-----------------------------user: "+ userName);
//        UserDetails user = userDetailsService.loadUserByUsername(userName);
//        return user;
//    }
}
