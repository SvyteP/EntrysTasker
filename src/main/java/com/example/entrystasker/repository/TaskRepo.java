package com.example.entrystasker.repository;

import com.example.entrystasker.entity.TaskEntity;
import org.springframework.data.repository.CrudRepository;
public interface TaskRepo extends CrudRepository<TaskEntity,Long> {
    TaskRepo findByTaskName(String taskName);
}
