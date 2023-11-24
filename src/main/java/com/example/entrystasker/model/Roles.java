package com.example.entrystasker.model;

import lombok.Data;

@Data
public class Roles {
    private String nameRole;public static Roles tomodel (Roles entity){
        Roles model = new Roles();
        model.setNameRole(entity.getNameRole());
        return model;
    }
}
