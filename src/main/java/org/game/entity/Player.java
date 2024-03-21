package org.game.entity;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

import javax.imageio.ImageIO;
import javax.swing.text.Utilities;

import org.game.control.UtilityTool;
import org.game.enums.Direction;
import org.game.event.InputHandler;
import org.game.frame.GamePanel;

public class Player extends Entity {
    private InputHandler inpH ;
    private Image image; 
    public Player(GamePanel gp) {
        super(gp);
        this.inpH = gp.inp;
        worldX = 22 * GamePanel.tileSize;
        worldY = 21 * GamePanel.tileSize;
        
        loadPlayerImage();
    }

    private void loadPlayerImage() {
        // setup anh cho nhan vat
        this.up1    = this.setup("");
        this.up2    = this.setup("");
        this.down1  = this.setup("");
        this.down2  = this.setup("");
        this.left1  = this.setup("");
        this.left2  = this.setup("");
        this.right1 = this.setup("");
        this.right2 = this.setup("");
    }

    @Override
    public void update() {
        // cap nhat trang thai nhan vat chinh
        // drawCounter = 12;

        if(inpH.isDownPressed() || inpH.isLeftPressed() || inpH.isRightPressed() || inpH.isUpPressed()){
            drawCounter++;
            if(drawCounter == 12){
                drawCounter = 0;
                drawChecker = !drawChecker;
            }
            if(this.inpH.isUpPressed())
                this.direction = Direction.UP;
            else if (this.inpH.isDownPressed()) 
                this.direction = Direction.DOWN;
            else if(this.inpH.isLeftPressed())
                this.direction = Direction.LEFT;
            else if(this.inpH.isRightPressed())
                this.direction = Direction.RIGHT;
        }
        this.collisionOn = false;
        
        if(!this.collisionOn){
            switch (this.direction) {
                case UP:    this.worldY -= this.speed; break;                    
                case DOWN:  this.worldY += this.speed; break;                  
                case LEFT:  this.worldX -= this.speed; break;                    
                case RIGHT: this.worldX += this.speed; break;
            }
        }
    }

    @Override
    public void draw(Graphics2D g2D) {
        // ve nhan vat
        BufferedImage image = null;
        switch (this.direction) {
            case UP:
                if(drawChecker) image = up1;
                else image = up2;
                break;
            case DOWN:
                if(drawChecker) image = down1;
                else image = down2;
                break;
            case LEFT:
                if(drawChecker) image = left1;
                else image = left2;
                break;
            case RIGHT:
                if (drawChecker) image = right1;
                else image = right2;
                break;
        }
    }
    public BufferedImage setup(String img){
        uTool = new UtilityTool();
        return uTool.getImage("" + img + ".png");
    }
    
}
