package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

//Bombs are thrown by Bombthrowers.
public class Bomb extends DynamicBody implements StepListener{

    private static final Shape bombShape = new CircleShape(0.5f);
    private static final BodyImage image = new BodyImage("data/level3/grenade.png", 1f);
    private static  BodyImage explosionImage = new BodyImage("data/level3/explosion.png", 8f);

    private SolidFixture bombFixture;

    private int time;
    //timer field describes after how long the bomb explodes
    private int timer;
    private int damage;
    private Boolean exploded;

    public Bomb(World w) {
        super(w);
        bombFixture = new SolidFixture(this, bombShape);
        bombFixture.setRestitution(1f);
        this.addImage(image);
        this.time = 0;
        this.timer = 180;
        this.damage = 5;
        this.exploded = Boolean.FALSE;
        getWorld().addStepListener(this);
    }

    public void setExploded(Boolean exploded) {
        this.exploded = exploded;
    }

    public int getDamage() {
        return damage;
    }

    public BodyImage getExplosionImage() {
        return explosionImage;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getTimer() {
        return timer;
    }

    //after time field reaches timer field value, the bomb explodes
    //in this case after three seconds the bomb explodes
    @Override
    public void preStep(StepEvent stepEvent) {
        if (time > timer && time < timer+15){
            this.removeAllImages();
            this.addImage(explosionImage);
            setExploded(Boolean.TRUE);
        } else if (time == timer+15){
            this.destroy();
        }
        time++;
    }

    @Override
    public void postStep(StepEvent stepEvent) {

    }
}
