package game;

import city.cs.engine.SoundClip;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class LevelFour extends GameLevel{

    private Image background;
    private Timer timer;
    private static SoundClip bgMusic;

    public LevelFour(String populate){
        super(populate);

        if (getPopulate().equals("yes")){
            placePlatforms();
            placeExplosiveMines();
            placeHealthPotions();
            placeSpeedPotions();
            placePortal();
        }
        timer = new Timer(this);
        setBackground();
    }

    public Timer getTimer() {
        return timer;
    }

    static {
        try {
            bgMusic = new SoundClip("data/bgm5.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    public void placePlatforms(){
        new WallPlatform(this).setPosition(new Vec2(-16f, 0f));
        new GroundPlatform(this).setPosition(new Vec2(0f, -17.5f));

        new DoublePlatform(this).setPosition(new Vec2(20f, -12f));
        new DoublePlatform(this).setPosition(new Vec2(30f, -12f));

        new Portal(this, "gravity", "start").setPosition(new Vec2(35f, 0f));

        new SinglePlatform(this).setPosition(new Vec2(39f, -8f));
        new SinglePlatform(this).setPosition(new Vec2(39f, 8f));

        for (int i=0; i<10; i++){
            new GroundPlatform(this).setPosition(new Vec2(50f + i*35, -17.5f));
        }

        for (int i=0; i<10; i++){
            new GroundPlatform(this).setPosition(new Vec2(50f + i*35, 17.5f));
        }

        //ground1 35-65
        for (int i=0; i<5; i++){
            new SinglePlatform(this).setPosition(new Vec2(47 + i*4, 0f));
        }

        //ground2 70-100
        new DoublePlatform(this).setPosition(new Vec2(85, 0f));

        //ground3 105-135
        new SinglePlatform(this).setPosition(new Vec2(120f, -8f));
        new SinglePlatform(this).setPosition(new Vec2(120f, 8f));

        //ground4 140-170
        new DoublePlatform(this, "horizontal").setPosition(new Vec2(162.5f, 6f));
        new DoublePlatform(this, "horizontal").setPosition(new Vec2(162.5f, -6f));

        //ground5 175-205

        //ground6 210-240
        new SinglePlatform(this).setPosition(new Vec2(212f, 8f));
        new SinglePlatform(this).setPosition(new Vec2(212f, 4f));

        new SinglePlatform(this).setPosition(new Vec2(238f, 8f));
        new SinglePlatform(this).setPosition(new Vec2(238f, 4f));

        //ground7 245-275
        new DoublePlatform(this, "horizontal").setPosition(new Vec2(272.5f, 6f));
        new DoublePlatform(this, "horizontal").setPosition(new Vec2(272.5f, -6f));

        //ground8 280-310
        new SinglePlatform(this, "vertical").setPosition(new Vec2(282f, 6f));
        new SinglePlatform(this, "vertical").setPosition(new Vec2(290f, 6f));

        new SinglePlatform(this,"vertical").setPosition(new Vec2(300f, 6f));
        new SinglePlatform(this,"vertical").setPosition(new Vec2(308f, 6f));

        //ground9 315-345

        //ground10 350-380
        for (int i=0; i<5; i++){
            new SinglePlatform(this).setPosition(new Vec2(356 + i*4, 0f));
        }

        new SinglePlatform(this).setPosition(new Vec2(376f, -8f));
        new SinglePlatform(this).setPosition(new Vec2(376f, 8f));

        new Portal(this, "gravity", "end").setPosition(new Vec2(380, 0f));

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
        new ExplosiveMine(this, "double").setPosition(new Vec2(295f, 0f));

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

    //level is completed if the user finishes under 1 minute
    @Override
    public Boolean objectivesDone() {
        if ((timer.getMinutes() > 1 && timer.getSeconds() < 60 || timer.getSeconds() != 0) || (timer.getMinutes() == 1 && timer.getSeconds() == 0)){
            return Boolean.TRUE;
        }
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
        bgMusic.setVolume(0.5);
        bgMusic.loop();
    }

    @Override
    public SoundClip getBackgroundMusic() {
        return bgMusic;
    }
}
