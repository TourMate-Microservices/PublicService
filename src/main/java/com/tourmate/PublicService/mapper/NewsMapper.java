package com.tourmate.PublicService.mapper;

import com.tourmate.PublicService.dto.NewsDto;
import com.tourmate.PublicService.entity.News;

public class NewsMapper {
    public static NewsDto toDto(News news) {
        if (news == null) {
            return null;
        }
        
        NewsDto dto = new NewsDto();
        dto.setNewsId(news.getNewsId());
        dto.setTitle(news.getTitle());
        dto.setContent(news.getContent());
        dto.setBannerImg(news.getBannerImg());
        dto.setCreatedAt(news.getCreatedAt());
        dto.setCategory(news.getCategory());
        return dto;
    }

    public static News toEntity(NewsDto newsDto) {
        if (newsDto == null) {
            return null;
        }
        
        News news = new News();
        news.setNewsId(newsDto.getNewsId());
        news.setTitle(newsDto.getTitle());
        news.setContent(newsDto.getContent());
        news.setBannerImg(newsDto.getBannerImg());
        news.setCreatedAt(newsDto.getCreatedAt());
        news.setCategory(newsDto.getCategory());
        return news;
    }
}
