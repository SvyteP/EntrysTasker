package com.example.entrystasker.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/task")
public class TaskController {

    @PostMapping("/create")
    public ResponseEntity createTask(){
        try {
            return ResponseEntity.ok().body("Task created");
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Error createTask | " +e.getMessage());
        }
    }
    @GetMapping("/get")
    public ResponseEntity getTask(){
        try {
            return ResponseEntity.ok().body("Task created");
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Error createTask | " +e.getMessage());
        }
    }
    @PutMapping("/editing")
    public ResponseEntity editTask(){
        try{
            return ResponseEntity.ok().body("Task Editing");
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Error editiTask");
        }
    }
    @DeleteMapping("/del")
    public ResponseEntity delTask(){
        try{
            return ResponseEntity.ok().body("Task deleting");
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Error delTask");
        }
    }

}
