package game;

import city.cs.engine.Sensor;
import city.cs.engine.SensorEvent;
import city.cs.engine.SensorListener;
import city.cs.engine.World;

public class CoinPickup implements SensorListener {

    private Coin coin;
    public CoinPickup(Coin coin){
        this.coin = coin;
    }

    @Override
    public void beginContact(SensorEvent e) {
        if (e.getContactBody() instanceof Character){
            ((Character) e.getContactBody()).setPoints(((Character) e.getContactBody()).getPoints()+1);
            coin.destroy();
        }
    }

    @Override
    public void endContact(SensorEvent e) {

    }
}
