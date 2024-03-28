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

    protected BufferedImage cutUp1, cutUp2, cutDown1, cutDown2, cutLeft1, cutLeft2, cutRight1, cutRight2;

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
        loadPlayerAttackImage();
    }

    private void loadPlayerImage() {

        int width = GamePanel.tileSize; 
        int height = GamePanel.tileSize;

        up1 = setUp("/player/boy_up_1", width, height);
        up2 = setUp("/player/boy_up_2", width, height);
        down1 = setUp("/player/boy_down_1", width, height);
        down2 = setUp("/player/boy_down_2", width, height);
        left1 = setUp("/player/boy_left_1", width, height);
        left2 = setUp("/player/boy_left_2", width, height);
        right1 = setUp("/player/boy_right_1", width, height);
        right2 = setUp("/player/boy_right_2", width, height);
    }

    private void loadPlayerAttackImage() {

        int width = GamePanel.tileSize; 
        int height = GamePanel.tileSize;

        attackUp1 = setUp("/player/boy_attack_up_1", width, height);
        attackUp2 = setUp("/player/boy_attack_up_2", width, height);
        attackDown1 = setUp("/player/boy_attack_down_1", width, height);
        attackDown2 = setUp("/player/boy_attack_down_2", width, height);
        attackLeft1 = setUp("/player/boy_attack_left_1", width, height);
        attackLeft2 = setUp("/player/boy_attack_left_2", width, height);
        attackRight1 = setUp("/player/boy_attack_right_1", width, height);
        attackRight2 = setUp("/player/boy_attack_right_2", width, height);

        cutUp1 = setUp("/player/boy_attack_up_1", width, height);
        cutUp2 = setUp("/player/boy_attack_up_2", width, height);
        cutDown1 = setUp("/player/boy_attack_down_1", width, height);
        cutDown2 = setUp("/player/boy_attack_down_2", width, height);
        cutLeft1 = setUp("/player/boy_attack_left_1", width, height);
        cutLeft2 = setUp("/player/boy_attack_left_2", width, height);
        cutRight1 = setUp("/player/boy_attack_right_1", width, height);
        cutRight2 = setUp("/player/boy_attack_right_2", width, height);
    }

    @Override
    public void update() {

        // nếu kinh nghiệm nhân vật hiện tại đủ lớn thì tăng level lên 1 (max level = 5)
        if (exp >= nextLevelExp) {

            nextLevelExp *= 2;
            if (level < 5) level++;
        }
        
        if (attacking == true) {

            attacking();
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
            coChecker.checkCoWithTile(this);
            int npcIndex = coChecker.checkCoWithEntity(this, gp.npcs);
            int monsterIndex = coChecker.checkCoWithEntity(this, gp.monsters);
            int objIndex = coChecker.checkCoWithObject(this, true);

            pickObject(objIndex);
            contactMonster(monsterIndex);
            interactNpc(npcIndex);
        
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

    // Xử lý các hành động nhân vật với các npc
    public void interactNpc(int index) {

    }

    // Xử lsy các hành động của nhân vật khi va chạm với quái vật
    public void contactMonster(int index) {

    }

    public void attacking() {

    }

    // Xử lý các hoạt động của nhân vật với các object
    public void pickObject(int index) {

        if (index == -1) return;

        String objectName = gp.objs[index].name;

        switch (objectName) {
            case "Boots":
                speed += 5;
                gp.objs[index] = null;
                break;
        
            default:
                break;
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
