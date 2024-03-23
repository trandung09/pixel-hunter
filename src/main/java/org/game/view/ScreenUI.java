package org.game.view;

import java.awt.Graphics2D;

import org.game.enums.GameState;
import org.game.frame.GamePanel;

public class ScreenUI extends Interaction {
    
    public ScreenUI(GamePanel gp) {

        super(gp);
    }

    @Override
    public void draw(Graphics2D g2D) {

        this.g2D = g2D;

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
            drawEndScreen();
        }
    }

    public void drawPlayerLife() {

    }

    public void drawPlayScreen() {

    }

    public void drawPauseScreen() {
        // vẽ khung hình hiển thị dòng chữ pause trên panel
        // vẽ command: tiếp tục và ròi đi trên panel
    }

    public void drawWaitState() {
        
    }

    public void drawEndScreen() {
        
    }
}
