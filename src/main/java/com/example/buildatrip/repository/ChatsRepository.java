package com.example.buildatrip.repository;

import com.example.buildatrip.entity.Chats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface ChatsRepository extends JpaRepository<Chats, Long> {

}
