package model;

import entity.UserEntity;
import lombok.Data;

@Data
public class subtasks {
    private String task_name;
    private int status;
    private int urgency;
    public static subtasks tomodel (subtasks entity){
        subtasks model = new subtasks();
        model.setStatus(entity.getStatus());
        model.setUrgency(entity.getUrgency());
        model.setTask_name(entity.getTask_name());
        return model;
    }
}