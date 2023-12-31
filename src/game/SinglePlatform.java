package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class SinglePlatform extends StaticBody implements StepListener {

    private static final Shape singleShape = new PolygonShape(-1.65f,2.00f, 1.65f,2.00f, 2.0f,1.65f, 2.0f,-1.65f, 1.65f,-2.00f, -1.65f,-2.00f, -2.00f,-1.65f, -2.00f,1.65f);
    private static final BodyImage image = new BodyImage("data/level1/platform-single.png",4f);
    private static final BodyImage image2 = new BodyImage("data/level2/sandstone-platform-single.png",4f);
    private static final BodyImage image3 = new BodyImage("data/level3/stone-platform-single.gif", 4f);
    private static final BodyImage image4 = new BodyImage("data/level4/moon-platform-single.png", 4f);

    private int time1, time2 ,delay;
    private String movement;
    public SinglePlatform(World w){
        super(w,singleShape);

        if (w instanceof LevelOne){
            addImage(image);
        } else if (w instanceof LevelTwo){
            addImage(image2);
        } else if (w instanceof LevelThree){
            addImage(image3);
        } else if (w instanceof LevelFour){
            addImage(image4);
        }
    }

    public SinglePlatform(World w, String movement){
        super(w, singleShape);
        this.movement = movement;

        this.time1 = 0;
        this.time2 = 0;

        if (movement.equals("vertical")){
            if (w instanceof LevelThree){
                //each platform starts moving after a random amount of time
                this.delay = (int)Math.floor(Math.random()*100);
                addImage(image3);
                getWorld().addStepListener(this);
            } else if (w instanceof LevelFour){
                //each platform starts moving after a random amount of time
                this.delay = (int)Math.floor(Math.random()*100);
                addImage(image4);
                getWorld().addStepListener(this);
            }
        }
    }

    public String getMovement() {
        return movement;
    }

    public int getTime1() {
        return time1;
    }

    public int getTime2() {
        return time2;
    }

    public void setTime1(int time1) {
        this.time1 = time1;
    }

    public void setTime2(int time2) {
        this.time2 = time2;
    }

    @Override
    public void preStep(StepEvent stepEvent) {

        //only move after the delay
        if (time1 > delay){
            if (time2 % 240 < 120){
                this.setPosition(new Vec2(getPosition().x, getPosition().y-0.1f));
            } else {
                this.setPosition(new Vec2(getPosition().x, getPosition().y+0.1f));
            }
            time2++;
        }
        time1++;
    }

    @Override
    public void postStep(StepEvent stepEvent) {

    }
}
