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

    protected BufferedImage getImage(String imagePath) {

        return uTool.getImage(imagePath);
    }

    public void draw(Graphics2D g2D) {
        
        int drawX = worldX - gp.player.worldX + gp.player.drawX;
        int drawY = worldY - gp.player.worldY + gp.player.drawY;

        g2D.drawImage(image, drawX, drawY, GamePanel.tileSize, GamePanel.tileSize, null);
    }
}
