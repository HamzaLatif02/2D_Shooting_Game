package game;

import city.cs.engine.SoundClip;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class LevelTwo extends GameLevel{

    private Image background;
    private ArrayList<Mummy> mummies = new ArrayList<>();
    private ArrayList<MummyBoss> mummyBoss = new ArrayList<>();
    private static SoundClip bgMusic;


    public LevelTwo(String populate){
        super(populate);

        if (populate.equals("yes")){
            placePlatforms();
            placeMummies();
            placeMummyBoss();
            placeHealthPotions();
            placeSpeedpotions();
            placeCoins();
            placeMinusCoins();
            placePortal();
        }
        setBackground();
    }

    static {
        try {
            bgMusic = new SoundClip("data/bgm3.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    public ArrayList<Mummy> getMummies() {
        return mummies;
    }

    public ArrayList<MummyBoss> getMummyBoss() {
        return mummyBoss;
    }

    public void setBackground(){
        background = new ImageIcon("data/level2/background2.png").getImage();
    }

    public void placePlatforms(){

        new WallPlatform(this).setPosition(new Vec2(-16f,0f));

        new GroundPlatform(this).setPosition(new Vec2(0f,-17.5f));

        new DoublePlatform(this, "horizontal").setPosition(new Vec2(30f, -5f));
        new DoublePlatform(this, "horizontal").setPosition(new Vec2(45f,-1f));

        new GroundPlatform(this).setPosition(new Vec2(70f, -17.5f));

        new SinglePlatform(this).setPosition(new Vec2(70f, -8f));
        new SinglePlatform(this).setPosition(new Vec2(60f,0f));
        new SinglePlatform(this).setPosition(new Vec2(80f,0f));
        new SinglePlatform(this).setPosition(new Vec2(50f,8f));
        new SinglePlatform(this).setPosition(new Vec2(90f,8f));
        new SinglePlatform(this).setPosition(new Vec2(60f,16f));
        new SinglePlatform(this).setPosition(new Vec2(80f,16f));
        new SinglePlatform(this).setPosition(new Vec2(70f,24f));

        new SinglePlatform(this).setPosition(new Vec2(70f, 8f));

        new DoublePlatform(this, "horizontal").setPosition(new Vec2(105f,-8f));
        new DoublePlatform(this, "horizontal").setPosition(new Vec2(120f, 0f));
        new DoublePlatform(this, "horizontal").setPosition(new Vec2(135f, -8f));

        new GroundPlatform(this).setPosition(new Vec2(160f,-17.5f));

        new DoublePlatform(this, "vertical").setPosition(new Vec2(175f, 16f));
        new DoublePlatform(this).setPosition(new Vec2(185f, 16f));
        new DoublePlatform(this).setPosition(new Vec2(200f, 16f));
        new DoublePlatform(this).setPosition(new Vec2(215f, 16f));
        new DoublePlatform(this).setPosition(new Vec2(230f, 16f));
        new DoublePlatform(this).setPosition(new Vec2(245f, 16f));
        new DoublePlatform(this, "vertical").setPosition(new Vec2(255f, 16f));

        new GroundPlatform(this).setPosition(new Vec2(270f,-17.5f));

        new DoublePlatform(this, "vertical").setPosition(new Vec2(285f, 16f));

        new SinglePlatform(this).setPosition(new Vec2(295f, 16f));

        new DoublePlatform(this, "vertical").setPosition(new Vec2(305f, 32f));

        new GroundPlatform( this).setPosition(new Vec2(330f, 26.5f));

        new WallPlatform(this).setPosition(new Vec2(346f,34f));

    }

    public void placeMummies(){

        for (int i =0; i<5; i++){
            mummies.add(new Mummy(this, "no"));
        }

        for (int i=5; i< 10; i++){
            mummies.add(new Mummy(this, "yes"));
        }

        mummies.get(0).setPosition(new Vec2(70f,-4f));
        mummies.get(1).setPosition(new Vec2(70f, 12f));
        mummies.get(2).setPosition(new Vec2(90f, 12f));
        mummies.get(3).setPosition(new Vec2(200f, 20f));
        mummies.get(4).setPosition(new Vec2(295f, 20f));

        mummies.get(5).setPosition(new Vec2(170f, -8f));
        mummies.get(6).setPosition(new Vec2(219f,20f));
        mummies.get(7).setPosition(new Vec2(234f, 20f));
        mummies.get(8).setPosition(new Vec2(280f, -8f));
        mummies.get(9).setPosition(new Vec2(335f, 36f));

    }

    public void placeMummyBoss(){
        mummyBoss.add(new MummyBoss(this));
        mummyBoss.get(0).setPosition(new Vec2(340f,39f));
    }

    public void placeHealthPotions(){
        new HealthPotion(this, "negative").setPosition(new Vec2(70f, 12f));
        new HealthPotion(this, "positive").setPosition(new Vec2(305f, 36f));
    }

    public void placeSpeedpotions(){
        new SpeedPotion(this, "negative").setPosition(new Vec2(170f, -8f));
        new SpeedPotion(this, "positive").setPosition(new Vec2(285f, 20f));
    }

    public void placeCoins(){

        for (int i=0; i<3; i++){
            new Coin(this, "single").setPosition(new Vec2(4 + i*5, -8f));
        }

        for (int i=0; i<2; i++){
            new Coin(this, "single").setPosition(new Vec2(20 + i*5, -1f));
        }

        for (int i=0; i<2; i++){
            new Coin(this, "single").setPosition(new Vec2(35 + i*5, 3f));
        }

        for (int i=0; i<2; i++){
            new Coin(this, "single").setPosition(new Vec2(60 + i*3, -8f));
        }

        for (int i=0; i<2; i++){
            new Coin(this, "single").setPosition(new Vec2(78 + i*3, -8f));
        }

        for (int i=0; i<2; i++){
            for (int j=0; j<2; j++){
                new Coin(this, "single").setPosition(new Vec2(60 + i*20, 4 + j*16));
            }
        }

        for (int i=0; i<2; i++){
            new Coin(this, "single").setPosition(new Vec2(50 + i*40, 12f));
        }

        new Coin(this, "double").setPosition(new Vec2(70f, 28f));

        for (int i=0; i<2; i++){
            new Coin(this, "single").setPosition(new Vec2(95 + i*5, -4f));
        }

        for (int i=0; i<2; i++){
            new Coin(this, "single").setPosition(new Vec2(110 + i*5, 4f));
        }

        for (int i=0; i<2; i++){
            new Coin(this, "single").setPosition(new Vec2(125 + i*5, -4f));
        }

        for (int i=0; i<6; i++){
            new Coin(this, "single").setPosition(new Vec2(146 + i*3, -8f));
        }

        new Coin(this, "double").setPosition(new Vec2(175f, 24f));

        for (int i=0; i<2; i++){
            new Coin(this, "single").setPosition(new Vec2(183 + i*5, 20f));
        }

        for (int i=0; i<2; i++){
            new Coin(this, "single").setPosition(new Vec2(198 + i*5, 20f));
        }

        for (int i=0; i<2; i++){
            new Coin(this, "single").setPosition(new Vec2(228 + i*5, 20f));
        }

        for (int i=0; i<2; i++){
            new Coin(this, "single").setPosition(new Vec2(243 + i*5, 20f));
        }

        for (int i =0; i<3; i++){
            new Coin(this, "single").setPosition(new Vec2(256 + i*5, -8f));
        }

        new Coin(this, "single").setPosition(new Vec2(285f, 8f));
        new Coin(this, "double").setPosition(new Vec2(295f, 26f));
        new Coin(this, "single").setPosition(new Vec2(305f, 24f));
        new Coin(this, "single").setPosition(new Vec2(314f, 36f));

    }

    public void placeMinusCoins(){
        for (int i=0; i<2; i++){
            new MinusCoin(this).setPosition(new Vec2(57 + i*9, -8f));
        }

        for (int i=0; i<2; i++){
            new MinusCoin(this).setPosition(new Vec2(75 + i*9, -8f));
        }

        new MinusCoin(this).setPosition(new Vec2(215f, 20f));
    }

    public void placePortal(){
        getPortal().setPosition(new Vec2(344f, 45.5f));
    }

    public Boolean checkBossAlive(){
        for (MummyBoss mummyBoss : mummyBoss){
            if (mummyBoss.isAlive() == Boolean.FALSE){
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean objectivesDone() {
        if (getCharacter().getPoints() > 0 || checkBossAlive() == Boolean.FALSE){
            return Boolean.TRUE;
        } else {return Boolean.FALSE;}
    }

    @Override
    public Image getBackground(){return background;}

    @Override
    public String getLevelName() {
        return "LevelTwo";
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
