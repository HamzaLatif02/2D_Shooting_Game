package game;

import city.cs.engine.Sensor;
import city.cs.engine.SensorEvent;
import city.cs.engine.SensorListener;
import city.cs.engine.World;

public class CoinPickup implements SensorListener {

    private Coin coin;
    private String value;
    public CoinPickup(Coin coin, String value){
        this.coin = coin;
        this.value = value;
    }

    @Override
    public void beginContact(SensorEvent e) {
        if (e.getContactBody() instanceof Character){
            if (value.equals("single")){
                ((Character) e.getContactBody()).setPoints(((Character) e.getContactBody()).getPoints()+1);
            } else {
                ((Character) e.getContactBody()).setPoints(((Character) e.getContactBody()).getPoints()+2);
            }
            coin.destroy();
        }
    }

    @Override
    public void endContact(SensorEvent e) {

    }
}
