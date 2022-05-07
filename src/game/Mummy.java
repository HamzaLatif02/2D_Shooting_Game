package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

//enemy in second level
public class Mummy extends Walker {

    private static final Shape mummyShape = new CircleShape(2);
    private static final BodyImage imageLeft = new BodyImage("data/level2/mummy-left.png", 4f);
    private static final BodyImage imageRight = new BodyImage("data/level2/mummy-right.png", 4f);

    private int health;
    private String direction;
    private int speed;
    private String doesMove;
    private int time;


    public Mummy (World world, String Movement){
        super(world, mummyShape);
        addImage(imageLeft);
        this.health = 50;
        this.direction = "left";
        this.speed = 2;
        this.time = 0;
        this.doesMove = Movement;
        getWorld().addStepListener(new MummyController(this));
    }

    public String getDoesMove() {
        return doesMove;
    }

    public int getHealth() {
        return health;
    }
    public void setHealth(int health) {
        this.health = health;
    }

    public String getDirection() {
        return direction;
    }
    public void setDirection(String direction) {
        this.direction = direction;
    }

    public int getSpeed() {
        return speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }

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

    //shoot left or right depending on direction
    public void shoot(){
        PoisonProjectile pp = new PoisonProjectile(this.getWorld());

        if (direction.equals("left")){
            pp.setPosition(new Vec2(this.getPosition().x-3,this.getPosition().y));
            pp.setLinearVelocity(new Vec2(-20,0));
        } else {
            pp.setPosition(new Vec2(this.getPosition().x+3, this.getPosition().y));
            pp.setLinearVelocity(new Vec2(20, 0));
        }

        PoisonProjectileImpact poisonProjectileImpact = new PoisonProjectileImpact(pp);
        pp.addCollisionListener(poisonProjectileImpact);

    }
}
