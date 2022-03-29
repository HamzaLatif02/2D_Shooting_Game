package game;

import city.cs.engine.*;


public class Coin extends StaticBody {

    private static final Shape coinShape = new CircleShape(1f);
    private static final Shape starShape = new PolygonShape(0.0f,1.43f, 1.49f,0.32f, 0.92f,-1.42f, -0.93f,-1.43f, -1.49f,0.34f);
    private GhostlyFixture ghostCoinShape;
    private Sensor coinSensor;
    private CoinPickup coinPickup;
    private static final BodyImage coinImage = new BodyImage("data/coin.png",2f);
    private static final BodyImage starImage = new BodyImage("data/level2/star2.png", 3f);

    private String value;

    public Coin(World w, String value){
        super(w);
        this.value = value;
        if (value.equals("single")){
            addImage(coinImage);
            ghostCoinShape = new GhostlyFixture(this, coinShape);
            coinSensor = new Sensor(this, coinShape);
            coinPickup = new CoinPickup(this, value);
        } else {
            addImage(starImage);
            ghostCoinShape = new GhostlyFixture(this, starShape);
            coinSensor = new Sensor(this, starShape);
            coinPickup = new CoinPickup(this, value);
        }

        coinSensor.addSensorListener(coinPickup);

        //setAlwaysOutline(true);
    }
}
