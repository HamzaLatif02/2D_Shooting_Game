package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import java.awt.print.Book;

public class GameWorld extends World {

    private Character character;
    private Ninja ninja;

    public GameWorld() {
        super();

        placePlatforms();

        character = new Character(this);
        character.setPosition(new Vec2(0f, -8f));
        CoinPickup coinPickup = new CoinPickup(character);
        character.addCollisionListener(coinPickup);

        ninja = new Ninja(this);
        ninja.setPosition(new Vec2(-10f,-8f));


        new Coin(this).setPosition(new Vec2(10f,-10f));
        new MinusCoin(this).setPosition(new Vec2(8f,-8f));

    }

    public Character getCharacter() {
        return character;
    }

    public void placePlatforms(){
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
    }
}
