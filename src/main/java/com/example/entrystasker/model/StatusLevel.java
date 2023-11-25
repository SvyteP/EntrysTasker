package com.example.entrystasker.model;

import com.example.entrystasker.entity.StatusLevelEntity;
import lombok.Data;

@Data
public class StatusLevel {
    private String nameStatus;
    public static StatusLevel tomodel (StatusLevelEntity entity){
        StatusLevel model = new StatusLevel();
        model.setNameStatus(entity.getNameStatus());
        return model;
    }
}
