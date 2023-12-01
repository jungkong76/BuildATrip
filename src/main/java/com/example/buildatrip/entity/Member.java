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

    private int mem_gender;

    @Column(nullable = false, columnDefinition = "int default 0")
    private int is_admin;

    @Column(nullable = false)
    private LocalDateTime created_at;

    @Column(columnDefinition = "int default 0")
    private int fromSocial;


}
