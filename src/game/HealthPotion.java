package game;

import city.cs.engine.*;

public class HealthPotion extends StaticBody{

    private static final Shape healthPotionShape = new CircleShape(1f);
    private GhostlyFixture ghostHealthPotionShape;
    private Sensor healthPotionSensor;
    private HealthPotionPickup healthPotionPickup;
    private static final BodyImage healthPotionImage = new BodyImage("data/healthpotion.png",2f);
    private static final BodyImage minusHealthPotionImage = new BodyImage("data/minushealthpotion.png", 2f);

    private String type;

    public HealthPotion(World w, String type){
        super(w);
        this.type = type;
        if (type.equals("positive")){
            addImage(healthPotionImage);
        } else {
            addImage(minusHealthPotionImage);
        }
        ghostHealthPotionShape = new GhostlyFixture(this, healthPotionShape);
        healthPotionSensor = new Sensor(this, healthPotionShape);
        healthPotionPickup = new HealthPotionPickup(this, type);
        healthPotionSensor.addSensorListener(healthPotionPickup);

        //setAlwaysOutline(true);
    }

    public String getType() {
        return type;
    }
}
