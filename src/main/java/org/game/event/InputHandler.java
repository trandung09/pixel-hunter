package org.game.event;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import org.game.enums.GameState;
import org.game.frame.GamePanel;

public class InputHandler implements KeyListener {

    GamePanel gp;
    public boolean upPressed, downPressed, leftPressed, rightPressed;

    public InputHandler(GamePanel gp) {

        this.gp = gp;
    }
 
    @Override
    public void keyPressed(KeyEvent e) {
        
        // TODO Auto-generated method stub
        if (gp.mainStage == GameState.WAIT) {
            // nhấn enter -> start state
        }
        else if (gp.mainStage == GameState.START) {
            // nhấn p -> pause state
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_W: upPressed = true; break;
                case KeyEvent.VK_S: downPressed = true; break;
                case KeyEvent.VK_A: leftPressed = true; break;
                case KeyEvent.VK_D: rightPressed = true; break;
                default: break;
            }
        }
        else if (gp.mainStage == GameState.PAUSE) {
            // nhấn enter tiếp tục -> start state
            // nhấn q -> wait state
        }
        else if (gp.mainStage == GameState.END) {

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        int key = e.getKeyCode();
        switch (key) {
            case KeyEvent.VK_UP:    upPressed    = false; break;
            case KeyEvent.VK_W:     upPressed    = false; break;
            case KeyEvent.VK_DOWN:  downPressed  = false; break;
            case KeyEvent.VK_S:     downPressed  = false; break;
            case KeyEvent.VK_LEFT:  leftPressed  = false; break;
            case KeyEvent.VK_A:     leftPressed  = false; break;
            case KeyEvent.VK_RIGHT: rightPressed = false; break;                     
            case KeyEvent.VK_D:     rightPressed = false; break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        //  Đã có keyPressed và keyReleased để bắt sự kiện
    }
    
}
