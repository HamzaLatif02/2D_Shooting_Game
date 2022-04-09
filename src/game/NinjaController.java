package game;

import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;
import org.jbox2d.common.Vec2;

public class NinjaController implements StepListener {

    private Ninja ninja;
    private int time;

    public NinjaController(Ninja ninja){
        this.ninja = ninja;
        this.time = 0;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @Override
    public void preStep(StepEvent e) {

        if (ninja.isAlive() == Boolean.TRUE) {
            if (time % 240 < 120){
                ninja.moveRight();
            } else {
                ninja.moveLeft();
            }

            if (time % 30 == 0){
                ninja.shoot();
            }

            time++;
        }

    }

    @Override
    public void postStep(StepEvent e) {
    }
}
