package com.tourmate.PublicService.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


@Entity
@Table(name = "News")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Getter
@Setter
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "newsId")
    private Integer newsId;

    @Column(name = "title", nullable = false, length = 255)
    private String title;

    @Column(name = "createdAt", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "content", nullable = false, columnDefinition = "TEXT")
    private String content;

    @Column(name = "bannerImg", nullable = false, length = 255)
    private String bannerImg;

    @Column(name = "category", length = 255)
    private String category;


}
