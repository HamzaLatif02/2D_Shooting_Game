package game;

import city.cs.engine.*;

public class HealthPotion extends StaticBody{

    private static final Shape healthPotionShape = new CircleShape(1f);
    private GhostlyFixture ghostHealthPotionShape;
    private Sensor healthPotionSensor;
    private HealthPotionPickup healthPotionPickup;
    private static final BodyImage healthPotionImage = new BodyImage("data/healthpotion.png",2f);

    public HealthPotion(World w){
        super(w);
        addImage(healthPotionImage);
        ghostHealthPotionShape = new GhostlyFixture(this, healthPotionShape);
        healthPotionSensor = new Sensor(this, healthPotionShape);
        healthPotionPickup = new HealthPotionPickup(this);
        healthPotionSensor.addSensorListener(healthPotionPickup);

        //setAlwaysOutline(true);
    }
}
