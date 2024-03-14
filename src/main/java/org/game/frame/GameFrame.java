package org.game.frame;

import java.awt.Dimension;

import javax.swing.JFrame;

public class GameFrame extends JFrame {

    GamePanel gp = new GamePanel();
    
    GameFrame() {

        this.add(gp);
        this.setVisible(true);
        this.setSize(new Dimension(GamePanel.maxScreenWidth, GamePanel.maxScreenHeight));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        

        new GameFrame();
    }
}
