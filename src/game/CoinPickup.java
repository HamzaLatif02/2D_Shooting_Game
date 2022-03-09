package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class CoinPickup implements CollisionListener {

    private Character character;

    public CoinPickup(Character c){
        this.character = c;
    }

    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Coin){
            character.setPoints(character.getPoints()+1);
            e.getOtherBody().destroy();
        } else if (e.getOtherBody() instanceof MinusCoin){
            if (character.getPoints() > 0){
                character.setPoints(character.getPoints()-1);
            }
            e.getOtherBody().destroy();
        }
    }
}
