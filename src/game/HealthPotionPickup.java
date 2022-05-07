package game;

import city.cs.engine.SensorEvent;
import city.cs.engine.SensorListener;

//health potion collision with rest of world
public class HealthPotionPickup implements SensorListener {

    private HealthPotion healthPotion;
    private String type;

    public HealthPotionPickup(HealthPotion healthPotion, String type){this.healthPotion = healthPotion; this.type = type;}

    @Override
    public void beginContact(SensorEvent e) {
        if (e.getContactBody() instanceof Character){
            if (type.equals("positive")){
                //depending on the level, health potion has different values
                if (e.getContactBody().getWorld() instanceof LevelOne){
                    if (((Character) e.getContactBody()).getHealth() < 76){
                        ((Character) e.getContactBody()).setHealth(((Character) e.getContactBody()).getHealth() + 25);
                    } else {
                        ((Character) e.getContactBody()).setHealth(100);
                    }
                } else if (e.getContactBody().getWorld() instanceof LevelTwo || e.getContactBody().getWorld() instanceof LevelThree ){
                    if (((Character) e.getContactBody()).getHealth() < 51){
                        ((Character) e.getContactBody()).setHealth(((Character) e.getContactBody()).getHealth() + 50);
                    } else {
                        ((Character) e.getContactBody()).setHealth(100);
                    }
                } else if (e.getContactBody().getWorld() instanceof LevelFour){
                    if (((Character) e.getContactBody()).getHealth() < 91){
                        ((Character) e.getContactBody()).setHealth(((Character) e.getContactBody()).getHealth() + 10);
                    } else {
                        ((Character) e.getContactBody()).setHealth(100);
                    }
                }
            } else {
                ((Character) e.getContactBody()).setHealth(((Character) e.getContactBody()).getHealth() - 10);
                ((Character) e.getContactBody()).isAlive();
            }
            healthPotion.destroy();
        }

    }

    @Override
    public void endContact(SensorEvent e) {

    }
}
