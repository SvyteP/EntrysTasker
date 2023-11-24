package com.example.entrystasker.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @PostMapping("/create")
    public ResponseEntity createUser(){
        try {
            return ResponseEntity.ok().body("User creating");
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Error createUser | " +e.getMessage());
        }
    }
    @GetMapping("/get")
    public ResponseEntity getUser(){
        try {
            return ResponseEntity.ok().body("User");
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Error createUser  | " +e.getMessage());
        }
    }
    @PutMapping("/editing")
    public ResponseEntity editUser(){
        try{
            return ResponseEntity.ok().body("User Editing");
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Error editUser");
        }
    }
    @DeleteMapping("/del")
    public ResponseEntity delUser(){
        try{
            return ResponseEntity.ok().body("User deleting");
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Error delUser");
        }
    }
}
