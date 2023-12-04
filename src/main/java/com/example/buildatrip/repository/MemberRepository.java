package com.example.buildatrip.repository;

import com.example.buildatrip.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long>{

    @Query("select m from Member m where m.memId =:mem_id and m.fromSocial =:from_social")
    Optional<Member> findByMemId(String mem_id, boolean from_social);

    int countByMemId(String mem_id);

    int countByMemName(String mem_name);
}
