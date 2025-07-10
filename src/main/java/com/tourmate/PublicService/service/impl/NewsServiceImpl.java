package com.tourmate.PublicService.service.impl;

import com.tourmate.PublicService.dto.NewsDto;
import com.tourmate.PublicService.entity.News;
import com.tourmate.PublicService.mapper.NewsMapper;
import com.tourmate.PublicService.repository.NewsRepository;
import com.tourmate.PublicService.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NewsServiceImpl implements NewsService {
    private final NewsRepository repository;

    @Override
    public List<NewsDto> getAll() {
        return repository.findAll().stream()
                .map(NewsMapper::toDto)
                .toList();
    }

    @Override
    public NewsDto getById(Integer id) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("News not found"));
        return NewsMapper.toDto(entity);
    }

    @Override
    public NewsDto create(NewsDto newsDto) {
        News entity = NewsMapper.toEntity(newsDto);
        entity.setCreatedAt(LocalDateTime.now());
        News savedEntity = repository.save(entity);
        return NewsMapper.toDto(savedEntity);
    }

    @Override
    public NewsDto update(Integer id, NewsDto newsDto) {
        var existed = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("News not found"));
        existed.setTitle(newsDto.getTitle());
        existed.setContent(newsDto.getContent());
        existed.setBannerImg(newsDto.getBannerImg());
        existed.setCategory(newsDto.getCategory());
        News savedEntity = repository.save(existed);
        return NewsMapper.toDto(savedEntity);
    }

    @Override
    public void delete(Integer id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("News not found");
        }
        repository.deleteById(id);
    }
}
