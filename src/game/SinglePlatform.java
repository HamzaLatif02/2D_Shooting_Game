package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class SinglePlatform extends StaticBody implements StepListener {

    private static final Shape singleShape = new PolygonShape(-1.65f,2.00f, 1.65f,2.00f, 2.0f,1.65f, 2.0f,-1.65f, 1.65f,-2.00f, -1.65f,-2.00f, -2.00f,-1.65f, -2.00f,1.65f);
    private static final BodyImage image = new BodyImage("data/level1/platform-single.png",4f);
    private static final BodyImage image2 = new BodyImage("data/level2/sandstone-platform-single.png",4f);
    private static final BodyImage image3 = new BodyImage("data/level3/stone-platform-single.png", 4f);

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
        }
        //setAlwaysOutline(true);
    }

    public SinglePlatform(World w, String movement){
        super(w, singleShape);
        this.movement = movement;

        this.time1 = 0;
        this.time2 = 0;

        if (movement.equals("vertical")){
            if (w instanceof LevelThree){
                this.delay = (int)Math.floor(Math.random()*100);
                addImage(image3);
                getWorld().addStepListener(this);
            }
        }
    }

    public String getMovement() {
        return movement;
    }

    @Override
    public void preStep(StepEvent stepEvent) {

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
