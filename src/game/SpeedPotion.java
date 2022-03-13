package game;

import city.cs.engine.*;

public class SpeedPotion extends StaticBody {

    private static final Shape speedPotionShape = new CircleShape(1f);
    private GhostlyFixture ghostSpeedPotionShape;
    private Sensor speedPotionSensor;
    private SpeedPotionPickup speedPotionPickup;
    private static final BodyImage speedPotionImage = new BodyImage("data/speedpotion.png",2f);

    public SpeedPotion(World w){
        super(w);
        addImage(speedPotionImage);
        ghostSpeedPotionShape = new GhostlyFixture(this, speedPotionShape);
        speedPotionSensor = new Sensor(this, speedPotionShape);
        speedPotionPickup = new SpeedPotionPickup(this);
        speedPotionSensor.addSensorListener(speedPotionPickup);

        //setAlwaysOutline(true);
    }
}

