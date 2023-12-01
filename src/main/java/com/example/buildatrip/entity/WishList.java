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
    private Long wl_no;

    @ManyToOne
    @JoinColumn(name = "user_no", referencedColumnName = "mem_no")
    private Member member;

    @Column(nullable = false, length = 100)
    private String wl_name;

    @Column(nullable = false)
    private LocalDateTime reg_date;
}
