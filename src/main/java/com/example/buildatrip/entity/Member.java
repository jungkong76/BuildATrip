package com.example.buildatrip.entity;

import javax.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@Builder
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mem_no;

    @Column(nullable = false)
    private String mem_id;
    @Column(nullable = false)
    private String mem_pw;
    @Column(nullable = false)
    private String mem_name;
    private int mem_age;

    private char mem_gender;

    @Column(nullable = false,columnDefinition = "VARCHAR(255) DEFAULT 'USER'")
    private String mem_role;

    @Column(nullable = false)
    private LocalDateTime created_at;

    @Column(nullable = false, columnDefinition = "boolean default false")
    private boolean from_social;
}
