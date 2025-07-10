package com.tourmate.PublicService.service.impl;

import com.tourmate.PublicService.dto.ActiveAreaDto;
import com.tourmate.PublicService.entity.ActiveArea;
import com.tourmate.PublicService.mapper.ActiveAreaMapper;
import com.tourmate.PublicService.repository.ActiveAreaRepository;
import com.tourmate.PublicService.service.ActiveAreaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ActiveAreaServiceImpl implements ActiveAreaService {
    private final ActiveAreaRepository repository;

    @Override
    public List<ActiveAreaDto> getAll() {
        return repository.findAll().stream()
                .map(ActiveAreaMapper::toDto)
                .toList();
    }

    @Override
    public ActiveAreaDto getById(Integer areaId) {
        var entity = repository.findById(areaId)
                .orElseThrow(() -> new RuntimeException("ActiveArea not found"));
        return ActiveAreaMapper.toDto(entity);
    }

    @Override
    public ActiveAreaDto create(ActiveAreaDto activeAreaDto) {
        ActiveArea entity = ActiveAreaMapper.toEntity(activeAreaDto);
        entity.setCreatedAt(LocalDateTime.now());
        ActiveArea savedEntity = repository.save(entity);
        return ActiveAreaMapper.toDto(savedEntity);
    }

    @Override
    public ActiveAreaDto update(Integer id, ActiveAreaDto activeAreaDto) {
        ActiveArea existed = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("ActiveArea not found"));

        existed.setAreaName(activeAreaDto.getAreaName());
        existed.setAreaTitle(activeAreaDto.getAreaTitle());
        existed.setAreaSubtitle(activeAreaDto.getAreaSubtitle());
        existed.setAreaContent(activeAreaDto.getAreaContent());
        existed.setBannerImg(activeAreaDto.getBannerImg());
        existed.setAreaType(activeAreaDto.getAreaType());

        ActiveArea savedEntity = repository.save(existed);
        return ActiveAreaMapper.toDto(savedEntity);
    }

    @Override
    public void delete(Integer areaId) {
        if (!repository.existsById(areaId)) {
            throw new RuntimeException("ActiveArea not found");
        }
        repository.deleteById(areaId);
    }
}
