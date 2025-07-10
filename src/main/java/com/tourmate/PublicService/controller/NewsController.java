package com.tourmate.PublicService.controller;

import com.tourmate.PublicService.dto.NewsDto;
import com.tourmate.PublicService.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/news")
@RequiredArgsConstructor
public class NewsController {
    private final NewsService newsService;

    @GetMapping
    public List<NewsDto> getAll() {
        return newsService.getAll();
    }

    @GetMapping("/{id}")
    public NewsDto getById(@PathVariable Integer id) {
        return newsService.getById(id);
    }

    @PostMapping
    public NewsDto create(@RequestBody NewsDto newsDto) {
        return newsService.create(newsDto);
    }

    @PutMapping("/{id}")
    public NewsDto update(@PathVariable Integer id, @RequestBody NewsDto newsDto) {
        return newsService.update(id, newsDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        newsService.delete(id);
    }
}
