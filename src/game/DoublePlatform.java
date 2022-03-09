package game;

import city.cs.engine.*;

public class DoublePlatform extends StaticBody {

    private static final Shape doubleShape = new PolygonShape(-3.65f,2.0f, 3.74f,1.98f, 4.0f,1.66f, 4.0f,-1.71f, 3.7f,-2.0f, -3.66f,-2.0f, -4.0f,-1.68f, -4.0f,1.71f);
    private static final BodyImage image = new BodyImage("data/platform-double.png",8f);

    DoublePlatform(World w){
        super(w,doubleShape);
        addImage(image);
        setAlwaysOutline(true);

    }
}
