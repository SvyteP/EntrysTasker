package com.example.entrystasker.repository;

import com.example.entrystasker.entity.UrgencyLevelEntity;
import org.springframework.data.repository.CrudRepository;

public interface UrgencyRepo extends CrudRepository<UrgencyLevelEntity,Long> {
}
