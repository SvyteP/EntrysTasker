package com.example.entrystasker.service;

import com.example.entrystasker.entity.StatusLevelEntity;
import com.example.entrystasker.entity.TaskEntity;
import com.example.entrystasker.entity.UrgencyLevelEntity;
import com.example.entrystasker.exception.TaskNotFoundException;
import com.example.entrystasker.exception.UserAlreadyExistException;
import com.example.entrystasker.exception.UserNotFoundException;

import com.example.entrystasker.model.Task;
import com.example.entrystasker.repository.StatusRepo;
import com.example.entrystasker.repository.TaskRepo;
import com.example.entrystasker.repository.UrgencyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
    TaskRepo taskRepo;
    StatusRepo statusRepo;
    UrgencyRepo urgencyRepo;
    @Autowired
    public TaskService(TaskRepo taskRepo, StatusRepo statusRepo, UrgencyRepo urgencyRepo) {
        this.taskRepo = taskRepo;
        this.statusRepo = statusRepo;
        this.urgencyRepo = urgencyRepo;
    }

    public String createTask (TaskEntity task, Long status_id, Long urgency_id) throws TaskNotFoundException {

        if(taskRepo.findByTaskName(task.getTaskName()) != null){
            throw new TaskNotFoundException("Данная задача уже существует!");
        }


        task.setStatus(statusRepo.findById(status_id).get().getNameStatus());
        task.setUrgency(urgencyRepo.findById(urgency_id).get().getUrgencyName());
        taskRepo.save(task);
        return "Задача создана!";
    }

    public Task getTask (Long id) throws  TaskNotFoundException {
        if(taskRepo.findById(id).isEmpty()){
            throw new TaskNotFoundException("Задача не найдена!");
        }
        return Task.tomodel(taskRepo.findById(id).get());
    }

    public String editTask(TaskEntity editingTask,Long id) throws TaskNotFoundException {
        if (taskRepo.findById(id).isEmpty()){
            throw new TaskNotFoundException("Задача не найдена");
        }
        TaskEntity task = taskRepo.findById(id).get();
        task.setTaskName(editingTask.getTaskName());
        taskRepo.save(task);
        return "Задача изменена!";
    }
    public String deleteTask (Long id) throws TaskNotFoundException {
        taskRepo.findById(id).orElseThrow(() -> new TaskNotFoundException("Задача не найдена!"));
        taskRepo.deleteById(id);
        return "Задача удалена!";
    }

}
