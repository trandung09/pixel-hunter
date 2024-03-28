package org.game.object;

import java.awt.image.BufferedImage;

import org.game.control.UtilityTool;

public class Heart {

    private String name = "Heart";
    private static UtilityTool uTool = new UtilityTool();
    
    public static BufferedImage 
        _blank = uTool.getImage("/object/heart_blank"),
        _half  = uTool.getImage("/object/heart_half"),  
        _full  = uTool.getImage("/object/heart_full");
                                
    public String name() { return name; }
}
