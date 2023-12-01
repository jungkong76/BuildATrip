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
                    .mem_id("user" + i + "@naver.com")
                    .mem_pw(passwordEncoder.encode("1111"))
                    .mem_name("사용자" + i)
                    .mem_gender(0)
                    .fromSocial(0)
                    .is_admin(0)
                    .mem_age(22)
                    .created_at(LocalDateTime.now())
                    .build();
            memberRepository.save(member);
        });

        Member mem = Member.builder()
                .mem_id("user" + 101 + "@naver.com")
                .mem_pw(passwordEncoder.encode("1111"))
                .mem_name("사용자" + 101)
                .mem_gender(0)
                .fromSocial(0)
                .is_admin(1)
                .mem_age(26)
                .created_at(LocalDateTime.now())
                .build();
        memberRepository.save(mem);
    }
}
