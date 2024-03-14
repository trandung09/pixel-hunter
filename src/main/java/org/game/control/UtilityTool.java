package org.game.control;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class UtilityTool {
    
    public BufferedImage getImage(String imagePath) {

        BufferedImage image = null;
        try {
            image = ImageIO.read(getClass().getResourceAsStream(imagePath + ".png"));
             // doc anh bang phuong thuc static read cua lop IamgeIO
        } catch (IOException e) {
            e.printStackTrace();
        }
       
        return image;
    }
}
