package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class DoublePlatform extends StaticBody implements StepListener{

    private static final Shape doubleShape = new PolygonShape(-3.65f,2.0f, 3.75f,2.00f, 4.0f,1.70f, 4.0f,-1.70f, 3.75f,-2.0f, -3.65f,-2.0f, -4.0f,-1.70f, -4.0f,1.70f);
    private static final BodyImage image = new BodyImage("data/level1/platform-double.png",8f);
    private static final BodyImage image2 = new BodyImage("data/level2/sandstone-platform-double.png", 8f);
    private static final BodyImage image3 = new BodyImage("data/level3/stone-platform-double.gif", 8f);
    private static final BodyImage image4 = new BodyImage("data/level4/moon-platform-double.png", 8f);

    private int time;
    private String direction;


    public DoublePlatform(World w){
        super(w,doubleShape);

        this.time = 0;

        if (w instanceof LevelOne){
            addImage(image);
        } else if (w instanceof LevelTwo){
            addImage(image2);
        } else if (w instanceof LevelThree){
            addImage(image3);
        } else if (w instanceof LevelFour){
            addImage(image4);
        }

        //setAlwaysOutline(true);

    }

    public DoublePlatform(World w, String direction){
        super(w, doubleShape);
        this.time=0;
        this.direction = direction;

        if (w instanceof LevelTwo){
            addImage(image2);
        } else if (w instanceof LevelThree){
            addImage(image3);
        }

        getWorld().addStepListener(this);
    }

    public String getDirection() {
        return direction;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @Override
    public void preStep(StepEvent stepEvent) {
        if (direction.equals("horizontal")){
            if (time % 240 < 120){
                this.setPosition(new Vec2(getPosition().x-0.1f,getPosition().y));
            } else {
                this.setPosition(new Vec2(getPosition().x+0.1f,getPosition().y));
            }
        } else {
            if (time % 480 < 240){
                this.setPosition(new Vec2(getPosition().x,getPosition().y-0.1f));
            } else {
                this.setPosition(new Vec2(getPosition().x,getPosition().y+0.1f));
            }
        }

        time++;
    }

    @Override
    public void postStep(StepEvent stepEvent) {

    }
}
