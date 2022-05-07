package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

//shuriken collision with rest of world
public class ShurikenImpact implements CollisionListener {

    private Shuriken shuriken;

    public ShurikenImpact(Shuriken s){
        this.shuriken = s;
    }

    @Override
    public void collide(CollisionEvent e) {
        //if other body is character, then deal damage
        if (e.getOtherBody() instanceof Character) {
            ((Character) e.getOtherBody()).setHealth(((Character) e.getOtherBody()).getHealth() - shuriken.getDamage());
            ((Character) e.getOtherBody()).isAlive();
        }
        //destroy when in contact with anything
        e.getReportingBody().destroy();
    }

}
