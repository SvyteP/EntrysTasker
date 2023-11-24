package model;

import entity.UserEntity;
import lombok.Data;

@Data
public class roles {
    private String nameRole;public static roles tomodel (roles entity){
        roles model = new roles();
        model.setNameRole(entity.getNameRole());
        return model;
    }
}
