package com.tourmate.PublicService.mapper;

import com.tourmate.PublicService.dto.ActiveAreaDto;
import com.tourmate.PublicService.entity.ActiveArea;

public class ActiveAreaMapper {
    public static ActiveAreaDto toDto(ActiveArea activeArea) {
        if (activeArea == null) {
            return null;
        }
        
        ActiveAreaDto dto = new ActiveAreaDto();
        dto.setAreaId(activeArea.getAreaId());
        dto.setAreaName(activeArea.getAreaName());
        dto.setAreaTitle(activeArea.getAreaTitle());
        dto.setAreaSubtitle(activeArea.getAreaSubtitle());
        dto.setAreaContent(activeArea.getAreaContent());
        dto.setBannerImg(activeArea.getBannerImg());
        dto.setAreaType(activeArea.getAreaType());
        dto.setCreatedAt(activeArea.getCreatedAt());
        return dto;
    }

    public static ActiveArea toEntity(ActiveAreaDto activeAreaDto) {
        if (activeAreaDto == null) {
            return null;
        }
        
        ActiveArea entity = new ActiveArea();
        entity.setAreaId(activeAreaDto.getAreaId());
        entity.setAreaName(activeAreaDto.getAreaName());
        entity.setAreaTitle(activeAreaDto.getAreaTitle());
        entity.setAreaSubtitle(activeAreaDto.getAreaSubtitle());
        entity.setAreaContent(activeAreaDto.getAreaContent());
        entity.setBannerImg(activeAreaDto.getBannerImg());
        entity.setAreaType(activeAreaDto.getAreaType());
        entity.setCreatedAt(activeAreaDto.getCreatedAt());
        return entity;
    }
}
