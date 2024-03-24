package org.game.object;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import org.game.control.UtilityTool;
import org.game.frame.GamePanel;

public class SuperObject {

    protected GamePanel gp;
    protected UtilityTool uTool;
    protected BufferedImage image;
    
    public String name;
    public Rectangle solidArea;
    public int solidAreaDefaultX;
    public int solidAreaDefaultY;
    public int worldX, worldY;
    public boolean collison = true;

    public SuperObject(GamePanel gp) {

        this.gp = gp;
        this.uTool = new UtilityTool();
        this.solidArea = new Rectangle(0, 0, GamePanel.tileSize, GamePanel.tileSize);

        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
    }


    public void draw(Graphics2D g2D) {
        // xử lý vẽ object theo vị trí nhân vật
        g2D.drawImage(image, worldX, worldY, null);
    }
}
