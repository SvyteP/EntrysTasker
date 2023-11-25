package com.example.entrystasker.model;

import com.example.entrystasker.entity.TaskEntity;
import com.example.entrystasker.entity.UserEntity;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data

public class User {

    private String name;
    private Roles role;
    private List<Task> tasklist;

    public static User tomodel (UserEntity entity){
        User model = new User();
        model.setName(entity.getName());
        model.setRole(Roles.tomodel(entity.getRole()));
        model.setTasklist(entity.getTasklist().stream().map(Task::tomodel).collect(Collectors.toList()));
        return model;
    }
}
