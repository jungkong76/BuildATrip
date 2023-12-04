package com.example.buildatrip.securityTest;

import com.example.buildatrip.entity.Member;
import com.example.buildatrip.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;
import java.util.stream.IntStream;

@SpringBootTest
public class MemberTests {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void insertDummyMembers() {
        IntStream.rangeClosed(1, 100).forEach(i -> {
            Member member = Member.builder()
                    .memId("user" + i + "@naver.com")
                    .memPw(passwordEncoder.encode("1111"))
                    .memName("사용자" + i)
                    .memGender("M")
                    .fromSocial(false)
                    .memRole("USER")
                    .memAge(22)
                    .createdAt(LocalDateTime.now())
                    .build();
            memberRepository.save(member);
        });

        Member mem = Member.builder()
                .memId("dlwjdqls0706@naver.com")
                .memPw(passwordEncoder.encode("1111"))
                .memName("돈비니")
                .memGender("F")
                .fromSocial(false)
                .memRole("ADMIN")
                .memAge(26)
                .createdAt(LocalDateTime.now())
                .build();
        memberRepository.save(mem);
    }
}
