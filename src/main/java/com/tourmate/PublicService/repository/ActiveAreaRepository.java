package com.tourmate.PublicService.repository;

import com.tourmate.PublicService.entity.ActiveArea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActiveAreaRepository extends JpaRepository<ActiveArea, Integer> {
}
