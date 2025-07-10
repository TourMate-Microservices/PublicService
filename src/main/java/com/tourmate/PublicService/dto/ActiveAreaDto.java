package com.tourmate.PublicService.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ActiveAreaDto {
    private Integer areaId;

    private String areaName;

    private String areaTitle;

    private String areaSubtitle;

    private String areaContent;

    private String bannerImg;

    private String areaType;

    private LocalDateTime createdAt;
}
