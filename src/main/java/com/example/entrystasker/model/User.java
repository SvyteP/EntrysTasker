package com.example.entrystasker.model;

import com.example.entrystasker.entity.UserEntity;
import lombok.Data;

@Data

public class User {

    private String name;
    private String role;
    private String tasklist;

    public static User tomodel (UserEntity entity){
        User model = new User();
        model.setName(entity.getName());
        model.setRole(entity.getRole());
        model.setTasklist(entity.getTasklist());
        return model;
    }
}
