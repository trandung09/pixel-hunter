package org.game.frame;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import org.game.entity.Entity;
import org.game.map.TileManager;
import org.game.object.SuperObject;
import org.game.setter.AssetSetter;

public class GamePanel extends JPanel implements Runnable {

    public static final int tileSize = 48;
    public static final int maxScreenCol = 16; // màn hình hiển thỉ game tối đa 16 cột
    public static final int maxScreenRow = 12; // màn hình hiển thị game tối đa 12 hàng

    public static int maxWorldCol = 50;
    public static int maxWorldRow = 50;

    public static final int maxScreenHeight = maxScreenRow * tileSize; // 576 px
    public static final int maxScreenWidth = maxScreenCol * tileSize;  // 768 px

    // Luồng chính chạy game
    Thread mainThread;

    public Entity[] npcs = new Entity[50];
    public SuperObject[] objs = new SuperObject[50];

    public TileManager tileM = new TileManager();

    public GamePanel() {

        mainThread = new Thread(this);
        mainThread.start();

        npcs = AssetSetter.setNpcInfor();
        objs = AssetSetter.setObjectInfor();
    }

    @Override
    public void run() {
        while(mainThread != null) {

            update();
            repaint();
        }
    }
    
    public void update() {

    }

    @Override
    protected void paintComponent(Graphics gr) {

        super.paintComponent(gr);;


        Graphics2D g2D = (Graphics2D) gr;

        tileM.draw(g2D);
        gr.dispose();
    }
}
