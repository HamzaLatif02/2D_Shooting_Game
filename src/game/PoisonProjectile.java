package game;

import city.cs.engine.*;

//projectiles shot by mummies in level two
public class PoisonProjectile extends DynamicBody implements StepListener{

    private static final Shape poisonProjectileShape = new PolygonShape(0.014f,0.496f, -0.478f,0.146f, -0.468f,-0.498f, 0.508f,-0.502f, 0.282f,0.5f);
    private static final BodyImage image = new BodyImage("data/level2/poison-projectile.png",1f);

    private int damage;
    private int time;


    public PoisonProjectile(World w){
        super(w, poisonProjectileShape);
        addImage(image);
        this.damage = 5;
        this.time = 0;
        this.setGravityScale(0);
        getWorld().addStepListener(this);
    }

    public int getDamage() {
        return damage;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @Override
    public void preStep(StepEvent stepEvent) {
        this.time++;

        //projectiles die after 1 second
        if (this.time % 60 == 0){
            this.destroy();
        }
    }

    @Override
    public void postStep(StepEvent stepEvent) {

    }
}
