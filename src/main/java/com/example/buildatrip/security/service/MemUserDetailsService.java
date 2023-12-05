package com.example.buildatrip.security.service;

import com.example.buildatrip.entity.Member;
import com.example.buildatrip.repository.MemberRepository;
import com.example.buildatrip.security.dto.MemberDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Log4j2
@Service
public class MemUserDetailsService implements UserDetailsService {

    private final MemberRepository memberRepository;

    public MemUserDetailsService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //log.info("MemUserDetailsService에서 loadUserByUsername한 결과 : " + username);

        Optional<Member> result = memberRepository.findByMemId(username, false);

        if(result.isEmpty()){
            throw new UsernameNotFoundException("check Email");
        }

        Member member = result.get();
        //log.info("-------------------"+ member);

        MemberDto authMember = new MemberDto(member.getMemId(), member.getMemPw(), member.isFromSocial(),
                                        Collections.singletonList(new SimpleGrantedAuthority("ROLE_"+member.getMemRole())));

        authMember.setMemName(member.getMemName());
        return authMember;
    }
}
