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

        new DoublePlatform(this, "horizontal").setPosition(new Vec2(30f, -5f));
        new DoublePlatform(this, "vertical").setPosition(new Vec2(30f, 25f));

        new DoublePlatform(this).setPosition(new Vec2(40f, 25f));
        new DoublePlatform(this).setPosition(new Vec2(50f, 25f));
        new DoublePlatform(this).setPosition(new Vec2(60f, 25f));
        new DoublePlatform(this).setPosition(new Vec2(70f, 25f));


        new GroundPlatform(this).setPosition(new Vec2(95f,11.5f));
        new GroundPlatform(this).setPosition(new Vec2(95f, 46.5f));

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
