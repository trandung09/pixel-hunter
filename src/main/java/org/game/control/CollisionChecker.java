package org.game.control;

import org.game.entity.Entity;

import org.game.frame.GamePanel;

public class CollisionChecker {
    
    private GamePanel gp;

    public CollisionChecker(GamePanel gp) {
        
        this.gp = gp;
    }

    public void checkCoWithTile(Entity entity) {
        // kiem tra va cham voi cac manh tile
    }

    public int checkCoWithEntity(Entity entity, Entity[] others) {
        // kiem tra va cham giua thuc the nay voi cac thuc the khac
        int index = -1;

        return index;
    }

    public int checkCoWithObject(Entity entity, boolean player) {
        // kiem tra va cham voi cac object
        int index = -1;

        return index;
    }

    public void checkCoWithPlayer(Entity entity) {
        // Kiem tra va cham cua thuc the khac voi player
    }
}
