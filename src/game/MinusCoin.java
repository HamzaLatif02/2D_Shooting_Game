package game;

import city.cs.engine.*;

public class MinusCoin extends DynamicBody {

    private static final Shape coinShape = new CircleShape(1f);
    private static final BodyImage coinImage = new BodyImage("data/minuspointscoin.png",2f);

    public MinusCoin(World w){
        super(w,coinShape);
        addImage(coinImage);
        //setAlwaysOutline(true);
    }
}
