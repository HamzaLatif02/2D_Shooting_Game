package game;

import city.cs.engine.*;

public class SinglePlatform extends StaticBody {

    private static final Shape singleShape = new PolygonShape(-1.66f,2.03f, 1.67f,2.02f, 2.0f,1.67f, 2.0f,-1.67f, 1.67f,-1.99f, -1.66f,-2.0f, -2.02f,-1.64f, -2.01f,1.64f);
    private static final BodyImage image = new BodyImage("data/platform-single.png",4f);

    SinglePlatform(World w){
        super(w,singleShape);
        addImage(image);
        //setAlwaysOutline(true);
    }
}
