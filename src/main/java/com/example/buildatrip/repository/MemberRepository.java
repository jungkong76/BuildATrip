package com.example.buildatrip.repository;

import com.example.buildatrip.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long>, QuerydslPredicateExecutor<Member> {

    @Query("select m from Member m where m.mem_id =:mem_id and m.from_social =:from_social")
    Optional<Member> findByMem_id(String mem_id, boolean from_social);
}
