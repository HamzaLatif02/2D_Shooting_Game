package game;

import city.cs.engine.SoundClip;
import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class LevelThree extends GameLevel implements StepListener {

    private Image background;
    //private BombThrower[] bombThrowers = new BombThrower[10];
    private ArrayList<BombThrower> bombThrowers = new ArrayList<>();
    private static SoundClip bgMusic;

    public LevelThree(String populate){
        super(populate);

        if (populate.equals("yes")){
            placePlatforms();
            placePortal();
            placeBombThrowers();
            placeCoins();
            placeMinusCoins();
            placeExplosivesMines();
            placeHealthPotions();
            addStepListener(this);
        }

        setBackground();

    }

    static {
        try {
            bgMusic = new SoundClip("data/bgm4.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    public void setBackground() {
        this.background = new ImageIcon("data/level3/background3.png").getImage();
    }

    public ArrayList<BombThrower> getBombThrowers() {
        return bombThrowers;
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

        //ground1 coordinates 79-109

        new SinglePlatform(this).setPosition(new Vec2(107f, 25f));

        //ground2 coordinates 114-144

        new SinglePlatform(this, "vertical").setPosition(new Vec2(117f, 35f));
        new SinglePlatform(this, "vertical").setPosition(new Vec2(129f, 35f));
        new SinglePlatform(this, "vertical").setPosition(new Vec2(141f, 35f));

        //ground3 coordinates 149-179

        new SinglePlatform(this).setPosition(new Vec2(152f, 37f));
        new SinglePlatform(this).setPosition(new Vec2(152f, 33f));
        new SinglePlatform(this).setPosition(new Vec2(152f, 29f));

        new SinglePlatform(this).setPosition(new Vec2(164f, 21f));
        new SinglePlatform(this).setPosition(new Vec2(164f, 25f));
        new SinglePlatform(this).setPosition(new Vec2(164f, 29f));

        new SinglePlatform(this).setPosition(new Vec2(176f, 37f));
        new SinglePlatform(this).setPosition(new Vec2(176f, 33f));
        new SinglePlatform(this).setPosition(new Vec2(176f, 29f));

        //ground4 coordinates 184-214

        new DoublePlatform(this).setPosition(new Vec2(190f, 32f));
        new DoublePlatform(this).setPosition(new Vec2(208f, 26f));

        //ground5 coordinates 219-249

        //ground6 coordinates 254-284

        new DoublePlatform(this).setPosition(new Vec2(260f, 26f));
        new DoublePlatform(this).setPosition(new Vec2(278f, 32f));

        //ground7 coordinates 289-319

        new SinglePlatform(this).setPosition(new Vec2(292f, 21f));
        new SinglePlatform(this).setPosition(new Vec2(292f, 25f));
        new SinglePlatform(this).setPosition(new Vec2(292f, 29f));

        new SinglePlatform(this).setPosition(new Vec2(304f, 37f));
        new SinglePlatform(this).setPosition(new Vec2(304f, 33f));
        new SinglePlatform(this).setPosition(new Vec2(304f, 29f));

        new SinglePlatform(this).setPosition(new Vec2(316f, 21f));
        new SinglePlatform(this).setPosition(new Vec2(316f, 25f));
        new SinglePlatform(this).setPosition(new Vec2(316f, 29f));

        //ground8 coordinates 324-354

        new SinglePlatform(this).setPosition(new Vec2(327f, 37f));
        new SinglePlatform(this).setPosition(new Vec2(327f, 29f));

        new SinglePlatform(this).setPosition(new Vec2(339f, 21f));
        new SinglePlatform(this).setPosition(new Vec2(339f, 29f));

        new SinglePlatform(this).setPosition(new Vec2(351f, 37f));
        new SinglePlatform(this).setPosition(new Vec2(351f, 29f));

        //ground9 coordinates 359-389

        new SinglePlatform(this, "vertical").setPosition(new Vec2(362f, 35f));
        new SinglePlatform(this, "vertical").setPosition(new Vec2(374f, 35f));
        new SinglePlatform(this, "vertical").setPosition(new Vec2(386f, 35f));

        //ground10 coordinates 394-424

        //

        new SinglePlatform(this).setPosition(new Vec2(422f, 21f));
        new SinglePlatform(this).setPosition(new Vec2(422f, 37f));

        new Portal(this, "gravity", "right").setPosition(new Vec2(426f, 29f));

        new GroundPlatform(this).setPosition(new Vec2(444f, 11.5f));
        new WallPlatform(this).setPosition(new Vec2(460f, 19f));

    }

    public void placeBombThrowers(){


        for (int i=0; i<10; i++){
            bombThrowers.add (new BombThrower(this));
        }

        bombThrowers.get(0).setPosition(new Vec2(30f, 29f));
        bombThrowers.get(1).setPosition(new Vec2(50f, 29f));
        bombThrowers.get(2).setPosition(new Vec2(70f, 29f));
        bombThrowers.get(3).setPosition(new Vec2(107f, 29f));
        bombThrowers.get(4).setPosition(new Vec2(190f, 36f));
        bombThrowers.get(5).setPosition(new Vec2(208f, 30f));
        bombThrowers.get(6).setPosition(new Vec2(260f, 30f));
        bombThrowers.get(7).setPosition(new Vec2(278f, 36f));
        bombThrowers.get(8).setPosition(new Vec2(339f, 25f));
        bombThrowers.get(9).setPosition(new Vec2(351f, 33f));

    }

    public void placeCoins(){
        for (int i=0; i<3; i++){
            new Coin(this, "single").setPosition(new Vec2(6+i*4, -8f));
        }

        for (int i=0; i<2; i++){
            new Coin(this, "single").setPosition(new Vec2(22+i*4, -1f));
        }

        for (int i=0; i<2; i++){
            new Coin(this, "single").setPosition(new Vec2(28+i*4, 11f));
        }

        for (int i=0; i<4; i++){
            for (int j=0; j<2; j++){
                new Coin(this, "single").setPosition(new Vec2(38+(j*4)+(i*10), 29f));
            }
        }

        //ground1
        for (int i=0; i<2; i++){
            for (int j=0; j<5; j++){
                new Coin(this, "single").setPosition(new Vec2(86+j*4, 29+(i*4)));
            }
        }

        //ground2
        for (int i=0; i<2; i++){
            for (int j=0; j<5; j++){
                new Coin(this, "single").setPosition(new Vec2(121+j*4, 21 + i*16));
            }
        }

        //ground3
        for (int i=0; i<2; i++){
            for (int j=0; j<5; j++){
                new Coin(this, "single").setPosition(new Vec2(158+i*12, 21 + j*4));
            }
        }

        //ground4
        for (int i=0; i<2; i++){
            new Coin(this, "single").setPosition(new Vec2(188+i*4, 36f));
        }

        for (int i=0; i<2; i++){
            new Coin(this, "single").setPosition(new Vec2(206+i*4, 30f));
        }

        //ground5
        for (int i=0; i<5; i++){
            for (int j=0; j<7; j++){
                new Coin(this, "single").setPosition(new Vec2(222+j*4, 21+i*4));
            }
        }

        //ground6
        for (int i=0; i<2; i++){
            new Coin(this, "single").setPosition(new Vec2(258+i*4, 30f));
        }

        for (int i=0; i<2; i++){
            new Coin(this, "single").setPosition(new Vec2(276+i*4, 36f));
        }

        //ground7
        for (int i=0; i<2; i++){
            for (int j=0; j<5; j++){
                new Coin(this, "single").setPosition(new Vec2(298+i*12, 21 + j*4));
            }
        }

        //ground8
        for (int i=0; i<2; i++){
            for (int j=0; j<5; j++){
                new Coin(this, "single").setPosition(new Vec2(333+i*12, 21 + j*4));
            }
        }

        //ground9
        for (int i=0; i<2; i++){
            for (int j=0; j<5; j++){
                new Coin(this, "single").setPosition(new Vec2(366+j*4, 21 + i*16));
            }
        }

        //ground10
        for (int i=0; i<2; i++){
            for (int j=0; j<5; j++){
                new Coin(this, "single").setPosition(new Vec2(401+j*4, 29+(i*4)));
            }
        }
    }

    public void placeMinusCoins(){
        //ground1
        for (int i=0; i<2; i++){
            new MinusCoin(this).setPosition(new Vec2(105f, 21+i*16));
        }

        //ground2
        for (int i=0; i<2; i++){
            for (int j=0; j<2; j++){
                new MinusCoin(this).setPosition(new Vec2(115f + j*28, 21+i*16));
            }
        }

        //ground9
        for (int i=0; i<2; i++){
            for (int j=0; j<2; j++){
                new MinusCoin(this).setPosition(new Vec2(360f + j*28, 21+i*16));
            }
        }

        //ground10
        for (int i=0; i<2; i++){
            new MinusCoin(this).setPosition(new Vec2(398f, 21+i*16));
        }
    }

    public void placeExplosivesMines(){
        new ExplosiveMine(this).setPosition(new Vec2(60f, 35f));

        for (int i=0; i<10; i++){
            new ExplosiveMine(this).setPosition(new Vec2(111.5f + i*35f, 29f));
        }

        new ExplosiveMine(this).setPosition(new Vec2(164f, 33f));
        new ExplosiveMine(this).setPosition(new Vec2(304f, 25f));
    }

    public void placeHealthPotions(){
        new HealthPotion(this, "positive").setPosition(new Vec2(199f, 29f));
    }

    public void placePortal(){
        getPortal().setPosition(new Vec2(458f,30.5f));
    }

    @Override
    public Boolean objectivesDone() {
        if (getCharacter().getPoints() > 120 && getCharacter().getEnemiesKilled() == 10){
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
        return "LevelThree";
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

    @Override
    public void preStep(StepEvent stepEvent) {
        for (BombThrower bombThrower : bombThrowers){
            if (!bombThrower.isAlive() && !bombThrower.getKillAdded()){
                getCharacter().setEnemiesKilled(getCharacter().getEnemiesKilled()+1);
                bombThrower.setKillAdded(Boolean.TRUE);
            }
        }
    }

    @Override
    public void postStep(StepEvent stepEvent) {

    }
}
