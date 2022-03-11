package game;

import city.cs.engine.*;

public class WallPlatform extends StaticBody {

    private static final Shape wallShape = new BoxShape(1,50);
    private static final BodyImage image = new BodyImage("data/transparent-wall.png",1);

    public WallPlatform(World w){
        super(w, wallShape);
        addImage(image);
    }
}
