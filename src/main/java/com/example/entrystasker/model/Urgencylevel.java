package com.example.entrystasker.model;

import lombok.Data;

@Data
public class Urgencylevel {
    private String nameUrgency;
    public static Urgencylevel tomodel (Urgencylevel entity){
        Urgencylevel model = new Urgencylevel();
        model.setNameUrgency(entity.getNameUrgency());
        return model;
    }
}
