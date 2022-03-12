package game;

import city.cs.engine.*;


public class MinusCoin extends StaticBody {

    private static final Shape coinShape = new CircleShape(1f);
    private GhostlyFixture ghostCoinShape;
    private Sensor minusCoinSensor;
    private MinusCoinPickup minusCoinPickup;
    private static final BodyImage coinImage = new BodyImage("data/minuspointscoin.png",2f);

    public MinusCoin(World w){
        super(w);
        addImage(coinImage);
        ghostCoinShape = new GhostlyFixture(this,coinShape);
        minusCoinSensor = new Sensor(this,coinShape);
        minusCoinPickup = new MinusCoinPickup(this);
        minusCoinSensor.addSensorListener(minusCoinPickup);

        //setAlwaysOutline(true);
    }
}
