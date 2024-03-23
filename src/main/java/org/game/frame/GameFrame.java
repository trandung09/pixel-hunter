package org.game.frame;

import java.awt.Dimension;

import javax.swing.JFrame;

public class GameFrame extends JFrame {

    GamePanel gp = new GamePanel();
    
    GameFrame() {

        this.add(gp);
        this.addKeyListener(gp.keyH);
        
        this.setVisible(true);
        this.setResizable(true);
        this.setSize(new Dimension(GamePanel.screenWidth, GamePanel.screenHeight));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);  
    }
    public static void main(String[] args) {
        

        new GameFrame();
    }
}
