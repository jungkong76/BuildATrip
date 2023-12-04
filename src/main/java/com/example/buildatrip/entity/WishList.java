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
public class WishList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long wlNo;

    @ManyToOne
    @JoinColumn(name = "user_no", referencedColumnName = "memNo")
    private Member member;

    @Column(nullable = false, length = 100)
    private String wlName;

    @Column(nullable = false)
    private LocalDateTime regDate;
}
