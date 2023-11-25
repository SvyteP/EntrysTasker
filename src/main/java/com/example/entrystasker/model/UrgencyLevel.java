package com.example.entrystasker.model;

import com.example.entrystasker.entity.UrgencyLevelEntity;
import lombok.Data;

@Data
public class UrgencyLevel {
    private String nameUrgency;
    public static UrgencyLevel tomodel (UrgencyLevelEntity entity){
        UrgencyLevel model = new UrgencyLevel();
        model.setNameUrgency(entity.getUrgencyName());
        return model;
    }
}
