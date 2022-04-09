package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class MummyBoss extends Walker implements StepListener {

    private static final Shape mummyBossShape = new CircleShape(4.8f);
    private static final BodyImage imageLeft = new BodyImage("data/level2/mummyboss-left.png", 10f);
    private static final BodyImage imageRight = new BodyImage("data/level2/mummyboss-right.png", 10f);
    private String direction;
    private int speed;
    private int health;
    private int time;
    private PoisonProjectile[] poisonProjectiles = new PoisonProjectile[3];

    public MummyBoss(World world) {
        super(world, mummyBossShape);
        addImage(imageLeft);
        this.direction = "left";
        this.speed = 6;
        this.health = 400;
        this.time = 0;
        getWorld().addStepListener(new MummyBossController(this));
    }

    public int getHealth() {
        return health;
    }
    public void setHealth(int health) {
        this.health = health;
    }

    public void setDirection(String direction) {
        this.direction = direction;
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

    public void shoot(){

        int offset = 3;

        for (int i=0; i<poisonProjectiles.length; i++){
            poisonProjectiles[i] = new PoisonProjectile(this.getWorld());

            if (direction.equals("left")){
                poisonProjectiles[i].setPosition(new Vec2(this.getPosition().x-6,this.getPosition().y+offset));
                poisonProjectiles[i].setLinearVelocity(new Vec2(-20,0));
            } else {
                poisonProjectiles[i].setPosition(new Vec2(this.getPosition().x+6, this.getPosition().y+offset));
                poisonProjectiles[i].setLinearVelocity(new Vec2(20, 0));
            }

            offset -=3;

            PoisonProjectileImpact poisonProjectileImpact = new PoisonProjectileImpact(poisonProjectiles[i]);
            poisonProjectiles[i].addCollisionListener(poisonProjectileImpact);
        }

    }

    @Override
    public void preStep(StepEvent stepEvent) {
        if (this.isAlive() == Boolean.TRUE){
            if (time % 240 < 120){
                this.moveLeft();
            } else {
                this.moveRight();
            }

            if (time % 120 < 30 && time % 2 == 0){
                this.shoot();
            }
        }
        time++;
    }

    @Override
    public void postStep(StepEvent stepEvent) {

    }
}
