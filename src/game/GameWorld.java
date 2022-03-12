package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class GameWorld extends World {

    private Character character;
    private Ninja[] ninjas = new Ninja[10];
    private NinjaBoss ninjaBoss;
    //private Coin[] coins = new Coin[100];
    //private MinusCoin[] minusCoins = new MinusCoin[3];


    public GameWorld() {
        super();

        placePlatforms();
        placeCharacter();
        placeNinjas();
        placeNinjaBoss();

        new Coin(this).setPosition(new Vec2(10f,-8f));
        new Coin(this).setPosition(new Vec2(32f,3f));
        new Coin(this).setPosition(new Vec2(12,-8f));
        new MinusCoin(this).setPosition(new Vec2(8f,-8f));
    }

    public Character getCharacter() {
        return character;
    }

    public Ninja[] getNinja(){return ninjas;}

    public NinjaBoss getNinjaBoss(){return ninjaBoss;}

    public void placePlatforms(){

        new WallPlatform(this).setPosition(new Vec2(-16f,0f));

        new GroundPlatform(this).setPosition(new Vec2(0f,-17.5f));

        new SinglePlatform(this).setPosition(new Vec2(19f,-1f));

        for (int i=0; i < 28; i+= 9){
            new DoublePlatform(this).setPosition(new Vec2(48f + i, -17f));
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

        for (int i=0; i < 33; i += 8){
            new SinglePlatform(this).setPosition(new Vec2(176f + i, -17f));
        }

        new DoublePlatform(this).setPosition(new Vec2(176f,-1f));
        new DoublePlatform(this).setPosition(new Vec2(184f,0f));
        new DoublePlatform(this).setPosition(new Vec2(200f,0f));
        new DoublePlatform(this).setPosition(new Vec2(208f,-1f));

        new GroundPlatform(this).setPosition(new Vec2(229f,-17.5f));

        for (int i=0; i < 13; i+= 12){
            new DoublePlatform(this).setPosition(new Vec2(250f + i, -17f));
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
        character = new Character(this);
        character.setPosition(new Vec2(0f, -8f));
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

}
