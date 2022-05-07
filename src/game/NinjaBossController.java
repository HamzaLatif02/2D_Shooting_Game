package game;

import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;

public class NinjaBossController implements StepListener {

    private NinjaBoss ninjaBoss;
    private int time;

    public NinjaBossController(NinjaBoss ninjaBoss){
        this.ninjaBoss = ninjaBoss;
        this.time = 0;

    }

    @Override
    public void preStep(StepEvent stepEvent) {
        if (ninjaBoss.isAlive() == Boolean.TRUE){

            if (time % 240 < 120){
                ninjaBoss.moveLeft();
            } else {
                ninjaBoss.moveRight();
            }

            //shoot every second
            if (time % 60 == 0){
                ninjaBoss.shoot();
            }
            time++;
        }
    }

    @Override
    public void postStep(StepEvent stepEvent) {

    }
}
