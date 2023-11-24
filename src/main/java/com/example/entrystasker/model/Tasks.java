package com.example.entrystasker.model;

import lombok.Data;

@Data
public class Tasks {
    private String task_name;
    private String subtasksList;
    private int status;
    private int urgency;
    public static Tasks tomodel (Tasks entity){
        Tasks model = new Tasks();
        model.setStatus(entity.getStatus());
        model.setTask_name(entity.getTask_name());
        model.setSubtasksList(entity.getSubtasksList());
        model.setUrgency(entity.getUrgency());
        return model;
    }
}
