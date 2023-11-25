package com.example.entrystasker.repository;

import com.example.entrystasker.entity.SubTasksEntity;
import org.springframework.data.repository.CrudRepository;

public interface SubtaskRepo extends CrudRepository<SubTasksEntity,Long> {
    SubTasksEntity findByTask_name(String taskName);
}
