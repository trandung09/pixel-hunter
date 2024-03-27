package org.game.control;

import java.net.URL;

import javax.sound.sampled.Clip;

public class Sound {
    
    private URL[] url;
    private Clip clip;

    public Sound() {

    }

    public void setFile(int index) {

    }

    public void play() {
        if (clip != null) clip.start();
    }

    public void loop() {
        if (clip != null) clip.loop(0);
    }
}
