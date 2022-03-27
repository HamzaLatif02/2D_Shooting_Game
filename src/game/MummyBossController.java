package game;

import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;

public class MummyBossController implements StepListener {

    private MummyBoss mummyBoss;
    private int time;

    public MummyBossController(MummyBoss mummyBoss) {
        this.mummyBoss = mummyBoss;
        this.time = 0;
    }

    @Override
    public void preStep(StepEvent stepEvent) {
        if (mummyBoss.isAlive() == Boolean.TRUE){
            if (time % 240 < 120){
                mummyBoss.moveLeft();
            } else {
                mummyBoss.moveRight();
            }
        }
        time++;
    }

    @Override
    public void postStep(StepEvent stepEvent) {

    }
}
