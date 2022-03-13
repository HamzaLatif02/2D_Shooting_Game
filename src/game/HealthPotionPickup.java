package game;

import city.cs.engine.SensorEvent;
import city.cs.engine.SensorListener;

public class HealthPotionPickup implements SensorListener {

    private HealthPotion healthPotion;

    public HealthPotionPickup(HealthPotion healthPotion){this.healthPotion = healthPotion;}

    @Override
    public void beginContact(SensorEvent e) {
        if (e.getContactBody() instanceof Character){
            if (((Character) e.getContactBody()).getHealth() < 76){
                ((Character) e.getContactBody()).setHealth(((Character) e.getContactBody()).getHealth() + 25);
            } else {
                ((Character) e.getContactBody()).setHealth(100);
            }
            healthPotion.destroy();
        }

    }

    @Override
    public void endContact(SensorEvent e) {

    }
}
