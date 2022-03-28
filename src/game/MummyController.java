package game;

import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;

public class MummyController implements StepListener {

    private Mummy mummy;
    private int time;

    public MummyController(Mummy m){
        this.mummy = m;
        this.time = 0;
    }
    @Override
    public void preStep(StepEvent stepEvent) {

        if (mummy.isAlive() == Boolean.TRUE){
            if(mummy.getDoesMove().equals("yes")){
                if (time % 480 < 240){
                    mummy.moveLeft();
                } else {
                    mummy.moveRight();
                }
            }

            if (time % 60 == 0){
                mummy.shoot();
            }
            time++;
        }



    }

    @Override
    public void postStep(StepEvent stepEvent) {

    }
}
