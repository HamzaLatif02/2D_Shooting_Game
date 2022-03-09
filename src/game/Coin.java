package game;

import city.cs.engine.*;

public class Coin extends DynamicBody {

    private static final Shape coinShape = new CircleShape(1f);
    private static final BodyImage coinImage = new BodyImage("data/coin.png",2f);

    public Coin(World w){
        super(w,coinShape);
        addImage(coinImage);
        //setAlwaysOutline(true);
    }
}
