package com.example.entrystasker.controller;

import com.example.entrystasker.dto.RegistrDto;
import com.example.entrystasker.entity.UserEntity;
import com.example.entrystasker.repository.UserRepo;
import com.example.entrystasker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    UserService userService;
    UserRepo userRepo;
    @Autowired
    public UserController(UserService userService, UserRepo userRepo) {
        this.userService = userService;
        this.userRepo = userRepo;
    }

    @PostMapping("/create")
    public ResponseEntity createUser(@RequestBody UserEntity user){
        try {

            return ResponseEntity.ok().body(userService.createUser(user));
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
