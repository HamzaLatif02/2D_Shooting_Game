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
            placeExplosiveMines();
            placeHealthPotions();
            placeSpeedPotions();
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

    public void placeExplosiveMines(){
        //ground1 35-65

        //ground2 70-100
        new ExplosiveMine(this, "double").setPosition(new Vec2(73f, 0f));
        new ExplosiveMine(this, "double").setPosition(new Vec2(97f, 0f));

        //ground3 105-135
        new ExplosiveMine(this, "single").setPosition(new Vec2(111f, 0f));
        new ExplosiveMine(this, "single").setPosition(new Vec2(129f, 0f));

        //ground4 140-170

        //ground5 175-205
        new ExplosiveMine(this, "double").setPosition(new Vec2(180f, 0f));
        new ExplosiveMine(this, "double").setPosition(new Vec2(200f, 0f));

        //ground6 210-240
        new ExplosiveMine(this, "single").setPosition(new Vec2(225f, -6f));
        new ExplosiveMine(this, "single").setPosition(new Vec2(225f, 0f));

        //ground7 245-275

        //ground8 280-310
        new ExplosiveMine(this, "double").setPosition(new Vec2(292f, 0f));

        //ground9 315-345
        new ExplosiveMine(this, "single").setPosition(new Vec2(320f, -6f));
        new ExplosiveMine(this, "single").setPosition(new Vec2(320f, 0f));

        new ExplosiveMine(this, "single").setPosition(new Vec2(340f, 0f));
        new ExplosiveMine(this, "single").setPosition(new Vec2(340f, 6f));

        //ground10 350-380
    }

    public void placeHealthPotions(){
        //ground1 35-65

        //ground2 70-100

        //ground3 105-135

        //ground4 140-170
        new HealthPotion(this, "positive").setPosition(new Vec2(155f, 0f));

        //ground5 175-205

        //ground6 210-240

        //ground7 245-275
        new HealthPotion(this, "negative").setPosition(new Vec2(260f, 0f));

        //ground8 280-310

        //ground9 315-345
        new HealthPotion(this, "negative").setPosition(new Vec2(330f, 0f));

        //ground10 350-380
        new HealthPotion(this, "positive").setPosition(new Vec2(365f, 0f));
    }

    public void placeSpeedPotions(){
        //ground1 35-65

        //ground2 70-100

        //ground3 105-135
        new SpeedPotion(this, "positive").setPosition(new Vec2(120f, 0f));

        //ground4 140-170

        //ground5 175-205
        new SpeedPotion(this, "positive").setPosition(new Vec2(190f, 0f));

        //ground6 210-240

        //ground7 245-275
        new SpeedPotion(this, "positive").setPosition(new Vec2(270f, 0f));

        //ground8 280-310

        //ground9 315-345

        //ground10 350-380
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
