package game;

import city.cs.engine.SensorEvent;
import city.cs.engine.SensorListener;
import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;

//check collision between explosive mines and rest of the world
public class ExplosiveMineContact implements SensorListener, StepListener {

    private ExplosiveMine explosiveMine;
    private int time;
    private Boolean contactHappened;

    public ExplosiveMineContact(ExplosiveMine em){
        this.explosiveMine = em;
        this.contactHappened = Boolean.FALSE;
        explosiveMine.getWorld().addStepListener(this);
    }


    //explosive mines explode when character collides with them
    @Override
    public void beginContact(SensorEvent e) {
        if (e.getContactBody() instanceof Character){
            explosiveMine.removeAllImages();
            explosiveMine.addImage(explosiveMine.getExplosionImage());
            this.contactHappened = Boolean.TRUE;
            this.time =0;
            ((Character) e.getContactBody()).setHealth(((Character) e.getContactBody()).getHealth()- explosiveMine.getDamage());
            ((Character) e.getContactBody()).isAlive();
        }
    }

    @Override
    public void endContact(SensorEvent e) {

    }

    //destroy explosive mine one second after it collided with character.
    @Override
    public void preStep(StepEvent stepEvent) {
        if (this.time == 60 && this.contactHappened == Boolean.TRUE){
            explosiveMine.destroy();
        }
        time++;
    }

    @Override
    public void postStep(StepEvent stepEvent) {

    }
}
