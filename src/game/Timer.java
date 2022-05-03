package game;

import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;
import city.cs.engine.World;

public class Timer implements StepListener {

    int seconds, minutes, time;
    private Boolean running;

    public Timer(World w){
        this.seconds = 0;
        this.minutes = 0;
        this.time = 0;
        this.running = Boolean.FALSE;
        w.addStepListener(this);
    }

    public int getSeconds() {
        return seconds;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getTime() {
        return time;
    }

    public void start(){
        running = Boolean.TRUE;
    }

    public void stop(){
        running = Boolean.FALSE;
    }

    @Override
    public void preStep(StepEvent stepEvent) {

        //System.out.println("time: " + time + "\n" + "minutes: " + minutes + "\n" + "seconds: " + seconds + "\n");

        if (running){
            time++;
            if (time == 60){
                seconds++;
                time = 0;
            } else if (seconds == 60){
                minutes++;
                seconds = 0;
            }
        }
    }

    @Override
    public void postStep(StepEvent stepEvent) {

    }
}
