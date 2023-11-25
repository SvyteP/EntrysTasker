package com.example.entrystasker.dto;

import com.example.entrystasker.entity.UserEntity;
import lombok.Data;

@Data
public class RegistrDto{
    private String userName;
    private String email;
    private String password;
}
