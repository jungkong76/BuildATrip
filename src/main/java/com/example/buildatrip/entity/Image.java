package com.example.buildatrip.entity;

import javax.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "comment")
@Getter
@Builder
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long i_no;

    @ManyToOne
    private Comment comment;

    @Column(nullable = false)
    private String og_name;

    @Column(nullable = false, length = 500)
    private String file_name;

    @Column(nullable = false, length = 500)
    private String file_path;

    private int file_size;

    @Column(nullable = false)
    private LocalDateTime created_date;

}
