package game;

import city.cs.engine.*;

public class MummyBoss extends Walker {

    private static final Shape mummyBossShape = new CircleShape(4.8f);
    private static final BodyImage imageLeft = new BodyImage("data/level2/mummyboss-left.png", 10f);
    private static final BodyImage imageRight = new BodyImage("data/level2/mummyboss-right.png", 10f);
    private String direction;
    private int speed;
    private int health;

    public MummyBoss(World world) {
        super(world, mummyBossShape);
        addImage(imageLeft);
        this.direction = "left";
        this.speed = 6;
        this.health = 400;
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

    public Boolean isAlive(){
        if (health <= 0){
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
}
