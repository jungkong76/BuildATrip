package com.example.buildatrip.repository;

import com.example.buildatrip.entity.Plans;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface PlansRepository extends JpaRepository<Plans, Long>, QuerydslPredicateExecutor<Plans> {

}
