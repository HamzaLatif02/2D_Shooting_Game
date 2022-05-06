package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import org.jbox2d.common.Vec2;

//Check bombs collision with rest of the world.
public class BombImpact implements CollisionListener {

    private Bomb bomb;


    public BombImpact(Bomb bomb){
        this.bomb = bomb;
    }

    //if the bomb collides with the character, it explodes and deal damage to the character
    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Character){
            bomb.removeAllImages();
            bomb.addImage(bomb.getExplosionImage());
            bomb.setExploded(Boolean.TRUE);
            bomb.setTime(bomb.getTimer());
            ((Character) e.getOtherBody()).setHealth(((Character) e.getOtherBody()).getHealth() - bomb.getDamage());
            ((Character) e.getOtherBody()).isAlive();
        }
    }
}
