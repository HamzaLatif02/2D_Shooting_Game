package game;

import city.cs.engine.SensorEvent;
import city.cs.engine.SensorListener;

public class MinusCoinPickup implements SensorListener {

    private MinusCoin minusCoin;
    public MinusCoinPickup(MinusCoin minusCoin){
        this.minusCoin = minusCoin;
    }

    @Override
    public void beginContact(SensorEvent e) {
        if (e.getContactBody() instanceof Character){
            ((Character) e.getContactBody()).setPoints(((Character) e.getContactBody()).getPoints()-1);
            minusCoin.destroy();
        }
    }

    @Override
    public void endContact(SensorEvent e) {

    }
}
