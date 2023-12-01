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
@ToString(exclude = {"from_member", "to_member"})
@Builder
public class ChatRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cr_no;

    @ManyToOne
    @JoinColumn(name = "from_no", referencedColumnName = "mem_no")
    private Member from_member;

    @ManyToOne
    @JoinColumn(name = "to_no", referencedColumnName = "mem_no")
    private Member to_member;

    @Column(nullable = false)
    private LocalDateTime reg_date;
}
