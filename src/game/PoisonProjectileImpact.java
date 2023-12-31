package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;

public class PoisonProjectileImpact implements CollisionListener {

    private PoisonProjectile poisonProjectile;


    public PoisonProjectileImpact(PoisonProjectile pp){
        this.poisonProjectile = pp;
    }


    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Character) {

            //poison projectiles slow down the enemy in addition to dealing damage
            ((Character) e.getOtherBody()).setHealth(((Character) e.getOtherBody()).getHealth() - poisonProjectile.getDamage());
            if (((Character) e.getOtherBody()).getSpeed() > 5.1){
                ((Character) e.getOtherBody()).setSpeed(((Character) e.getOtherBody()).getSpeed()-0.2f);
            }
            ((Character) e.getOtherBody()).isAlive();
        }
        e.getReportingBody().destroy();

    }
}
