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
    private Long iNo;

    @ManyToOne
    private Comment comment;

    @Column(nullable = false)
    private String ogName;

    @Column(nullable = false, length = 500)
    private String fileName;

    @Column(nullable = false, length = 500)
    private String filePath;

    private int fileSize;

    @Column(nullable = false)
    private LocalDateTime createdDate;

}
