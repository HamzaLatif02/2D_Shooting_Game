package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.DynamicBody;
import org.jbox2d.common.Vec2;

public class ProjectileImpact implements CollisionListener {

    private Projectile projectile;

    public ProjectileImpact(Projectile p){
        this.projectile = p;
    }

    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Ninja) {
            ((Ninja) e.getOtherBody()).setHealth(((Ninja) e.getOtherBody()).getHealth() - projectile.getDamage());
            ((Ninja) e.getOtherBody()).isAlive();
        }
        e.getReportingBody().destroy();
    }


}
