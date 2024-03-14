package org.game.setter;

import org.game.entity.Entity;
import org.game.object.SuperObject;

public class AssetSetter {
    
    // dùng để đọc file và setup vị trí cho các object, các quái bật
    // chỉ có phương thức static nhiệm vụ là khởi tọa đối tượng và set vị trí ban đầu cho 
    // Entity[] và SuperObject[]

    public static Entity[] setNpcInfor() {

        Entity[] npcs = new Entity[50];

        return npcs;
    }

    public static SuperObject[] setObjectInfor() {

        SuperObject[] objs = new SuperObject[50];

        return objs;
    }
}
