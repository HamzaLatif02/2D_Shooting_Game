package game;

import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;

public class LevelThree extends GameLevel{

    private Image background;

    public LevelThree(){
        super();

        setBackground();
        placePortal();
    }

    public void setBackground() {
        this.background = new ImageIcon("data/level3/background3.png").getImage();
    }

    public void placePortal(){
        getPortal().setPosition(new Vec2(1000,1000));
    }

    @Override
    public Boolean objectivesDone() {
        return Boolean.FALSE;
    }

    @Override
    public Image getBackground() {
        return background;
    }
}
