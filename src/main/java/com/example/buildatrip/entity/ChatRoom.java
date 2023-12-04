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
@ToString(exclude = {"fromMember", "toMember"})
@Builder
public class ChatRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long crNo;

    @ManyToOne
    @JoinColumn(name = "fromNo", referencedColumnName = "memNo")
    private Member fromMember;

    @ManyToOne
    @JoinColumn(name = "toNo", referencedColumnName = "memNo")
    private Member toMember;

    @Column(nullable = false)
    private LocalDateTime regDate;
}
