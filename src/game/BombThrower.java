package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class BombThrower extends Walker implements StepListener {

    private static final Shape bombThrowerShape = new CircleShape(2);
    private static final BodyImage imageLeft = new BodyImage("data/level3/bombthrower-left.png", 4f);

    private int health;
    private int time;
    private Bomb bomb;
    private GameLevel level;

    public BombThrower(World w) {
        super(w, bombThrowerShape);
        level = (GameLevel)w;
        addImage(imageLeft);
        this.health = 100;
        getWorld().addStepListener(this);
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public boolean isAlive(){
        if (health <= 0 || this.getPosition().y < -25){
            this.destroy();
            return Boolean.FALSE;
        } else return Boolean.TRUE;
    }

    public void shoot(){
        bomb = new Bomb(this.getWorld());
        bomb.setPosition(new Vec2(this.getPosition().x-3, this.getPosition().y));
        bomb.setLinearVelocity(new Vec2(-10f, 5f));
        bomb.setAngularVelocity(0);
        BombImpact bombImpact = new BombImpact(bomb);
        bomb.addCollisionListener(bombImpact);
    }

    @Override
    public void preStep(StepEvent stepEvent) {
        if (isAlive() == Boolean.TRUE){
            if (this.getPosition().x - level.getCharacter().getPosition().x < 20){
                System.out.println("yes");
                if (time % 120 == 0){
                    shoot();
                }
            }
        time++;
        }
    }

    @Override
    public void postStep(StepEvent stepEvent) {

    }
}