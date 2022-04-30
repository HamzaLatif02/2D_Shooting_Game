package game;

import city.cs.engine.*;
import city.cs.engine.Shape;

import java.awt.*;

public class GroundPlatform extends StaticBody {

    private static final Shape groundShape = new PolygonShape(-14.0f,7.5f, 14.0f,7.5f, 15.0f,6.5f, 15.0f,-6.5f, 14.0f,-7.5f, -14.0f,-7.5f, -15.0f,-6.5f, -15.0f,6.5f);
    private static final BodyImage image = new BodyImage("data/level1/platform-long.png",30f);
    private static final BodyImage image2 = new BodyImage("data/level2/sandstone-platform-long.png", 30f);
    private static final BodyImage image3 = new BodyImage("data/level3/stone-platform-long.gif", 30f);
    private static final BodyImage image4 = new BodyImage("data/level4/moon-platform-long.png", 30f);

    public GroundPlatform(World w){
        super(w,groundShape);

        if (w instanceof LevelOne){
            addImage(image);
         } else if (w instanceof LevelTwo){
            addImage(image2);
        } else if (w instanceof LevelThree){
            addImage(image3);
        } else if (w instanceof LevelFour){
            addImage(image4);
        }
        //setAlwaysOutline(true);
    }
}
