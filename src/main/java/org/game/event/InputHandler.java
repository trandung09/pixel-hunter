package org.game.event;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputHandler implements KeyListener {

    private boolean upPressed, downPressed, leftPressed, rightPressed;
    
    public boolean isUpPressed()    {   return upPressed;   }
    public boolean isDownPressed()  {   return downPressed; }
    public boolean isLeftPressed()  {   return leftPressed; }
    public boolean isRightPressed() {   return rightPressed;}

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        int key = e.getKeyCode();
        switch (key) {
            case KeyEvent.VK_UP:    upPressed    = true; break;
            case KeyEvent.VK_W:     upPressed    = true; break;
            case KeyEvent.VK_DOWN:  downPressed  = true; break;
            case KeyEvent.VK_S:     downPressed  = true; break;
            case KeyEvent.VK_LEFT:  leftPressed  = true; break;
            case KeyEvent.VK_A:     leftPressed  = true; break;
            case KeyEvent.VK_RIGHT: rightPressed = true; break;
            case KeyEvent.VK_D:     rightPressed = true; break;
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
