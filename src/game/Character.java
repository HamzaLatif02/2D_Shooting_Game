package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import java.awt.*;

public class Character extends Walker {
    private static final Shape characterShape = new CircleShape(2);
    //private static final Shape characterShapeRight = new PolygonShape(0.71f,1.92f, 2.2f,1.32f, 1.57f,-2.04f, -1.27f,-1.97f, -2.17f,-0.42f, -2.02f,0.82f, -1.32f,1.7f, -0.2f,2.06f);
    private static final BodyImage imageRight = new BodyImage("data/level1/character-right.png", 6f);
    private static final BodyImage imageLeft = new BodyImage("data/level1/character-left.png",6f);
    private static final BodyImage imageRightMoving = new BodyImage("data/level1/character-right-flame.png",6f);
    private static final BodyImage imageLeftMoving = new BodyImage("data/level1/character-left-flame.png",6f);
    private static final BodyImage imageRight2 = new BodyImage("data/level2/character2-right.png", 6f);
    private static final BodyImage imageLeft2 = new BodyImage("data/level2/character2-left.png",6f);
    private static final BodyImage imageRightMoving2 = new BodyImage("data/level2/character2-right-flame.png",6f);
    private static final BodyImage imageLeftMoving2 = new BodyImage("data/level2/character2-left-flame.png",6f);

    //private static final Shape healthBar = new BoxShape(1f,50f);
    //private Shape remainingHealthBar = new BoxShape(1f, this.getHealth()/2f);


    private int points, health, speed;
    private String direction;

    public Character (World world) {
        super(world, characterShape);

        if (getWorld() instanceof LevelOne ){
            this.addImage(imageRight);
        } else if (getWorld() instanceof LevelTwo){
            this.addImage(imageRight2);
        }

        this.points = 0;
        this.health = 100;
        this.direction = "right";
        this.speed = 5;
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

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed){this.speed = speed;}

    // public Shape getHealthBar() {return healthBar;}
    //public Shape getRemainingHealthBar() {return remainingHealthBar;}

    @Override
    public void startWalking(float speed){
        super.startWalking(speed);
        this.removeAllImages();
        if (speed < 0){

            if (getWorld() instanceof LevelOne ){
                this.addImage(imageLeftMoving);
            } else if (getWorld() instanceof LevelTwo){
                this.addImage(imageLeftMoving2);
            }

            this.setDirection("left");

        } else {

            if (getWorld() instanceof LevelOne ){
                this.addImage(imageRightMoving);
            } else if (getWorld() instanceof LevelTwo){
                this.addImage(imageRightMoving2);
            }

            this.setDirection("right");
        }
    }

    @Override
    public void jump(float speed){
        super.jump(speed);
        this.removeAllImages();
        if (this.direction.equals("left")){

            if (getWorld() instanceof LevelOne ){
                this.addImage(imageLeftMoving);
            } else if (getWorld() instanceof LevelTwo){
                this.addImage(imageLeftMoving2);
            }

        } else {

            if (getWorld() instanceof LevelOne ){
                this.addImage(imageRightMoving);
            } else if (getWorld() instanceof LevelTwo){
                this.addImage(imageRightMoving2);
            }

        }
    }

    @Override
    public void stopWalking(){
        super.stopWalking();
        this.removeAllImages();
        if (this.direction.equals("left")){

            if (getWorld() instanceof LevelOne ){
                this.addImage(imageLeft);
            } else if (getWorld() instanceof LevelTwo){
                this.addImage(imageLeft2);
            }

        } else {

            if (getWorld() instanceof LevelOne ){
                this.addImage(imageRight);
            } else if (getWorld() instanceof LevelTwo){
                this.addImage(imageRight2);
            }

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

    public Boolean isAlive(){
        if (health <= 0 || this.getPosition().y < -25){
            this.destroy();
            return Boolean.FALSE;
        }
        else return Boolean.TRUE;
    }




}
