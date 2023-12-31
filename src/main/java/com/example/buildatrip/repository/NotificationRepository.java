package com.example.buildatrip.repository;

import com.example.buildatrip.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface NotificationRepository extends JpaRepository<Notification, Long> {

}
