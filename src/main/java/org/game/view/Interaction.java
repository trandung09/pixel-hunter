package org.game.view;

import java.awt.Font;
import java.awt.Graphics2D;

import org.game.frame.GamePanel;

public abstract class Interaction {
    // chỉ để kế thừa

    protected GamePanel gp;
    Graphics2D g2D;
    Font marimonica;

    public Interaction(GamePanel gp) {

        this.gp = gp;
    }

    public abstract void draw(Graphics2D g2D);
}
