package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class GameWorld extends World {

    private Character character;
    private Ninja ninja;

    public GameWorld() {
        super();

        Shape groundShape = new BoxShape(15f, 7.5f);
        StaticBody ground = new StaticBody(this, groundShape);
        ground.setPosition(new Vec2(-10f, -17.5f));
        ground.addImage(new BodyImage("data/platform-long.png",30f));
        //ground.setAlwaysOutline(true);

        StaticBody ground2 = new StaticBody(this,groundShape);
        ground2.setPosition(new Vec2(30f,-17.5f));
        ground2.addImage(new BodyImage("data/platform-long.png",30f));
        //ground2.setAlwaysOutline(true);


        Shape singlePlatformShape = new BoxShape(2, 2f);
        StaticBody platform1 = new StaticBody(this, singlePlatformShape);
        platform1.setPosition(new Vec2(10, -1f));
        platform1.addImage(new BodyImage("data/platform-single.png",4f));
        //platform1.setAlwaysOutline(true);




        character = new Character(this);
        character.setPosition(new Vec2(-10f, -8f));

        ninja = new Ninja(this);
        ninja.setPosition(new Vec2(0f,-8f));



    }

    public Character getCharacter() {
        return character;
    }
}
