package com.example.buildatrip.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = "user")
public class Comment extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cNo;

    @ManyToOne
    @JoinColumn(name = "userNo", referencedColumnName = "memNo")
    private Member user;

    private float cScore;

    @Column(length = 1000)
    private String cContent;
    private int pCode;
}
