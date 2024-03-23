package org.game.entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import org.game.control.CollisionChecker;
import org.game.control.UtilityTool;
import org.game.frame.GamePanel;
import org.game.enums.*;

public class Entity {
    
   
    protected GamePanel gp;

    // CHARECTER STATUS
    protected int maxLife;
    protected int life;

    // CHARECTER STAGE (Draw)
    protected boolean drawChecker = true;
    protected int drawCounter = 0;
    protected int actionCounter = 0;

    // CHARACTER IMAGE
    protected BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
    protected UtilityTool uTool;

    // FOR COLLISION CHECK
    protected CollisionChecker coChecker;

    public int speed;
    public int worldX, worldY;
    public Rectangle solidArea;
    public int solidAreaDefaultX;
    public int solidAreaDefaultY;
    public Direction direction = Direction.DOWN; // Enum Direction (class)
    public boolean collisionOn = false;

    public int damage = 1; // sát thương của thực thể

    protected Entity() {
    }

    protected Entity(GamePanel gp) {

        this.gp = gp;
        this.uTool = new UtilityTool();
        this.coChecker = new CollisionChecker(gp);
    }

    protected BufferedImage setUp(String imagePath) {

        return uTool.getImage(imagePath);
    }

    public void setAction() {
        // de cac lop ke thua ghi de
    }

    public void update() {

        setAction();
        // cap nhat trang thai cac thu the
    }

    public void draw(Graphics2D g2D) {
        // duoc goi o paintComponent(gr) de ve thuc the len panel
    }
}
