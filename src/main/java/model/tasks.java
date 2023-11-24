package model;

import entity.UserEntity;
import lombok.Data;

@Data
public class tasks {
    private String task_name;
    private String subtasksList;
    private int status;
    private int urgency;
    public static tasks tomodel (tasks entity){
        tasks model = new tasks();
        model.setStatus(entity.getStatus());
        model.setTask_name(entity.getTask_name());
        model.setSubtasksList(entity.getSubtasksList());
        model.setUrgency(entity.getUrgency());
        return model;
    }
}
