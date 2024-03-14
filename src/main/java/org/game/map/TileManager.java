package org.game.map;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

import org.game.control.UtilityTool;
import org.game.frame.GamePanel;

public class TileManager {
    
    // mang cac manh tile
    public Tile[] tiles = new Tile[50];
    public int[][] mapNums = new int[GamePanel.maxWorldRow][GamePanel.maxWorldCol];

    // private GamePanel gp;
    private UtilityTool uTool;

    public TileManager() {

        // this.gp = gp;
        uTool = new UtilityTool();

        loadMapImage();
        loadMapNum();
    }

    private void loadMapImage() {
         
    }

    // doc anh cho manh tile va gan collision
    private void setUp(int index, String imagePath, boolean collision) {

    }

    private void loadMapNum() {

    }

    public void draw(Graphics2D g2D) {

    }
    
}
