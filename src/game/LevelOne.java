package game;

import org.jbox2d.common.Vec2;

import java.awt.*;

public class LevelOne extends GameLevel{

    private Ninja[] ninjas = new Ninja[10];
    private NinjaBoss ninjaBoss;

    public LevelOne(){
        super();

        placePlatforms();
        placeCharacter();
        placeNinjas();
        placeNinjaBoss();
        placeCoins();
        placeMinusCoins();
        placeHealthPotion();
        placeSpeedPotion();

    }


    public Ninja[] getNinja(){return ninjas;}
    public NinjaBoss getNinjaBoss(){return ninjaBoss;}


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

    public void placeCharacter(){
        getCharacter().setPosition(new Vec2(0f, -8f));
    }

    public void placeNinjas(){

        for (int i=0; i< ninjas.length; i++){
            ninjas[i] = new Ninja(this);
        }

        ninjas[0].setPosition(new Vec2(32f,1f));
        ninjas[1].setPosition(new Vec2(60f,1f));
        ninjas[2].setPosition(new Vec2(100f,1f));
        ninjas[3].setPosition(new Vec2(130f,1f));
        ninjas[4].setPosition(new Vec2(160f,1f));
        ninjas[5].setPosition(new Vec2(62f,-15f));
        ninjas[6].setPosition(new Vec2(129f,5f));
        ninjas[7].setPosition(new Vec2(204f,1f));
        ninjas[8].setPosition(new Vec2(246f,-15f));
        ninjas[9].setPosition(new Vec2(283f,1f));

        for (Ninja ninja : ninjas){
            ninja.getWorld().addStepListener(new NinjaController(ninja));
        }
    }

    public void placeNinjaBoss(){

        ninjaBoss = new NinjaBoss(this);
        ninjaBoss.setPosition(new Vec2(319f,5f));
        ninjaBoss.getWorld().addStepListener(new NinjaBossController(ninjaBoss));

    }

    public void placeCoins(){

        for (int i = 0; i < 3; i++){
            new Coin(this).setPosition(new Vec2(4 + i*5, -8f));
        }

        new Coin(this).setPosition(new Vec2(19f,3f));

        for (int i=0; i<2; i++){
            new Coin(this).setPosition(new Vec2(29f + i*5,3f));
        }

        for (int i=0; i<2; i++){
            new Coin(this).setPosition(new Vec2(53f +i*5,4f));
        }

        for (int i =0; i<7 ; i++){
            new Coin(this).setPosition(new Vec2(45f + i*5,-13f));
        }

        for (int i=0; i<5; i++){
            new Coin(this).setPosition(new Vec2(85f + i*5,-8f));
        }

        for (int i=0; i<5; i++){
            new Coin(this).setPosition(new Vec2(115f + i*5,-6f));
        }

        for (int i=0; i<5; i++){
            new Coin(this).setPosition(new Vec2(145f + i*5,-8f));
        }

        for (int i=0; i<6; i++){
            new Coin(this).setPosition(new Vec2(176f + i*8,-13f));
        }

        for (int i=0; i<2; i++){
            new Coin(this).setPosition(new Vec2(181f + i*5,4f));
        }

        for (int i=0; i<2; i++){
            new Coin(this).setPosition(new Vec2(205f + i*5,3f));
        }

        for (int i=0; i<5; i++){
            new Coin(this).setPosition(new Vec2(219f + i*5,-8f));
        }

        for (int i=0; i<2; i++){
            new Coin(this).setPosition(new Vec2(247f + i*18,3f));
        }

        for (int i=0; i<5; i++){
            new Coin(this).setPosition(new Vec2(273f + i*5,-8f));
        }
    }

    public void placeMinusCoins(){

        new MinusCoin(this).setPosition(new Vec2(40f,4f));
        new MinusCoin(this).setPosition(new Vec2(64f,3f));
        new MinusCoin(this).setPosition(new Vec2(117f,5f));
        new MinusCoin(this).setPosition(new Vec2(176f,3f));
        new MinusCoin(this).setPosition(new Vec2(200f,4f));
        new MinusCoin(this).setPosition(new Vec2(251f,4f));
        new MinusCoin(this).setPosition(new Vec2(261f,4f));

    }

    public void placeHealthPotion(){
        new HealthPotion(this).setPosition(new Vec2(262f,-13f));

    }

    public void placeSpeedPotion(){
        new SpeedPotion(this).setPosition(new Vec2(117f,15f));
    }


    @Override
    public Boolean isCompleted() {
        if (getCharacter().getPoints() > 1 || getNinjaBoss().isAlive() == Boolean.FALSE){
            return Boolean.TRUE;
        } else return Boolean.FALSE;
    }


}
