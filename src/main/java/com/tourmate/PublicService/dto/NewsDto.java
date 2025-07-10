package com.tourmate.PublicService.dto;

import jakarta.persistence.Column;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class NewsDto {
    private Integer newsId;

    private String title;

    private LocalDateTime createdAt;

    private String content;

    private String bannerImg;

    private String category;

}
