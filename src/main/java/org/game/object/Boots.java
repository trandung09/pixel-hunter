package org.game.object;

import org.game.frame.GamePanel;

public class Boots extends SuperObject {
    
    public Boots(GamePanel gp) {

        super(gp);

        worldX = 22 * GamePanel.tileSize;
        worldY = 24 * GamePanel.tileSize;

        name = "Boots";
        image = getImage("/object/boots", GamePanel.tileSize, GamePanel.tileSize);
    }
}
