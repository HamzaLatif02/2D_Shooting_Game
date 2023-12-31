package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.DynamicBody;
import org.jbox2d.common.Vec2;

//projectile collision with rest of world
public class ProjectileImpact implements CollisionListener {

    private Projectile projectile;

    public ProjectileImpact(Projectile p){
        this.projectile = p;
    }

    @Override
    public void collide(CollisionEvent e) {

        //check if other object is an enemy, if it is deal damage
        if (e.getOtherBody() instanceof Ninja) {
            ((Ninja) e.getOtherBody()).setHealth(((Ninja) e.getOtherBody()).getHealth() - projectile.getDamage());
            ((Ninja) e.getOtherBody()).isAlive();
        } else if (e.getOtherBody() instanceof NinjaBoss){
            ((NinjaBoss) e.getOtherBody()).setHealth(((NinjaBoss) e.getOtherBody()).getHealth() - projectile.getDamage());
            ((NinjaBoss) e.getOtherBody()).isAlive();
        } else if (e.getOtherBody() instanceof Mummy){
            ((Mummy) e.getOtherBody()).setHealth(((Mummy) e.getOtherBody()).getHealth() - projectile.getDamage());
            ((Mummy) e.getOtherBody()).isAlive();
        } else if (e.getOtherBody() instanceof MummyBoss){
            ((MummyBoss) e.getOtherBody()).setHealth(((MummyBoss) e.getOtherBody()).getHealth() - projectile.getDamage());
            ((MummyBoss) e.getOtherBody()).isAlive();
        } else if (e.getOtherBody() instanceof BombThrower){
            ((BombThrower) e.getOtherBody()).setHealth(((BombThrower) e.getOtherBody()).getHealth() - projectile.getDamage());
        }
        //destroy projectile when it collides with anything
        e.getReportingBody().destroy();
    }


}
