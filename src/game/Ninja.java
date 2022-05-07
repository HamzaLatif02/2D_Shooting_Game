package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

//enemy in first level
public class Ninja extends Walker {

    private static final Shape ninjaShape = new CircleShape(2);
    private static final BodyImage imageLeft = new BodyImage("data/level1/ninja-left.png", 4f);
    private static final BodyImage imageRight = new BodyImage("data/level1/ninja-right.png", 4f);

    private int health;
    private String direction;
    private int speed;
    private int time;

    public Ninja(World world) {
        super(world, ninjaShape);
        addImage(imageLeft);
        this.health = 20;
        this.speed = 3;
        this.time = 0;
        this.direction = "left";
        getWorld().addStepListener(new NinjaController(this));
    }

    public void setHealth(int health){this.health = health;}
    public int getHealth(){return health;}

    public void setDirection(String direction){this.direction = direction;}
    public String getDirection(){return direction;}

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public Boolean isAlive(){
        if (health <= 0 || this.getPosition().y < -25){
            this.destroy();
            return Boolean.FALSE;
        } else return Boolean.TRUE;
    }

    public void shoot(){
        Shuriken s = new Shuriken(this.getWorld());

        if (this.direction.equals("left")){
            s.setPosition(new Vec2(this.getPosition().x-3,this.getPosition().y));
            s.setLinearVelocity(new Vec2(-20,0));
        } else {
            s.setPosition(new Vec2(this.getPosition().x+3, this.getPosition().y));
            s.setLinearVelocity(new Vec2(20, 0));
        }

        ShurikenImpact shurikenImpact = new ShurikenImpact(s);
        s.addCollisionListener(shurikenImpact);
    }

    public void moveLeft(){
        this.startWalking(-speed);
        this.setDirection("left");
        this.removeAllImages();
        this.addImage(imageLeft);
    }

    public void moveRight(){
        this.startWalking(speed);
        this.setDirection("right");
        this.removeAllImages();
        this.addImage(imageRight);
    }
}
