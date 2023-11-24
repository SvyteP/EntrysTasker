package com.example.entrystasker.model;

import lombok.Data;

@Data
public class Statuslevel {
    private String nameStatus;
    public static Statuslevel tomodel (Statuslevel entity){
        Statuslevel model = new Statuslevel();
        model.setNameStatus(entity.getNameStatus());
        return model;
    }
}
