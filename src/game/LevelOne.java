package game;

import city.cs.engine.SoundClip;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

/**
 * First level of the game
 */
public class LevelOne extends GameLevel{

    private ArrayList<Ninja> ninjas = new ArrayList<>();
    private ArrayList<NinjaBoss> ninjaBoss = new ArrayList<>();
    private Image background;
    private static SoundClip bgMusic;

    /**
     * Initialise a new Level One
     * @param populate whether to place all the objects in the level
     */
    public LevelOne(String populate){
        super(populate);
        if (getPopulate().equals("yes")){
            placePlatforms();
            placeNinjas();
            placeNinjaBoss();
            placeCoins();
            placeMinusCoins();
            placeHealthPotion();
            placeSpeedPotion();
            placePortal();
        }
        setBackground();
    }

    /**
     * Try and load background music
     */
    static {
        try {
            bgMusic = new SoundClip("data/bgm2.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    /**
     * Get ninja field
     * @return ninjas field
     */
    public ArrayList<Ninja> getNinja(){return ninjas;}

    /**
     * Get ninja boss field
     * @return ninjaBoss field
     */
    public ArrayList<NinjaBoss> getNinjaBoss(){return ninjaBoss;}

    /**
     * Set background of the level
     */
    public void setBackground(){
        background = new ImageIcon("data/level1/background.gif").getImage();
    }

    /**
     * Place all the platforms in the level
     */
    public void placePlatforms(){

        new WallPlatform(this).setPosition(new Vec2(-16f,0f));

        new GroundPlatform(this).setPosition(new Vec2(0f,-17.5f));

        new SinglePlatform(this).setPosition(new Vec2(19f,-1f));

        for (int i=0; i < 5; i++){
            new DoublePlatform(this).setPosition(new Vec2(48f + i*9, -17f));
        }

        new DoublePlatform(this).setPosition(new Vec2(32f,-1f));
        new DoublePlatform(this).setPosition(new Vec2(40f,0f));
        new DoublePlatform(this).setPosition(new Vec2(56f,0f));
        new DoublePlatform(this).setPosition(new Vec2(64f,-1f));

        new SinglePlatform(this).setPosition(new Vec2(76f,-1f));

        new GroundPlatform(this).setPosition(new Vec2(95f,-17.5f));
        new GroundPlatform(this).setPosition(new Vec2(125f,-15.5f));
        new GroundPlatform(this).setPosition(new Vec2(155f,-17.5f));

        new DoublePlatform(this).setPosition(new Vec2(117f, 1f));
        new DoublePlatform(this).setPosition(new Vec2(117f, 11f));
        new DoublePlatform(this).setPosition(new Vec2(133f, 1f));

        for (int i=0; i < 6; i ++){
            new SinglePlatform(this).setPosition(new Vec2(176f + i*8, -17f));
        }

        new DoublePlatform(this).setPosition(new Vec2(176f,-1f));
        new DoublePlatform(this).setPosition(new Vec2(184f,0f));
        new DoublePlatform(this).setPosition(new Vec2(200f,0f));
        new DoublePlatform(this).setPosition(new Vec2(208f,-1f));

        new GroundPlatform(this).setPosition(new Vec2(229f,-17.5f));

        for (int i=0; i < 2; i++){
            new DoublePlatform(this).setPosition(new Vec2(250f + i*12, -17f));
        }

        new SinglePlatform(this).setPosition(new Vec2(247f,-1f));
        new SinglePlatform(this).setPosition(new Vec2(251f,0f));
        new SinglePlatform(this).setPosition(new Vec2(261f,0f));
        new SinglePlatform(this).setPosition(new Vec2(265f,-1f));

        new GroundPlatform(this).setPosition(new Vec2(283f,-17.5f));
        new GroundPlatform(this).setPosition(new Vec2(313f,-15.5f));

        new WallPlatform(this).setPosition(new Vec2(329f,0f));
    }

    /**
     * Place all the ninjas in the level
     */
    public void placeNinjas(){

        for (int i=0; i< 10; i++){
            ninjas.add(new Ninja(this));
        }

        ninjas.get(0).setPosition(new Vec2(32f,1f));
        ninjas.get(1).setPosition(new Vec2(60f,1f));
        ninjas.get(2).setPosition(new Vec2(100f,1f));
        ninjas.get(3).setPosition(new Vec2(130f,1f));
        ninjas.get(4).setPosition(new Vec2(160f,1f));
        ninjas.get(5).setPosition(new Vec2(62f,-15f));
        ninjas.get(6).setPosition(new Vec2(129f,5f));
        ninjas.get(7).setPosition(new Vec2(204f,1f));
        ninjas.get(8).setPosition(new Vec2(246f,-15f));
        ninjas.get(9).setPosition(new Vec2(283f,1f));
    }

    /**
     * Place all the ninja bosses in the level
     */
    public void placeNinjaBoss(){
        ninjaBoss.add(new NinjaBoss(this));
        ninjaBoss.get(0).setPosition(new Vec2(319f, 5f));
    }

    /**
     * Place all the coins in the level
     */
    public void placeCoins(){

        for (int i = 0; i < 3; i++){
            new Coin(this, "single").setPosition(new Vec2(4 + i*5, -8f));
        }

        new Coin(this, "single").setPosition(new Vec2(19f,3f));

        for (int i=0; i<2; i++){
            new Coin(this, "single").setPosition(new Vec2(29f + i*5,3f));
        }

        for (int i=0; i<2; i++){
            new Coin(this, "single").setPosition(new Vec2(53f +i*5,4f));
        }

        for (int i =0; i<7 ; i++){
            new Coin(this, "single").setPosition(new Vec2(45f + i*5,-13f));
        }

        for (int i=0; i<5; i++){
            new Coin(this, "single").setPosition(new Vec2(85f + i*5,-8f));
        }

        for (int i=0; i<5; i++){
            new Coin(this, "single").setPosition(new Vec2(115f + i*5,-6f));
        }

        for (int i=0; i<5; i++){
            new Coin(this, "single").setPosition(new Vec2(145f + i*5,-8f));
        }

        for (int i=0; i<5; i++){
            new Coin(this, "single").setPosition(new Vec2(176f + i*8,-13f));
        }

        for (int i=0; i<2; i++){
            new Coin(this, "single").setPosition(new Vec2(181f + i*5,4f));
        }

        for (int i=0; i<2; i++){
            new Coin(this, "single").setPosition(new Vec2(205f + i*5,3f));
        }

        for (int i=0; i<5; i++){
            new Coin(this, "single").setPosition(new Vec2(219f + i*5,-8f));
        }

        for (int i=0; i<2; i++){
            new Coin(this, "single").setPosition(new Vec2(247f + i*18,3f));
        }

        for (int i=0; i<5; i++){
            new Coin(this, "single").setPosition(new Vec2(273f + i*5,-8f));
        }
    }

    /**
     * Place all the minus coins in the level
     */
    public void placeMinusCoins(){
        new MinusCoin(this).setPosition(new Vec2(40f,4f));
        new MinusCoin(this).setPosition(new Vec2(64f,3f));
        new MinusCoin(this).setPosition(new Vec2(117f,5f));
        new MinusCoin(this).setPosition(new Vec2(176f,3f));
        new MinusCoin(this).setPosition(new Vec2(200f,4f));
        new MinusCoin(this).setPosition(new Vec2(251f,4f));
        new MinusCoin(this).setPosition(new Vec2(261f,4f));

    }

    /**
     * Place all the health potions in the level
     */
    public void placeHealthPotion(){
        new HealthPotion(this, "positive").setPosition(new Vec2(262f,-13f));

    }

    /**
     * Place all the speed potions in the level
     */
    public void placeSpeedPotion(){
        new SpeedPotion(this, "positive").setPosition(new Vec2(117f,15f));
    }

    /**
     * place all the portals in the level
     */
    public void placePortal(){
        getPortal().setPosition(new Vec2(327f, 4.5f));
    }

    /**
     * Check if the final boss is alive
     * @return whether the final boss is alive
     */
    public Boolean checkBossAlive(){
        for (NinjaBoss ninjaBoss : ninjaBoss){
            if (ninjaBoss.isAlive() == Boolean.FALSE){
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }

    //level is completed if the user has collected more than 44 coins and defeated the final boss
    /**
     * Level is completed if the user has collected more than 44 coins and defeated the final boss
     * @return whether the user has completed all the objectives
     */
    @Override
    public Boolean objectivesDone() {
        if (getCharacter().getPoints() > 44 && checkBossAlive() == Boolean.FALSE){
            return Boolean.TRUE;
        } else {return Boolean.FALSE;}
    }

    /**
     * Get background image
     * @return background field
     */
    @Override
    public Image getBackground(){
        return background;
    }

    /**
     * Level name
     * @return string "LevelOne"
     */
    @Override
    public String getLevelName() {
        return "LevelOne";
    }

    /**
     * Start the background music
     */
    @Override
    public void startBackgroundMusic() {
        bgMusic.setVolume(0.5);
        bgMusic.loop();
    }

    /**
     * Get background music
     * @return bgMusic field
     */
    @Override
    public SoundClip getBackgroundMusic() {
        return bgMusic;
    }
}
