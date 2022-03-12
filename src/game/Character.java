package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import java.awt.*;

public class Character extends Walker {
    private static final Shape characterShape = new CircleShape(2);
    //private static final Shape characterShapeRight = new PolygonShape(0.71f,1.92f, 2.2f,1.32f, 1.57f,-2.04f, -1.27f,-1.97f, -2.17f,-0.42f, -2.02f,0.82f, -1.32f,1.7f, -0.2f,2.06f);
    private static final BodyImage imageRight = new BodyImage("data/character-right.png", 6f);
    private static final BodyImage imageLeft = new BodyImage("data/character-left.png",6f);
    private static final BodyImage imageRightMoving = new BodyImage("data/character-right-flame.png",6f);
    private static final BodyImage imageLeftMoving = new BodyImage("data/character-left-flame.png",6f);

    //private static final Shape healthBar = new BoxShape(1f,50f);
    //private Shape remainingHealthBar = new BoxShape(1f, this.getHealth()/2f);


    private int points, health;
    private String direction;

    public Character (World world) {
        super(world, characterShape);
        addImage(imageRight);
        this.points = 0;
        this.health = 100;
        this.direction = "right";
        //setAlwaysOutline(true);

    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getDirection() {return direction;}

    public void setDirection(String direction) {this.direction = direction;}

    public int getHealth() {return health;}

    public void setHealth(int health) {this.health = health;}

   // public Shape getHealthBar() {return healthBar;}
    //public Shape getRemainingHealthBar() {return remainingHealthBar;}

    @Override
    public void startWalking(float speed){
        super.startWalking(speed);
        this.removeAllImages();
        if (speed < 0){
            this.addImage(imageLeftMoving);
            this.setDirection("left");
        } else {
            this.addImage(imageRightMoving);
            this.setDirection("right");
        }
    }

    @Override
    public void jump(float speed){
        super.jump(speed);
        this.removeAllImages();
        if (this.direction.equals("left")){
            this.addImage(imageLeftMoving);
        } else {
            this.addImage(imageRightMoving);
        }
    }

    @Override
    public void stopWalking(){
        super.stopWalking();
        this.removeAllImages();
        if (this.direction.equals("left")){
            this.addImage(imageLeft);
        } else {
            this.addImage(imageRight);
        }
    }

    public void shoot(){
        Projectile p = new Projectile(this.getWorld());

        if (this.direction.equals("left")){
            p.setPosition(new Vec2(this.getPosition().x-2.3f,this.getPosition().y));
            p.setLinearVelocity(new Vec2(-30,0));
        } else {
            p.setPosition(new Vec2(this.getPosition().x+2.3f, this.getPosition().y));
            p.setLinearVelocity(new Vec2(30, 0));
        }

        ProjectileImpact projectileImpact = new ProjectileImpact(p);
        p.addCollisionListener(projectileImpact);
    }

    public Boolean checkLife(){
        if (health <= 0 || this.getPosition().y < -25){
            this.destroy();
            return Boolean.FALSE;
        }
        else return Boolean.TRUE;
    }





}
