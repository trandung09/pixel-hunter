package org.game.view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import org.game.enums.GameState;
import org.game.frame.GamePanel;
import org.game.object.Heart;

public class ScreenUI extends Interaction {

    public int menuCommand = 0;
    public BufferedImage player_image = null;
    public int drawCounter = 0;
    public boolean drawChecker = false;
    
    public ScreenUI(GamePanel gp) {

        super(gp);

    }

    @Override
    public void draw(Graphics2D g2D) {

        this.g2D = g2D;
        g2D.setFont(marimonica);

        if (gp.mainStage == GameState.WAIT) {
            drawWaitState();
        }
        else if (gp.mainStage == GameState.START) {
            drawPlayScreen();
            drawPlayerLife();
        }
        else if (gp.mainStage == GameState.PAUSE) {
            drawPauseScreen();
        }
        else if (gp.mainStage == GameState.END) {

        }
        else if (gp.mainStage == GameState.CHARACTER) {
            drawCharacterScreen();
        }
    }

    public void drawSubWindow(int X, int Y, int width, int height) {

        g2D.setColor(new Color(0, 0, 0, 210));
        g2D.fillRoundRect(X, Y, width, height, 35, 35);

        g2D.setColor(new Color(255, 255, 255));

        g2D.setStroke(new BasicStroke(5));
        g2D.drawRoundRect(X + 5, Y + 5, width - 10, height - 10, 35, 35);
    }

    public void drawDialougeScreen() {

    }
//  Dùng để tai anh trái tim
    public BufferedImage Heart(int heartStatus){
        if(heartStatus == 0){
            return Heart._blank;
        }else if(heartStatus == 1){
            return Heart._half;
        }
        return Heart._full;
    }
    public void drawPlayerLife() {

    }   

    public void drawPlayScreen() {

    }

    public void drawPauseScreen() {
 
        // gọi hàm drawSubWindow trước
    }

    public void drawCharacterScreen() {

    }

    public void drawWaitState() {
        
        drawCounter++;
        if (drawCounter > 10) {
            drawChecker = !drawChecker;
            drawCounter = 0;
        }
        /**
         *  NEW GAME
         *  ABOUT
         *  QUIT
         */
        g2D.setColor(Color.GRAY);
        g2D.setFont(g2D.getFont().deriveFont(Font.BOLD,76f));

        // draw heading
        String text = "PIXEL HUNTER";
        int drawX = getCenterTextForX(text);
        int drawY = GamePanel.tileSize * 2;
        
        g2D.drawString(text, drawX, drawY);

        g2D.setColor(Color.WHITE);
        g2D.drawString(text, drawX - 5, drawY + 5);

        // draw player
        int player_size = (GamePanel.tileSize * 3) / 2;
        drawX = GamePanel.screenWidth / 2 - player_size / 2;
        drawY = GamePanel.tileSize * 3 + GamePanel.tileSize / 2;

        g2D.drawImage(gp.player.getImageForScreenUI(drawChecker), drawX, drawY, player_size, player_size, null);
        g2D.drawLine(GamePanel.screenWidth / 6, drawY + (GamePanel.tileSize * 3) / 2, GamePanel.screenWidth - GamePanel.screenWidth / 6, drawY + (GamePanel.tileSize * 3) / 2);

        // draw menu choose
        g2D.setFont(g2D.getFont().deriveFont(Font.BOLD, 48f));

        text = "NEW GAME";
        drawX = getCenterTextForX(text);
        drawY = GamePanel.tileSize * 7;

        if (menuCommand == 0) {
            g2D.drawString(">", drawX - GamePanel.tileSize, drawY);
        }
        g2D.drawString(text, drawX, drawY);

        text = "ABOUT";
        drawX = getCenterTextForX(text);
        drawY = drawY + (GamePanel.tileSize * 3) / 2;

        if (menuCommand == 1) {
            g2D.drawString(">", drawX - GamePanel.tileSize, drawY);
        }
        g2D.drawString(text, drawX, drawY);

        text = "QUIT";
        drawX = getCenterTextForX(text);
        drawY = drawY + (GamePanel.tileSize * 3) / 2;

        if (menuCommand == 2) {
            g2D.drawString(">", drawX - GamePanel.tileSize, drawY);
        }
        g2D.drawString(text, drawX, drawY);
    }

    private int getCenterTextForX(String text) {

        return GamePanel.screenWidth / 2 
               - (int)g2D.getFontMetrics().getStringBounds(text, g2D).getWidth() / 2;
    }
}
