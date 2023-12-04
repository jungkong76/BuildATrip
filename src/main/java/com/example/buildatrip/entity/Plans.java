package com.example.buildatrip.entity;

import javax.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "planList")
@Getter
@Builder
public class Plans extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pNo;

    @ManyToOne
    private PlanList planList;

    private int pCode;

    @Column(nullable = false, length = 500)
    private String pDescription;

    @Column(nullable = false)
    private LocalDateTime startDate;

    @Column(nullable = false)
    private LocalDateTime endDate;
}
