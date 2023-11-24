package model;

import entity.UserEntity;
import lombok.Data;

@Data
public class statuslevel {
    private String nameStatus;
    public static statuslevel tomodel (statuslevel entity){
        statuslevel model = new statuslevel();
        model.setNameStatus(entity.getNameStatus());
        return model;
    }
}
