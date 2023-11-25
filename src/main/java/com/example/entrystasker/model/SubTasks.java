package com.example.entrystasker.model;

import com.example.entrystasker.entity.SubTasksEntity;
import lombok.Data;

@Data
public class SubTasks {
    private String task_name;
    private String status;
    private String urgency;
    public static SubTasks tomodel (SubTasksEntity entity){
        SubTasks model = new SubTasks();
        model.setStatus(entity.getStatus());
        model.setUrgency(entity.getUrgency());
        model.setTask_name(entity.getTask_name());
        return model;
    }
}