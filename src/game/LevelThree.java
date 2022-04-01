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

        new Portal(this, "gravity", "left").setPosition(new Vec2(77f, 29f));

        new SinglePlatform(this).setPosition(new Vec2(81f, 21f));
        new SinglePlatform(this).setPosition(new Vec2(81f, 37f));

        for (int i=0; i<10; i++){
            new GroundPlatform(this).setPosition(new Vec2(94f + i*35, 11.5f));
        }
        for (int i=0; i<10; i++){
            new GroundPlatform(this).setPosition(new Vec2(94f + i*35, 46.5f));
        }

        //ground1

        //ground2

        //ground3

        //ground4

        //ground5

        //ground6

        //ground7

        //ground8

        //ground9

        //ground10

        new SinglePlatform(this).setPosition(new Vec2(422f, 21f));
        new SinglePlatform(this).setPosition(new Vec2(422f, 37f));

        new Portal(this, "gravity", "right").setPosition(new Vec2(426f, 29f));

        new GroundPlatform(this).setPosition(new Vec2(444f, 11.5f));
        new WallPlatform(this).setPosition(new Vec2(460f, 19f));

    }

    public void placePortal(){
        getPortal().setPosition(new Vec2(458f,30.5f));
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
