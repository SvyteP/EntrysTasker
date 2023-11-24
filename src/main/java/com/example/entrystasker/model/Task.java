package com.example.entrystasker.model;

import lombok.Data;

@Data
public class Task {
    private String task_name;
    private String subtasksList;
    private int status;
    private int urgency;
    public static Task tomodel (Task entity){
        Task model = new Task();
        model.setStatus(entity.getStatus());
        model.setTask_name(entity.getTask_name());
        model.setSubtasksList(entity.getSubtasksList());
        model.setUrgency(entity.getUrgency());
        return model;
    }
}
