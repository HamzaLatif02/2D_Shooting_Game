package game;

import city.cs.engine.*;


public class Coin extends StaticBody {

    private static final Shape coinShape = new CircleShape(1f);
    private GhostlyFixture ghostCoinShape;
    private Sensor coinSensor;
    private CoinPickup coinPickup;
    private static final BodyImage coinImage = new BodyImage("data/coin.png",2f);

    public Coin(World w){
        super(w);
        addImage(coinImage);
        ghostCoinShape = new GhostlyFixture(this, coinShape);
        coinSensor = new Sensor(this, coinShape);
        coinPickup = new CoinPickup(this);
        coinSensor.addSensorListener(coinPickup);

        //setAlwaysOutline(true);
    }
}
