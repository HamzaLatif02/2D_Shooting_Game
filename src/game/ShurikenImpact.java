package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class ShurikenImpact implements CollisionListener {

    private Shuriken shuriken;

    public ShurikenImpact(Shuriken s){
        this.shuriken = s;
    }

    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Character) {
            ((Character) e.getOtherBody()).setHealth(((Character) e.getOtherBody()).getHealth() - shuriken.getDamage());
            ((Character) e.getOtherBody()).isAlive();
        }
        e.getReportingBody().destroy();
    }

}
