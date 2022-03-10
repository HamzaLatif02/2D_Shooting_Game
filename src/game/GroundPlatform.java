package game;

import city.cs.engine.*;
import city.cs.engine.Shape;

import java.awt.*;

public class GroundPlatform extends StaticBody {

    private static final Shape groundShape = new PolygonShape(-14.0f,7.5f, 14.0f,7.5f, 15.0f,6.5f, 15.0f,-6.5f, 14.0f,-7.5f, -14.0f,-7.5f, -15.0f,-6.5f, -15.0f,6.5f);
    private static final BodyImage image = new BodyImage("data/platform-long.png",30f);

    public GroundPlatform(World w){
        super(w,groundShape);
        addImage(image);
        //setAlwaysOutline(true);
    }
}
