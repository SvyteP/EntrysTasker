package com.example.entrystasker.model;

import lombok.Data;

@Data
public class Subtasks {
    private String task_name;
    private int status;
    private int urgency;
    public static Subtasks tomodel (Subtasks entity){
        Subtasks model = new Subtasks();
        model.setStatus(entity.getStatus());
        model.setUrgency(entity.getUrgency());
        model.setTask_name(entity.getTask_name());
        return model;
    }
}