package org.game.object;

import java.awt.image.BufferedImage;

import org.game.control.UtilityTool;
import org.game.frame.GamePanel;

public class Heart {

    public String name = "Heart";
    private static UtilityTool uTool = new UtilityTool();
    
    public static BufferedImage 
        _blank = uTool.getImage("/object/heart_blank", GamePanel.tileSize, GamePanel.tileSize),
        _half  = uTool.getImage("/object/heart_half", GamePanel.tileSize, GamePanel.tileSize),
        _full  = uTool.getImage("/object/heart_full", GamePanel.tileSize, GamePanel.tileSize);

    
}
