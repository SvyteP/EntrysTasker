package com.example.entrystasker.repository;

import com.example.entrystasker.entity.StatusLevelEntity;
import org.springframework.data.repository.CrudRepository;

public interface StatusRepo extends CrudRepository<StatusLevelEntity,Long> {
}
