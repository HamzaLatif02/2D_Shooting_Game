package game;

import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;
import city.cs.engine.World;

//timer used in level four
public class Timer implements StepListener {

    private int seconds, minutes, time;
    private Boolean running;
    private GameLevel level;

    public Timer(World w){
        this.level = (GameLevel) w;
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

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public void start(){
        running = Boolean.TRUE;
    }

    public void stop(){
        running = Boolean.FALSE;
    }

    @Override
    public void preStep(StepEvent stepEvent) {

        //timer runs only when character is inside the gravity changing portal
        if (running || level.getCharacter().getChangeGravity()){
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
