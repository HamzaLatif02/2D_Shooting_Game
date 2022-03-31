package game;

import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;

public class LevelThree extends GameLevel{

    private Image background;

    public LevelThree(){
        super();

        //getCharacter().setGravityScale(-getGravity());

        setBackground();
        placePlatforms();
        placePortal();

    }

    public void setBackground() {
        this.background = new ImageIcon("data/level3/background3.png").getImage();
    }

    public void placePlatforms(){
        new WallPlatform(this).setPosition(new Vec2(-16f, 0f));
        new GroundPlatform(this).setPosition(new Vec2(0f, -17.5f));
        new GroundPlatform(this).setPosition(new Vec2(0f, 17.5f));
        new DoublePlatform(this).setPosition(new Vec2(10,1));
        new SinglePlatform(this).setPosition(new Vec2(-5,2));
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
