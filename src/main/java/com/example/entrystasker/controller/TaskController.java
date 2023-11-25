package com.example.entrystasker.controller;

import com.example.entrystasker.entity.TaskEntity;
import com.example.entrystasker.repository.SubtaskRepo;
import com.example.entrystasker.repository.TaskRepo;
import com.example.entrystasker.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/task")
public class TaskController {
    TaskRepo taskRepo;
    SubtaskRepo subtaskRepo;
    TaskService taskService;
    @Autowired
    public TaskController(TaskRepo taskRepo, SubtaskRepo subtaskRepo, TaskService taskService) {
        this.taskRepo = taskRepo;
        this.subtaskRepo = subtaskRepo;
        this.taskService = taskService;
    }

    @PostMapping("/create")
    public ResponseEntity createTask(@RequestBody TaskEntity task,
                                     @RequestParam Long status_id,
                                     @RequestParam Long urgency_id){
        try {
            taskService.createTask(task,status_id,urgency_id);
            return ResponseEntity.ok().body("Задача создана!");
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Error createTask | " +e.getMessage());
        }
    }
    @GetMapping("/get")
    public ResponseEntity getTask(@RequestParam Long task_id){
        try {
            return ResponseEntity.ok().body(taskService.getTask(task_id));
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Error getTask | " +e.getMessage());
        }
    }
    @PutMapping("/editing")
    public ResponseEntity editTask(@RequestBody TaskEntity task,
                                   @RequestParam Long task_id)
    {
        try{

            return ResponseEntity.ok().body(taskService.editTask(task,task_id));
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Error editiTask");
        }
    }
    @DeleteMapping("/del")
    public ResponseEntity delTask(@RequestParam Long task_id){
        try{
            return ResponseEntity.ok().body(taskService.deleteTask(task_id));
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Error delTask");
        }
    }

}
