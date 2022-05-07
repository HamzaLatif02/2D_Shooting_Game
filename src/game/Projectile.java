package game;

import city.cs.engine.*;

//projectiles are shot by the character
public class Projectile extends DynamicBody implements StepListener {

    private static final Shape projectileShape = new PolygonShape(-0.48f,0.286f, 0.096f,0.5f, 0.48f,0.012f, 0.136f,-0.5f, -0.458f,-0.332f);
    private static final BodyImage image = new BodyImage("data/level1/projectile2.png",1f);
    private static final BodyImage image2 = new BodyImage("data/level2/projectile4.png",1f);
    private static final BodyImage image3 =  new BodyImage("data/level3/projectile5.png", 1f);

    private int damage;
    private int time;

    public Projectile(World w) {
        super(w, projectileShape);

        if (w instanceof LevelOne ){
            this.addImage(image);
            this.damage =5;
        } else if (w instanceof LevelTwo){
            this.addImage(image2);
            //projectiles are not affected by gravity
            this.setGravityScale(0);
            getWorld().addStepListener(this);
            this.time =0;
            this.damage =5;
        } else if (w instanceof LevelThree){
            this.addImage(image3);
            //projectiles are not affected by gravity
            this.setGravityScale(0);
            getWorld().addStepListener(this);
            this.time =0;
            this.damage =10;
        }
    }

    public int getDamage(){return damage;}

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @Override
    public void preStep(StepEvent stepEvent) {
        time++;
        //projectiles are destroyed after half second
        if (time % 30 == 0){
            this.destroy();
        }
    }

    @Override
    public void postStep(StepEvent stepEvent) {

    }
}
