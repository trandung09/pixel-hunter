package org.game.map;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.game.control.UtilityTool;
import org.game.frame.GamePanel;
import javax.imageio.ImageIO;

public class TileManager {

    public Tile[] tiles = new Tile[50];
    public int[][] mapNums = new int[GamePanel.maxWorldRow][GamePanel.maxWorldCol];
    public String[] map = {"resources/map/map1.txt"}; // Đường dẫn đến tệp bản đồ

    private UtilityTool uTool;

    public TileManager() {
        uTool = new UtilityTool();
        loadMapImage();
    }
    public void setMap(int level){ loadMapNum(map[level]);}
    private void loadMapImage() {
        //Đi qua được collision: false không qua được collision: true
        setUp(0, "grass", false);
        setUp(1, "tree", true);
        setUp(3, "water", true);
        setUp(4, "wall", true);
        setUp(5, "sand", false);
        setUp(6, "earth", false);
    }
    private void loadMapNum(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(map[0]))) { // Sử dụng chỉ mục đầu tiên của mảng map
            int col = 0;
            int row = 0;
            String line;
            while ((line = br.readLine()) != null && row < GamePanel.maxWorldRow) {
                String[] numbers = line.trim().split(" ");
                for (String num : numbers) {
                    if (col < GamePanel.maxWorldCol) {
                        mapNums[row][col] = Integer.parseInt(num);
                        col++;
                    }
                }
                row++;
                col = 0;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setUp(int index, String imageName, boolean collision) {
        try {
            tiles[index] = new Tile();
            tiles[index].image = ImageIO.read(new File("res/tiles/" + imageName + ".png")); // Thay đổi đường dẫn tương ứng
            tiles[index].collision = collision;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public  void draw(Graphics2D g2D) {
        GamePanel gp = new GamePanel();
        int x = 0;
        int y = 0;
        for (int row = 0; row < GamePanel.maxWorldRow; row++) {
            for (int col = 0; col < GamePanel.maxWorldCol; col++) {
                int tileNum = mapNums[row][col];
                if (tileNum >= 0 && tileNum < tiles.length && tiles[tileNum] != null && tiles[tileNum].image != null) {
                    g2D.drawImage(tiles[tileNum].image, x, y, null);
                }
                x += gp.tileSize;
            }
            x = 0;
            y += gp.tileSize;
        }
    }
}
