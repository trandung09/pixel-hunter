package org.game.entity.monster;

import org.game.entity.Entity;
import org.game.frame.GamePanel;

public class Monster extends Entity {
    
    public int monsterExp = 1; // kinh ngiệm nhân vật có thể nhận được khi quái vật chết đi 

    public Monster(GamePanel gp) {

        super(gp);
    }

}
