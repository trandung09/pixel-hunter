package org.game.view;

import java.awt.Font;
import java.awt.Graphics2D;
import java.io.InputStream;

import org.game.frame.GamePanel;

public abstract class Interaction {
    // chỉ để kế thừa

    protected GamePanel gp;
    protected Graphics2D g2D;
    protected Font marimonica;

    public Interaction(GamePanel gp) {

        this.gp = gp;

        try {
            InputStream is = getClass().getResourceAsStream("/font/x12y16pxMaruMonica.ttf");
            marimonica = Font.createFont(Font.TRUETYPE_FONT, is);

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public abstract void draw(Graphics2D g2D);
}
