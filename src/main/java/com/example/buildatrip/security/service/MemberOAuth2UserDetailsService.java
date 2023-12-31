package com.example.buildatrip.security.service;

import com.example.buildatrip.entity.Member;
import com.example.buildatrip.repository.MemberRepository;
import com.example.buildatrip.security.dto.MemberDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;

@Service
public class MemberOAuth2UserDetailsService extends DefaultOAuth2UserService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        String client = userRequest.getClientRegistration().getClientName();
        System.out.println("------------어느 소셜? : " + client);

        OAuth2User oAuth2User = super.loadUser(userRequest);
        System.out.println("-------------자료 형태: "+oAuth2User.getAttributes());

        String email = "";
        String name = "";

        if(client.equals("Google")){
            email = oAuth2User.getAttribute("email");
            name = oAuth2User.getAttribute("name");
        } else if(client.equals("Naver")){
            Map<String, Object> response = oAuth2User.getAttribute("response");
            email = (String) response.get("email");
            name = (String) response.get("name");
        } else if(client.equals("Kakao")){ // 카카오 로그인
            Map<String, Object> attributes = oAuth2User.getAttributes();
            Map<String, Object> kakaoAccount = (Map<String, Object>) attributes.get("kakao_account");
            email = (String) kakaoAccount.get("email");
            Map<String, Object> profile = (Map<String, Object>) kakaoAccount.get("profile");
            name = (String) profile.get("nickname");
        }

        Member authMem = saveSocialMember(email, name);

        MemberDto memberDto = new MemberDto(
                authMem.getMemId(), authMem.getMemPw(),true,
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_"+authMem.getMemRole())),
                oAuth2User.getAttributes());
        memberDto.setMemName(authMem.getMemName());
        memberDto.setMemAge(authMem.getMemAge());
        memberDto.setMemGender(authMem.getMemGender());
        return memberDto;
    }

    public Member saveSocialMember(String email, String name){

        Optional<Member> result = memberRepository.findByMemId(email,true);

        if(result.isPresent()){
            return result.get();
        } else {
            if(name == null){
                name = email;
            }

            //이미 있는 닉네임이면 name(n+1)
            if(memberRepository.countByMemName(name) > 0){
                name += "("+ (memberRepository.countByMemName(name) + 1) +")";
            }

            Member member = Member.builder()
                    .memId(email)
                    .memName(name)
                    .memPw("111111")
                    .fromSocial(true)
                    .memGender("N")
                    .memAge(0)
                    .memRole("USER")
                    .createdAt(LocalDateTime.now())
                    .build();
            memberRepository.save(member);

            return member;
        }

    }
}
