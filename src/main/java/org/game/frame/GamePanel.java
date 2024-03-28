package org.game.frame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import org.game.entity.Entity;
import org.game.entity.character.Player;
import org.game.entity.character.monster.Monster;
import org.game.enums.GameState;
import org.game.event.InputHandler;
import org.game.map.TileManager;
import org.game.object.Boots;
import org.game.object.SuperObject;
import org.game.view.ScreenUI;

public class GamePanel extends JPanel implements Runnable {

    public static final int tileSize = 48;
    public static final int maxScreenCol = 16; // màn hình hiển thỉ game tối đa 16 cột
    public static final int maxScreenRow = 12; // màn hình hiển thị game tối đa 12 hàng

    public static int maxWorldCol = 50;
    public static int maxWorldRow = 50;

    public static final int screenHeight = maxScreenRow * tileSize; // 576 px
    public static final int screenWidth = maxScreenCol * tileSize;  // 768 px

    public final int FPS = 60;

    public GameState mainStage = GameState.WAIT;

    // Luồng chính chạy game
    Thread mainThread;

    public InputHandler keyH = new InputHandler(this);
    public Entity[] npcs = new Entity[50];
    public Monster[] monsters = new Monster[50];
    public SuperObject[] objs = new SuperObject[50];

    public Player player = new Player(this);

    public TileManager tileM = new TileManager(this);
    public ScreenUI screenUI = new ScreenUI(this);

    public GamePanel() {

        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(GamePanel.screenWidth, GamePanel.screenHeight));
        this.setFocusable(true);
        this.requestFocusInWindow(true);
        this.setBackground(Color.BLACK);

        this.addKeyListener(keyH);

        mainThread = new Thread(this);
        mainThread.start();

        objs[0] = new Boots(this);
    }

    @Override
    public void run() {

        double drawInterval = (double) 1e9 / FPS; // nano giây
        double nextDrawTime = System.nanoTime() + drawInterval; 
        // System.nanaTime: lấy ra thời gian hiện tại ở nano giây

        while(mainThread != null) {

            update();
            repaint();

            try {
                double remainingTime = nextDrawTime - System.nanoTime(); // Thời gian thread ngủ
                remainingTime /= 1000000; // milis giây

                if (remainingTime < 0) remainingTime = 0;

                Thread.sleep((long)remainingTime);
                nextDrawTime += drawInterval;

            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
    public void update() {
        
        if (mainStage == GameState.START) {
            player.update();
        }
    }

    @Override
    protected void paintComponent(Graphics gr) {

        super.paintComponent(gr);;

        Graphics2D g2D = (Graphics2D) gr;

        if (mainStage == GameState.START || mainStage == GameState.PAUSE) {
            tileM.draw(g2D);
            player.draw(g2D);
            if (objs[0] != null) {
                objs[0].draw(g2D);
            }
        }

        screenUI.draw(g2D);
        
        gr.dispose();
    }
}
