package game;

import city.cs.engine.SoundClip;

import javax.swing.*;
import java.awt.*;

public class LevelFour extends GameLevel{

    private Image background;

    public LevelFour(String populate){
        super(populate);


        setBackground();

    }


    public void setBackground(){
        background = new ImageIcon("data/level4/background4.png").getImage();
    }

    @Override
    public Boolean objectivesDone() {
        return Boolean.FALSE;
    }

    @Override
    public Image getBackground() {
        return background;
    }

    @Override
    public String getLevelName() {
        return "LevelFour";
    }

    @Override
    public void startBackgroundMusic() {

    }

    @Override
    public SoundClip getBackgroundMusic() {
        return null;
    }
}
