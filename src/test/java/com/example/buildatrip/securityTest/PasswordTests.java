package com.example.buildatrip.securityTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest //어노테이션 잊지 말기
public class PasswordTests {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void testEncoder(){
        String password = "1111";
        String enPw = passwordEncoder.encode(password);

        System.out.println("enPw: " + enPw); //인코딩된 값은 늘 달라진다.

        boolean matchResult = passwordEncoder.matches(password, enPw);
        System.out.println("matchResult :"+matchResult); //true
    }

}
