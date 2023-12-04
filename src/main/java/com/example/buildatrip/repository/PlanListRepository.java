package com.example.buildatrip.repository;

import com.example.buildatrip.entity.PlanList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface PlanListRepository extends JpaRepository<PlanList, Long>{

}
