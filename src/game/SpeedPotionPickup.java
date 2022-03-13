package game;

import city.cs.engine.SensorEvent;
import city.cs.engine.SensorListener;

public class SpeedPotionPickup implements SensorListener {

    private SpeedPotion speedPotion;

    public SpeedPotionPickup(SpeedPotion speedPotion){this.speedPotion = speedPotion;}

    @Override
    public void beginContact(SensorEvent e) {
        if (e.getContactBody() instanceof Character){
            ((Character) e.getContactBody()).setSpeed(7);
            speedPotion.destroy();
        }

    }

    @Override
    public void endContact(SensorEvent e) {

    }
}
