package game;

import city.cs.engine.SoundClip;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;

public class LevelFour extends GameLevel{

    private Image background;

    public LevelFour(String populate){
        super(populate);
        if (getPopulate().equals("yes")){
            placePlatforms();
            placePortal();
        }

        setBackground();

    }

    public void placePlatforms(){
        new WallPlatform(this).setPosition(new Vec2(-16f, 0f));
        new GroundPlatform(this).setPosition(new Vec2(0f, -17.5f));

        new DoublePlatform(this).setPosition(new Vec2(20f, -12f));
        new DoublePlatform(this).setPosition(new Vec2(30f, -12f));

        new Portal(this, "gravity", "left").setPosition(new Vec2(35f, 0f));

        new SinglePlatform(this).setPosition(new Vec2(39f, -8f));
        new SinglePlatform(this).setPosition(new Vec2(39f, 8f));

        for (int i=0; i<10; i++){
            new GroundPlatform(this).setPosition(new Vec2(50f + i*35, -17.5f));
        }

        for (int i=0; i<10; i++){
            new GroundPlatform(this).setPosition(new Vec2(50f + i*35, 17.5f));
        }

        new SinglePlatform(this).setPosition(new Vec2(376f, -8f));
        new SinglePlatform(this).setPosition(new Vec2(376f, 8f));

        new Portal(this, "gravity", "right").setPosition(new Vec2(380, 0f));

        new DoublePlatform(this).setPosition(new Vec2(385f, -12f));
        new DoublePlatform(this).setPosition(new Vec2(395f, -12f));

        new GroundPlatform(this).setPosition(new Vec2(415f, -17.5f));
        new WallPlatform(this).setPosition(new Vec2(431f, 0f));

    }

    public void placePortal(){
        getPortal().setPosition(new Vec2(429f, 5f));
    }

    public void setBackground(){
        background = new ImageIcon("data/level4/background4.gif").getImage();
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
