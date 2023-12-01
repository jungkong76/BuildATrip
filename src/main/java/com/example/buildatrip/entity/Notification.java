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
    private Long n_no;

    @ManyToOne
    @JoinColumn(name = "writer", referencedColumnName = "mem_no")
    private Member member;

    @Column(nullable = false)
    private String n_title;

    @Column(nullable = false)
    private String n_content;

    private int n_count;
}
