package game;

import city.cs.engine.*;

public class SpeedPotion extends StaticBody {

    private static final Shape speedPotionShape = new CircleShape(1f);
    private GhostlyFixture ghostSpeedPotionShape;
    private Sensor speedPotionSensor;
    private SpeedPotionPickup speedPotionPickup;
    private static final BodyImage speedPotionImage = new BodyImage("data/speedpotion.png",2f);
    private static final BodyImage slowDownPotionImage = new BodyImage("data/slowdownpotion.png",2f);

    private String type;

    public SpeedPotion(World w, String type){
        super(w);
        this.type = type;
        if (type.equals("positive")){
            addImage(speedPotionImage);
        } else {
            addImage(slowDownPotionImage);
        }

        ghostSpeedPotionShape = new GhostlyFixture(this, speedPotionShape);
        speedPotionSensor = new Sensor(this, speedPotionShape);
        speedPotionPickup = new SpeedPotionPickup(this, type);
        speedPotionSensor.addSensorListener(speedPotionPickup);

        //setAlwaysOutline(true);
    }

    public String getType() {
        return type;
    }
}

