package com.example.buildatrip.entity;

import javax.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Builder
public class Chats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long chNo;

    @ManyToOne
    @JoinColumn(name = "crNo", referencedColumnName = "crNo")
    private ChatRoom chatRoom;

    @ManyToOne
    @JoinColumn(name = "sender", referencedColumnName = "memNo")
    private Member sendMem;

    @ManyToOne
    @JoinColumn(name = "listener", referencedColumnName = "memNo")
    private Member listenMem;

    @Column(length = 1000, nullable = false)
    private String chContent;

    @Column(nullable = false)
    private LocalDateTime sentDate;

    @Column(columnDefinition = "int default 0")
    private int isRead;

    private LocalDateTime readDate;
}
