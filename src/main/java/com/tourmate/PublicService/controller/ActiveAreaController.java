package com.tourmate.PublicService.controller;

import com.tourmate.PublicService.dto.ActiveAreaDto;
import com.tourmate.PublicService.service.ActiveAreaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/active-areas")
@RequiredArgsConstructor
public class ActiveAreaController {
    private final ActiveAreaService activeAreaService;

    @GetMapping
    public List<ActiveAreaDto> getAll() {
        return activeAreaService.getAll();
    }

    @GetMapping("/{id}")
    public ActiveAreaDto getById(@PathVariable Integer id) {
        return activeAreaService.getById(id);
    }

    @PostMapping
    public ActiveAreaDto create(@RequestBody ActiveAreaDto activeAreaDto) {
        return activeAreaService.create(activeAreaDto);
    }

    @PutMapping("/{id}")
    public ActiveAreaDto update(@PathVariable Integer id, @RequestBody ActiveAreaDto activeAreaDto) {
        return activeAreaService.update(id, activeAreaDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        activeAreaService.delete(id);
    }


}
