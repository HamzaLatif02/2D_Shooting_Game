package game;

import city.cs.engine.SensorEvent;
import city.cs.engine.SensorListener;
import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;

public class ExplosiveMineContact implements SensorListener, StepListener {

    private ExplosiveMine explosiveMine;
    private int time;
    private Boolean contactHappened;

    public ExplosiveMineContact(ExplosiveMine em){
        this.explosiveMine = em;
        this.contactHappened = Boolean.FALSE;
        explosiveMine.getWorld().addStepListener(this);
    }


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
