package com.example.entrystasker.service;

import com.example.entrystasker.entity.SubTasksEntity;
import com.example.entrystasker.entity.TaskEntity;
import com.example.entrystasker.exception.TaskNotFoundException;
import com.example.entrystasker.model.SubTasks;
import com.example.entrystasker.model.Task;
import com.example.entrystasker.repository.StatusRepo;
import com.example.entrystasker.repository.SubtaskRepo;
import com.example.entrystasker.repository.TaskRepo;
import com.example.entrystasker.repository.UrgencyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubTaskService {

    TaskRepo taskRepo;
    SubtaskRepo subtaskRepo;
    StatusRepo statusRepo;
    UrgencyRepo urgencyRepo;
    @Autowired
    public SubTaskService(TaskRepo taskRepo, SubtaskRepo subtaskRepo, StatusRepo statusRepo, UrgencyRepo urgencyRepo) {
        this.taskRepo = taskRepo;
        this.subtaskRepo = subtaskRepo;
        this.statusRepo = statusRepo;
        this.urgencyRepo = urgencyRepo;
    }

    public String createSubTask (SubTasksEntity task, Long status_id, Long urgency_id,Long task_id) throws TaskNotFoundException {

        if(subtaskRepo.findByTask_name(task.getTask_name()) != null){
            throw new TaskNotFoundException("Данная задача уже существует!");
        }

        task.setStatus(statusRepo.findById(status_id).get().getNameStatus());
        task.setUrgency(urgencyRepo.findById(urgency_id).get().getUrgencyName());
        taskRepo.findById(task_id).get().getSubtasksList().add(task);
        subtaskRepo.save(task);
        return "Задача создана!";
    }

    public SubTasks getTask (Long id) throws  TaskNotFoundException {
        if(subtaskRepo.findById(id).isEmpty()){
            throw new TaskNotFoundException("Задача не найдена!");
        }
        return SubTasks.tomodel(subtaskRepo.findById(id).get());
    }

    public String editTask(SubTasksEntity editingTask,Long id) throws TaskNotFoundException {
        if (subtaskRepo.findById(id).isEmpty()){
            throw new TaskNotFoundException("Задача не найдена");
        }
        SubTasksEntity task = subtaskRepo.findById(id).get();
        task.setTask_name(editingTask.getTask_name());
        subtaskRepo.save(task);
        return "Задача изменена!";
    }
    public String deleteTask (Long id) throws TaskNotFoundException {
        subtaskRepo.findById(id).orElseThrow(() -> new TaskNotFoundException("Задача не найдена!"));
        subtaskRepo.deleteById(id);
        return "Задача удалена!";
    }

}
