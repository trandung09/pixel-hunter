package org.game.view;

import java.awt.Graphics2D;

import org.game.frame.GamePanel;

public class ScreenUI extends Interaction {
    
    public ScreenUI(GamePanel gp) {

        super(gp);
    }

    @Override
    public void draw(Graphics2D g2D) {

        this.g2D = g2D;
    }

    public void drawPlayScreen() {

    }

    public void drawPauseScreen() {

    }

    public void drawWonScreen() {

    }

    public void drawEndScreen() {
        
    }
}
