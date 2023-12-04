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
    private Long memNo;

    @Column(nullable = false)
    private String memId;
    @Column(nullable = false)
    private String memPw;
    @Column(nullable = false)
    private String memName;
    private int memAge;

    private String memGender;

    @Column(nullable = false,columnDefinition = "VARCHAR(255) DEFAULT 'USER'")
    private String memRole;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false, columnDefinition = "boolean default false")
    private boolean fromSocial;
}
