package game;

import city.cs.engine.*;

//coin is a special type of walker so when it is hit by a projectile it does not move
public class MinusCoin extends Walker {

    private static final Shape coinShape = new CircleShape(1f);
    private static final BodyImage coinImage = new BodyImage("data/minuspointscoin.png",2f);

    public MinusCoin(World w){
        super(w,coinShape);
        addImage(coinImage);
        //setAlwaysOutline(true);
    }
}
