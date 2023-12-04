package com.example.buildatrip.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "member")
@Builder
public class Notification extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long nNo;

    @ManyToOne
    @JoinColumn(name = "writer", referencedColumnName = "memNo")
    private Member member;

    @Column(nullable = false)
    private String nTitle;

    @Column(nullable = false)
    private String nContent;

    private int nCount;
}
