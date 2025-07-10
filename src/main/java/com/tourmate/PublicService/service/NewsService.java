package com.tourmate.PublicService.service;

import com.tourmate.PublicService.dto.ActiveAreaDto;
import com.tourmate.PublicService.dto.NewsDto;

import java.util.List;

public interface NewsService {
    List<NewsDto> getAll();

    NewsDto getById(Integer id);

    NewsDto create(NewsDto newsDto);

    NewsDto update(Integer id,NewsDto newsDto);

    void delete(Integer id);

}
