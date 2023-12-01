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
    private Long pl_no;

    @ManyToOne
    @JoinColumn(name="user_no", referencedColumnName = "mem_no")
    private Member member;

    @Column(nullable = false)
    private String pl_name;

    @Column(nullable = false, length = 500)
    private String pl_description;

    @Column(nullable = false)
    private LocalDateTime reg_date;

    @Column(nullable = false)
    private LocalDateTime start_date;

    @Column(nullable = false)
    private LocalDateTime end_date;

}
