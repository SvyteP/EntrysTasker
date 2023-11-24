package model;

import entity.UserEntity;
import lombok.Data;

@Data
public class urgencylevel {
    private String nameUrgency;
    public static urgencylevel tomodel (urgencylevel entity){
        urgencylevel model = new urgencylevel();
        model.setNameUrgency(entity.getNameUrgency());
        return model;
    }
}
