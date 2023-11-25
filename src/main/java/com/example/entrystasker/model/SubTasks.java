package com.example.entrystasker.model;

import com.example.entrystasker.entity.SubTasksEntity;
import lombok.Data;

@Data
public class SubTasks {
    private String task_name;
    private StatusLevel status;
    private UrgencyLevel urgency;
    public static SubTasks tomodel (SubTasksEntity entity){
        SubTasks model = new SubTasks();
        model.setStatus(StatusLevel.tomodel(entity.getStatus()));
        model.setUrgency(UrgencyLevel.tomodel(entity.getUrgency()));
        model.setTask_name(entity.getTask_name());
        return model;
    }
}