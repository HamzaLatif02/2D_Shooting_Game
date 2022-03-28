package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class PoisonProjectileImpact implements CollisionListener {

    private PoisonProjectile poisonProjectile;


    public PoisonProjectileImpact(PoisonProjectile pp){this.poisonProjectile = pp;}


    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Character) {
            ((Character) e.getOtherBody()).setHealth(((Character) e.getOtherBody()).getHealth() - poisonProjectile.getDamage());
            ((Character) e.getOtherBody()).isAlive();
        }
        e.getReportingBody().destroy();

    }
}
