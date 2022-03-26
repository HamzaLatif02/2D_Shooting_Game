package game;

import org.jbox2d.common.Vec2;

import java.awt.*;

public class LevelTwo extends GameLevel{


    public LevelTwo(){
        super();

        placePlatforms();

    }

    public void placePlatforms(){

        new WallPlatform(this).setPosition(new Vec2(-16f,0f));

        new GroundPlatform(this).setPosition(new Vec2(0f,-17.5f));
    }


    @Override
    public Boolean isCompleted() {
        return Boolean.FALSE;
    }

}
