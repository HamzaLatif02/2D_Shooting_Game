package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class NinjaBoss extends Walker {

    private static final Shape ninjaBossShape = new CircleShape(4.8f);
    private static final BodyImage imageLeft = new BodyImage("data/level1/ninjaboss-left.png", 10f);
    private static final BodyImage imageRight = new BodyImage("data/level1/ninjaboss-right.png", 10f);
    private String direction;
    private int speed;
    private Shuriken[] shurikens = new Shuriken[3];


    private int health;
    public NinjaBoss(World w){
        super(w, ninjaBossShape);
        addImage(imageLeft);
        this.health = 200;
        this.direction = "left";
        this.speed = 5;
        //setAlwaysOutline(true);
    }

    public int getHealth(){return health;}
    public void setHealth(int health){this.health = health;}

    public void setDirection(String direction){this.direction = direction;}


    public Boolean isAlive(){
        if (health <= 0 || this.getPosition().y < -25){
            this.destroy();
            return Boolean.FALSE;
        } else return Boolean.TRUE;
    }

    public void shoot(){


        int offset = 3;

        for (int i=0; i<shurikens.length; i++){
            shurikens[i] = new Shuriken(this.getWorld());

            if (this.direction.equals("left")){
                shurikens[i].setPosition(new Vec2(this.getPosition().x-6,this.getPosition().y+offset));
                shurikens[i].setLinearVelocity(new Vec2(-20f,0f));
            } else {
                shurikens[i].setPosition(new Vec2(this.getPosition().x+6,this.getPosition().y+offset));
                shurikens[i].setLinearVelocity(new Vec2(+20f,0f));
            }

            offset -= 3;

            ShurikenImpact shurikenImpact = new ShurikenImpact(shurikens[i]);
            shurikens[i].addCollisionListener(shurikenImpact);
        }
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
