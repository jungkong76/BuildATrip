package com.example.buildatrip.entity;

import javax.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@ToString(exclude = "wishList")
public class Wishes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long wNo;

    @ManyToOne
    private WishList wishList;

    private int pCode;

    @Column(nullable = false)
    private LocalDateTime regDate;
}
