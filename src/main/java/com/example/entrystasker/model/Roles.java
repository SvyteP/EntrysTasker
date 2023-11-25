package com.example.entrystasker.model;

import com.example.entrystasker.entity.RolesEntity;
import lombok.Data;

@Data
public class Roles {

    private String nameRole;
    public static Roles tomodel (RolesEntity entity){
        Roles model = new Roles();
        model.setNameRole(entity.getNameRole());
        return model;
    }
}
