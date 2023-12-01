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
    private Long w_no;

    @ManyToOne
    private WishList wishList;

    private int p_code;

    @Column(nullable = false)
    private LocalDateTime reg_date;
}
