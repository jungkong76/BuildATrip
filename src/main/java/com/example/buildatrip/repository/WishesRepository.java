package com.example.buildatrip.repository;

import com.example.buildatrip.entity.Wishes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface WishesRepository extends JpaRepository<Wishes, Long>{

}
