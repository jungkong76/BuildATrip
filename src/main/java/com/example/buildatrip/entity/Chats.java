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
    private Long ch_no;

    @ManyToOne
    @JoinColumn(name = "cr_no", referencedColumnName = "cr_no")
    private ChatRoom chatRoom;

    @ManyToOne
    @JoinColumn(name = "sender", referencedColumnName = "mem_no")
    private Member send_mem;

    @ManyToOne
    @JoinColumn(name = "listener", referencedColumnName = "mem_no")
    private Member listen_mem;

    @Column(length = 1000, nullable = false)
    private String ch_content;

    @Column(nullable = false)
    private LocalDateTime sent_date;

    @Column(columnDefinition = "int default 0")
    private int is_read;

    private LocalDateTime read_date;
}
