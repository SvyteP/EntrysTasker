package com.example.entrystasker.controller;

import com.example.entrystasker.dto.LoginDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/api")
public class MainController {
    @GetMapping("/login")
    public ResponseEntity login(@RequestBody LoginDto user){
        try {
            return ResponseEntity.ok().body(user);
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().body("Error login");
        }
    }
    @GetMapping("/")
    public String home(){
            return"index";
    }

}
