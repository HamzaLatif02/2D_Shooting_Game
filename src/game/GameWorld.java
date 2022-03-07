package game;

import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import city.cs.engine.World;
import org.jbox2d.common.Vec2;

public class GameWorld extends World {

    private Character character;
    private Ninja ninja;

    public GameWorld() {
        super();

        Shape shape = new BoxShape(11, 0.5f);
        StaticBody ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(0f, -11.5f));

        Shape platformShape = new BoxShape(3, 0.5f);
        StaticBody platform1 = new StaticBody(this, platformShape);
        platform1.setPosition(new Vec2(-8, -4f));

        character = new Character(this);
        character.setPosition(new Vec2(5, -9f));

        ninja = new Ninja(this);
        ninja.setPosition(new Vec2(0,-5));



    }

    public Character getCharacter() {
        return character;
    }
}
