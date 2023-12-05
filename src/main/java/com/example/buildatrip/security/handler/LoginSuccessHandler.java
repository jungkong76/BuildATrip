package com.example.buildatrip.security.handler;

import com.example.buildatrip.security.dto.MemberDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Log4j2
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    private RedirectStrategy redirectStratgy = new DefaultRedirectStrategy();
    private PasswordEncoder passwordEncoder;

    public LoginSuccessHandler(){
        passwordEncoder  = new BCryptPasswordEncoder();
    }

    public LoginSuccessHandler(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        MemberDto memberDto = (MemberDto) authentication.getPrincipal();

        boolean fromSocial = memberDto.isFromSocial();
//        boolean password = passwordEncoder.matches("1111", memberDto.getMemPw());
        log.debug("Saving user info to session: {}", memberDto);
        if(fromSocial){
            SecurityContextHolder.getContext().setAuthentication(authentication);
            redirectStratgy.sendRedirect(request,response,  request.getContextPath() + "/");
        }
    }
}
