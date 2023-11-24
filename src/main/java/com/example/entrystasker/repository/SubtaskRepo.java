package com.example.entrystasker.repository;

import com.example.entrystasker.entity.SubtasksEntity;
import org.springframework.data.repository.CrudRepository;

public interface SubtaskRepo extends CrudRepository<SubtasksEntity,Long> {
}
