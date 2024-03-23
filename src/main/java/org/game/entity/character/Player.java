package org.game.entity.character;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import org.game.entity.Entity;
import org.game.enums.Direction;
import org.game.event.InputHandler;
import org.game.frame.GamePanel;

public class Player extends Entity 
{
    public final int drawX = GamePanel.screenWidth / 2 - GamePanel.tileSize / 2;
    public final int drawY = GamePanel.screenHeight / 2 - GamePanel.tileSize / 2;

    private InputHandler keyH;
    private BufferedImage image; 

    public int level = 1; // level nhân vật chính != level trò chơi (max level = 5)
    public int exp = 0; // kinh nghiệm của nhân vật hiện có (exp càng lớn -> level càng cao)
    public int nextLevelExp = 5;
    public boolean attacking = false; // trạng thái tấn công của nhân vật (nhân vật có đang ở trong trạng thái tấn công hay không)
    public boolean currentWeapon = false; // true = kiếm, false = rìu
    public int keys = 0; // số lượng chìa khóa thu thập được
    public int manas = 0; // số lượng mana thu thập được: sử dụng mana -> hồi máu
    public int diamonds = 0; // số lượng kim cương thu được

    public boolean useKey = false;
    public boolean useMana = false;

    public Player(GamePanel gp) {

        super(gp);

        keyH = gp.keyH;
        
        maxLife = 6;
        life = maxLife;
        
        speed = 4;

        worldX = 23 * GamePanel.tileSize;
        worldY = 21 * GamePanel.tileSize;

        solidArea = new Rectangle(12, 8, 24, 32);
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

        loadPlayerImage();
    }

    private void loadPlayerImage() {

        up1 = setUp("/player/boy_up_1");
        up2 = setUp("/player/boy_up_2");
        down1 = setUp("/player/boy_down_1");
        down2 = setUp("/player/boy_down_2");
        left1 = setUp("/player/boy_left_1");
        left2 = setUp("/player/boy_left_2");
        right1 = setUp("/player/boy_right_1");
        right2 = setUp("/player/boy_right_2");
    }

    @Override
    public void update() {

        // nếu kinh nghiệm nhân vật hiện tại đủ lớn thì tăng level lên 1 (max level = 5)
        if (exp >= nextLevelExp) {

            nextLevelExp *= 2;
            if (level < 5) level++;
        }
        
        if (attacking == true) {


        }

        if(keyH.upPressed || keyH.downPressed || keyH.leftPressed || keyH.rightPressed) {
    
            if (keyH.upPressed) direction = Direction.UP;
            else if (keyH.downPressed) direction = Direction.DOWN;
            else if (keyH.leftPressed) direction = Direction.LEFT;
            else if (keyH.rightPressed) direction = Direction.RIGHT;

            drawCounter++;
            if (drawCounter == 12) {
                drawCounter = 0;
                drawChecker = !drawChecker;
            }

            collisionOn = false;
        
            if(!collisionOn){
                switch (direction) {
                    case UP:    worldY -= speed; break;                    
                    case DOWN:  worldY += speed; break;                  
                    case LEFT:  worldX -= speed; break;                    
                    case RIGHT: worldX += speed; break;
                }
            }
        }
    }

    @Override
    public void draw(Graphics2D g2D) {
        
        switch (direction) {
            case UP:
                image = drawChecker ? up1 : up2;
                break;
            case DOWN:
                image = drawChecker ? down1 : down2;
                break;
            case LEFT:
                image = drawChecker ? left1 : left2;
                break;
            case RIGHT:
                image = drawChecker ? right1 : right2;
                break;
            default: break;
        }

        g2D.drawImage(image, drawX, drawY, GamePanel.tileSize, GamePanel.tileSize, null);
    }
}
