package game;

import city.cs.engine.*;

public class DoublePlatform extends StaticBody {

    private static final Shape doubleShape = new PolygonShape(-3.65f,2.0f, 3.75f,2.00f, 4.0f,1.70f, 4.0f,-1.70f, 3.75f,-2.0f, -3.65f,-2.0f, -4.0f,-1.70f, -4.0f,1.70f);
    private static final BodyImage image = new BodyImage("data/level1/platform-double.png",8f);
    private static final BodyImage image2 = new BodyImage("data/level2/sandstone-platform-double.png", 8f);

    DoublePlatform(World w){
        super(w,doubleShape);

        if (w instanceof LevelOne){
            addImage(image);
        } else if (w instanceof LevelTwo){
            addImage(image2);
        }

        //setAlwaysOutline(true);

    }
}
