package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class GameWorld extends World {

    private Character character;
    private Ninja[] ninja = new Ninja[5];

    public GameWorld() {
        super();

        placePlatforms();
        placeCharacter();
        placeNinjas();


        new Coin(this).setPosition(new Vec2(10f,-10f));
        new MinusCoin(this).setPosition(new Vec2(8f,-8f));

    }

    public Character getCharacter() {
        return character;
    }

    public Ninja[] getNinja(){return ninja;}

    public void placePlatforms(){

        new WallPlatform(this).setPosition(new Vec2(-16f,0f));

        new GroundPlatform(this).setPosition(new Vec2(0f,-17.5f));

        new SinglePlatform(this).setPosition(new Vec2(19f,-1f));

        new DoublePlatform(this).setPosition(new Vec2(32f,-1f));
        new DoublePlatform(this).setPosition(new Vec2(40f,0f));
        new DoublePlatform(this).setPosition(new Vec2(56f,0f));
        new DoublePlatform(this).setPosition(new Vec2(64f,-1f));

        new SinglePlatform(this).setPosition(new Vec2(76f,-1f));

        new GroundPlatform(this).setPosition(new Vec2(95f,-17.5f));
        new GroundPlatform(this).setPosition(new Vec2(125f,-15.5f));
        new GroundPlatform(this).setPosition(new Vec2(155f,-17.5f));

        new DoublePlatform(this).setPosition(new Vec2(176f,-1f));
        new DoublePlatform(this).setPosition(new Vec2(184f,0f));
        new DoublePlatform(this).setPosition(new Vec2(200f,0f));
        new DoublePlatform(this).setPosition(new Vec2(208f,-1f));

        new GroundPlatform(this).setPosition(new Vec2(229f,-17.5f));

        new SinglePlatform(this).setPosition(new Vec2(248f,-1f));
        new SinglePlatform(this).setPosition(new Vec2(252f,0f));
        new SinglePlatform(this).setPosition(new Vec2(260f,0f));
        new SinglePlatform(this).setPosition(new Vec2(264f,-1f));

        new GroundPlatform(this).setPosition(new Vec2(283f,-17.5f));

        new WallPlatform(this).setPosition(new Vec2(299f,0f));
    }

    public void placeCharacter(){
        character = new Character(this);
        character.setPosition(new Vec2(0f, -8f));
        CoinPickup coinPickup = new CoinPickup(character);
        character.addCollisionListener(coinPickup);
    }

    public void placeNinjas(){
        for (int i=0; i< ninja.length; i++){
            ninja[i] = new Ninja(this);
        }

        ninja[0].setPosition(new Vec2(32f,1f));
        ninja[1].setPosition(new Vec2(60f,1f));
        ninja[2].setPosition(new Vec2(100f,1f));
        ninja[3].setPosition(new Vec2(130f,1f));
        ninja[4].setPosition(new Vec2(160f,1f));

        for (Ninja ninja : ninja){
            ninja.getWorld().addStepListener(new NinjaController(ninja));
        }
    }

}
