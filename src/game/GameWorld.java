package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import java.awt.print.Book;

public class GameWorld extends World {

    private Character character;
    private Ninja ninja;

    public GameWorld() {
        super();

        new GroundPlatform(this).setPosition(new Vec2(-10f,-17.5f));
        new GroundPlatform(this).setPosition(new Vec2(30f,-17.5f));

        new SinglePlatform(this).setPosition(new Vec2(10f,-1f));

        new DoublePlatform(this).setPosition(new Vec2(50f,-1f));

        character = new Character(this);
        character.setPosition(new Vec2(-10f, -8f));
        CoinPickup coinPickup = new CoinPickup(character);
        character.addCollisionListener(coinPickup);

        ninja = new Ninja(this);
        ninja.setPosition(new Vec2(0f,-8f));


        new Coin(this).setPosition(new Vec2(10f,2f));
        new MinusCoin(this).setPosition(new Vec2(18f,-8f));
    }

    public Character getCharacter() {
        return character;
    }
}
