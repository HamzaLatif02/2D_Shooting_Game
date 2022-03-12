package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class NinjaBoss extends Walker {

    private static final Shape ninjaBossShape = new CircleShape(4.8f);
    private static final BodyImage image = new BodyImage("data/ninjaboss.png", 10f);
    private Shuriken[] shurikens = new Shuriken[3];
    //private ShurikenImpact[] shurikenImpacts = new ShurikenImpact[3];

    private int health;
    public NinjaBoss(World w){
        super(w, ninjaBossShape);
        addImage(image);
        this.health = 200;
        //setAlwaysOutline(true);
    }

    public int getHealth(){return health;}
    public void setHealth(int health){this.health = health;}

    public Boolean isAlive(){
        if (health <= 0){
            this.destroy();
            return Boolean.FALSE;
        } else return Boolean.TRUE;
    }

    public void shoot(){


        int offset = 3;

        for (int i=0; i<shurikens.length; i++){
            shurikens[i] = new Shuriken(this.getWorld());
            shurikens[i].setPosition(new Vec2(this.getPosition().x-6,this.getPosition().y+offset));
            shurikens[i].setLinearVelocity(new Vec2(-20f,0f));
            offset -= 3;
        }

        for (Shuriken shuriken : shurikens){
            ShurikenImpact shurikenImpact = new ShurikenImpact(shuriken);
            shuriken.addCollisionListener(shurikenImpact);
        }

    }
}
