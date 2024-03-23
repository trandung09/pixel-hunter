package org.game.map;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.game.control.UtilityTool;
import org.game.frame.GamePanel;

public class TileManager {

    public Tile[] tiles = new Tile[50];
    public int[][] mapNums = new int[GamePanel.maxWorldRow][GamePanel.maxWorldCol];
    public String[] map = {"src/main/resources/map/map1.txt"}; // Đường dẫn đến tệp bản đồ

    private UtilityTool uTool;
    private GamePanel gp;

    public TileManager(GamePanel gp) {

        this.gp = gp;

        uTool = new UtilityTool();

        loadMapImage();
        setMap(0);
    }

    public void setMap(int level) { 

        loadMapNum(map[level]);
    }

    private void loadMapImage() {
        
        setUp(10, "grass00", false);
        setUp(11, "grass01", false);
        setUp(12, "water00", true);
        setUp(13, "water01", true);
        setUp(14, "water02", true);
        setUp(15, "water03", true);
        setUp(16, "water04", true);
        setUp(17, "water05", true);
        setUp(18, "water06", true);
        setUp(19, "water07", true);
        setUp(20, "water08", true);
        setUp(21, "water09", true);
        setUp(22, "water10", true);
        setUp(23, "water11", true);
        setUp(24, "water12", true);
        setUp(25, "water13", true);
        setUp(26, "road00", false);
        setUp(27, "road01", false);
        setUp(28, "road02", false);
        setUp(29, "road03", false);
        setUp(30, "road04", false);
        setUp(31, "road05", false);
        setUp(32, "road06", false);
        setUp(33, "road07", false);
        setUp(34, "road08", false);
        setUp(35, "road09", false);
        setUp(36, "road10", false);
        setUp(37, "road11", false);
        setUp(38, "road12", false);
        setUp(39, "earth", false);
        setUp(40, "wall", true);
        setUp(41, "tree", true);
        setUp(42, "tree", false);
    }

    private void loadMapNum(String filePath) {
        // Sử dụng chỉ mục đầu tiên của mảng map
        try (BufferedReader br = new BufferedReader(new FileReader(map[0]))) {
            int col = 0, row = 0;
            String line;

            while ((line = br.readLine()) != null && row < GamePanel.maxWorldRow) {
                String[] numbers = line.split(" ");
                for (String num : numbers) {
                    if (col < GamePanel.maxWorldCol) {
                        mapNums[row][col] = Integer.parseInt(num);
                        col++;
                    }
                }
                row++; col = 0;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setUp(int index, String imagePath, boolean collision) {
        
        try {
            tiles[index] = new Tile();
            tiles[index].image = uTool.getImage("/tile/" + imagePath);
            tiles[index].collision = collision;
    
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2D) {

        int row = 0, col = 0;

        while (row < GamePanel.maxWorldRow && col < GamePanel.maxWorldCol) {
            
            int tileNum = mapNums[row][col];

            // Vị trí tuyệt đối của mảnh tile
            int worldX = col * GamePanel.tileSize;
            int worldY = row * GamePanel.tileSize;

            // Vị trí vẽ tương đối của tile được định nghia theo vị trí player
            int drawX = worldX - gp.player.worldX + gp.player.drawX;
            int drawY = worldY - gp.player.worldY + gp.player.drawY;

            g2D.drawImage(tiles[tileNum].image, drawX, drawY, GamePanel.tileSize, GamePanel.tileSize, null);

            col++;
            if (col == GamePanel.maxWorldCol) {
                col = 0;
                row++;
            }
        }
    }
}
