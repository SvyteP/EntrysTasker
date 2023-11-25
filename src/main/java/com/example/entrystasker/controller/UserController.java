package com.example.entrystasker.controller;

import com.example.entrystasker.dto.RegistrDto;
import com.example.entrystasker.entity.UserEntity;
import com.example.entrystasker.repository.UserRepo;
import com.example.entrystasker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
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
    public ResponseEntity getUser(@RequestParam Long user_id){
        try {
            return ResponseEntity.ok().body(userService.getUser(user_id));
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Error createUser  | " +e.getMessage());
        }
    }
    @PutMapping("/editing")
    public ResponseEntity editUser(@RequestBody UserEntity user,
                                   @RequestParam Long user_id){
        try{
            return ResponseEntity.ok().body(userService.editUser(user,user_id));
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Error editUser");
        }
    }
    @DeleteMapping("/del")
    public ResponseEntity delUser(@RequestParam Long user_id){
        try{
            return ResponseEntity.ok().body(userService.delUser(user_id));
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Error delUser");
        }
    }
}
