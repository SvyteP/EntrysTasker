package com.example.entrystasker.model;

import com.example.entrystasker.entity.TaskEntity;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class Task {
    private String task_name;
    private List<SubTasks> subtasksList;
    private StatusLevel status;
    private UrgencyLevel urgency;
    public static Task tomodel (TaskEntity entity){
        Task model = new Task();
        model.setStatus(StatusLevel.tomodel(entity.getStatus()));
        model.setTask_name(entity.getTaskName());
        model.setSubtasksList(entity.getSubtasksList().stream().map(SubTasks::tomodel).collect(Collectors.toList()));
        model.setUrgency(UrgencyLevel.tomodel(entity.getUrgency()));
        return model;
    }
}