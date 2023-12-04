package com.example.buildatrip.entity;

import javax.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@ToString(exclude = "member")
public class PlanList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long plNo;

    @ManyToOne
    @JoinColumn(name="user_no", referencedColumnName = "memNo")
    private Member member;

    @Column(nullable = false)
    private String plName;

    @Column(nullable = false, length = 500)
    private String plDescription;

    @Column(nullable = false)
    private LocalDateTime regDate;

    @Column(nullable = false)
    private LocalDateTime startDate;

    @Column(nullable = false)
    private LocalDateTime endDate;
}
