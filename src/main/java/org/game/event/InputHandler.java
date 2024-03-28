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

        int keyCode = e.getKeyCode();
        
        if (gp.mainStage == GameState.WAIT) {
            // nhấn enter -> start state
            if(e.getKeyCode() == KeyEvent.VK_ENTER) {

                if (gp.screenUI.menuCommand == 0) {
                    gp.mainStage = GameState.START;
                }
                else if (gp.screenUI.menuCommand == 2) {
                    System.exit(1);
                }
            }

            if (keyCode == KeyEvent.VK_UP) {

                if (gp.screenUI.menuCommand > 0) {
                    gp.screenUI.menuCommand--;
                }
                else if (gp.screenUI.menuCommand == 0) {
                    gp.screenUI.menuCommand = 2;
                }
            }

            if (keyCode == KeyEvent.VK_DOWN) {

                if (gp.screenUI.menuCommand < 2) {
                    gp.screenUI.menuCommand++;
                }
                else if (gp.screenUI.menuCommand == 2) {
                    gp.screenUI.menuCommand = 0;
                }
            }
        }
        else if (gp.mainStage == GameState.START) {
            // nhấn p -> pause state
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_W: upPressed = true; break;
                case KeyEvent.VK_S: downPressed = true; break;
                case KeyEvent.VK_A: leftPressed = true; break;
                case KeyEvent.VK_D: rightPressed = true; break;
                case KeyEvent.VK_P: gp.mainStage = GameState.PAUSE; break;
                default: break;
            }
        }
        else if (gp.mainStage == GameState.PAUSE) {
            // nhấn enter tiếp tục -> start state
            // nhấn q -> wait state
    
            // Xử lý up down để cài đặt pause 
        }
        else if (gp.mainStage == GameState.END) {

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
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
