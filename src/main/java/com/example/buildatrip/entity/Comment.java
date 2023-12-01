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
    private Long c_no;

    @ManyToOne
    @JoinColumn(name = "user_no", referencedColumnName = "mem_no")
    private Member user;

    private float c_score;

    @Column(length = 1000)
    private String c_content;
    private int pCode;
}
