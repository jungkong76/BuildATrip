package com.example.buildatrip.service;

import com.example.buildatrip.entity.Member;
import com.example.buildatrip.repository.MemberRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public int countEmail(String mem_id){
    return memberRepository.countByMemId(mem_id);
    };

    public int countNickName(String mem_name){
        return memberRepository.countByMemName(mem_name);
    };

    public void enrollMember (Member member) {memberRepository.save(member);};
}
