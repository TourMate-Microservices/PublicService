package com.tourmate.PublicService.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "ActiveArea")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ActiveArea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "areaId")
    private Integer areaId;

    @Column(name = "areaName", nullable = false, length = 255)
    private String areaName;

    @Column(name = "areaTitle", nullable = false, length = 255)
    private String areaTitle;

    @Column(name = "areaSubtitle", nullable = false, length = 255)
    private String areaSubtitle;

    @Column(name = "areaContent", nullable = false, columnDefinition = "TEXT")
    private String areaContent;

    @Column(name = "bannerImg", nullable = false, length = 255)
    private String bannerImg;

    @Column(name = "areaType", nullable = false, length = 50)
    private String areaType;

    @Column(name = "createdAt", nullable = false)
    private LocalDateTime createdAt;


}
