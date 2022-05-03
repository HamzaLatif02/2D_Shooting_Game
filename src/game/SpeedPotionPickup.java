package game;

import city.cs.engine.SensorEvent;
import city.cs.engine.SensorListener;

public class SpeedPotionPickup implements SensorListener {

    private SpeedPotion speedPotion;
    private String type;

    public SpeedPotionPickup(SpeedPotion speedPotion, String type){this.speedPotion = speedPotion; this.type = type;}

    @Override
    public void beginContact(SensorEvent e) {
        if (e.getContactBody() instanceof Character){
            if (type.equals("positive")){
                if (e.getContactBody().getWorld() instanceof LevelOne){
                    ((Character) e.getContactBody()).setSpeed(7);
                } else if (e.getContactBody().getWorld() instanceof LevelTwo){
                    ((Character) e.getContactBody()).setSpeed(6);
                } else if (e.getContactBody().getWorld() instanceof LevelFour){
                    ((Character) e.getContactBody()).setSpeed(((Character) e.getContactBody()).getSpeed() + 1f);
                }
            } else {
                ((Character) e.getContactBody()).setSpeed(5);
            }

            speedPotion.destroy();
        }

    }

    @Override
    public void endContact(SensorEvent e) {

    }
}
