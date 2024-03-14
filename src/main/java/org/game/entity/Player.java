package org.game.entity;

import java.awt.Graphics2D;

import org.game.frame.GamePanel;

public class Player extends Entity {
    
    public Player(GamePanel gp) {

        super(gp);

        worldX = 22 * GamePanel.tileSize;
        worldY = 21 * GamePanel.tileSize;

        loadPlayerImage();
    }

    private void loadPlayerImage() {
        // setup anh cho nhan vat
    }

    @Override
    public void update() {
        // cap nhat trang thai nhan vat chinh
    }

    @Override
    public void draw(Graphics2D g2D) {
        // ve nhan vat
    }
}
