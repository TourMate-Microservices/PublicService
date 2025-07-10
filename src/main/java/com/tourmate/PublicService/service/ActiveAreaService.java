package com.tourmate.PublicService.service;

import com.tourmate.PublicService.dto.ActiveAreaDto;

import java.util.List;

public interface ActiveAreaService {
    List<ActiveAreaDto> getAll();

    ActiveAreaDto getById(Integer areaId);

    ActiveAreaDto create(ActiveAreaDto activeAreaDto);

    ActiveAreaDto update(Integer id,ActiveAreaDto activeAreaDto);

    void delete(Integer areaId);

}
