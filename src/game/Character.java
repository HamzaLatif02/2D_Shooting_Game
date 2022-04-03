package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import java.awt.*;

public class Character extends Walker {
    private static final Shape characterShape = new CircleShape(2);

    private static final BodyImage imageRight = new BodyImage("data/level1/character-right.png", 6f);
    private static final BodyImage imageLeft = new BodyImage("data/level1/character-left.png",6f);
    private static final BodyImage imageRightMoving = new BodyImage("data/level1/character-right-flame.png",6f);
    private static final BodyImage imageLeftMoving = new BodyImage("data/level1/character-left-flame.png",6f);
    private static final BodyImage imageRight2 = new BodyImage("data/level2/character2-right.png", 6f);
    private static final BodyImage imageLeft2 = new BodyImage("data/level2/character2-left.png",6f);
    private static final BodyImage imageRightMoving2 = new BodyImage("data/level2/character2-right-flame.png",6f);
    private static final BodyImage imageLeftMoving2 = new BodyImage("data/level2/character2-left-flame.png",6f);
    private static final BodyImage imageRight3 = new BodyImage("data/level3/character3-right.png", 6f);
    private static final BodyImage imageLeft3 = new BodyImage("data/level3/character3-left.png",6f);
    private static final BodyImage imageRightMoving3 = new BodyImage("data/level3/character3-right-flame.png",6f);
    private static final BodyImage imageLeftMoving3 = new BodyImage("data/level3/character3-left-flame.png",6f);
    private static final BodyImage imageRight3UpsideDown = new BodyImage("data/level3/character3-right-upsidedown.png", 6f);
    private static final BodyImage imageLeft3UpsideDown = new BodyImage("data/level3/character3-left-upsidedown.png",6f);
    private static final BodyImage imageRightMoving3UpsideDown = new BodyImage("data/level3/character3-right-upsidedown-flame.png",6f);
    private static final BodyImage imageLeftMoving3UpsideDown = new BodyImage("data/level3/character3-left-upsidedown-flame.png",6f);


    private int points, health;
    private float speed;
    private String direction;
    private Boolean changeGravity;
    private int enemiesKilled;


    public Character (World world) {
        super(world, characterShape);

        if (getWorld() instanceof LevelOne ){
            this.addImage(imageRight);
        } else if (getWorld() instanceof LevelTwo){
            this.addImage(imageRight2);
        } else if (getWorld() instanceof LevelThree){
            this.addImage(imageRight3);
        }

        this.points = 0;
        this.health = 100;
        this.direction = "right";
        this.speed = 5;
        this.changeGravity = Boolean.FALSE;
        this.enemiesKilled = 0;

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

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed){this.speed = speed;}

    public Boolean getChangeGravity() {
        return changeGravity;
    }

    public void setChangeGravity(Boolean changeGravity) {
        this.changeGravity = changeGravity;
    }

    public int getEnemiesKilled() {
        return enemiesKilled;
    }

    public void setEnemiesKilled(int enemiesKilled) {
        this.enemiesKilled = enemiesKilled;
    }

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
            } else if (getWorld() instanceof LevelThree){
                if (getGravityScale() > 0){
                    this.addImage(imageLeftMoving3);
                } else {
                    this.addImage(imageLeftMoving3UpsideDown);
                }
            }

            this.setDirection("left");

        } else {

            if (getWorld() instanceof LevelOne ){
                this.addImage(imageRightMoving);
            } else if (getWorld() instanceof LevelTwo){
                this.addImage(imageRightMoving2);
            } else if (getWorld() instanceof LevelThree) {
                if (getGravityScale() > 0) {
                    this.addImage(imageRightMoving3);
                } else {
                    this.addImage(imageRightMoving3UpsideDown);
                }
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
            } else if (getWorld() instanceof LevelThree){
                if (getGravityScale() > 0){
                    this.addImage(imageLeftMoving3);
                } else {
                    this.addImage(imageLeftMoving3UpsideDown);
                }
            }

        } else {

            if (getWorld() instanceof LevelOne ){
                this.addImage(imageRightMoving);
            } else if (getWorld() instanceof LevelTwo){
                this.addImage(imageRightMoving2);
            } else if (getWorld() instanceof LevelThree) {
                if (getGravityScale() > 0) {
                    this.addImage(imageRightMoving3);
                } else {
                    this.addImage(imageRightMoving3UpsideDown);
                }
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
            } else if (getWorld() instanceof LevelThree){
                if (getGravityScale() > 0){
                    this.addImage(imageLeft3);
                } else {
                    this.addImage(imageLeft3UpsideDown);
                }
            }

        } else {

            if (getWorld() instanceof LevelOne ){
                this.addImage(imageRight);
            } else if (getWorld() instanceof LevelTwo){
                this.addImage(imageRight2);
            } else if (getWorld() instanceof LevelThree) {
                if (getGravityScale() > 0) {
                    this.addImage(imageRight3);
                } else {
                    this.addImage(imageRight3UpsideDown);
                }
            }
        }
    }

    public void shoot(){
        Projectile p = new Projectile(this.getWorld());

        if (this.direction.equals("left")){
            p.setPosition(new Vec2(this.getPosition().x-2.5f,this.getPosition().y));
            p.setLinearVelocity(new Vec2(-30,0));
        } else {
            p.setPosition(new Vec2(this.getPosition().x+2.5f, this.getPosition().y));
            p.setLinearVelocity(new Vec2(30, 0));
        }

        ProjectileImpact projectileImpact = new ProjectileImpact(p);
        p.addCollisionListener(projectileImpact);
    }

    public Boolean isAlive(){
        if (health <= 0 || this.getPosition().y < -25 || (getWorld() instanceof LevelThree && this.getPosition().y > 54)){
            this.destroy();
            return Boolean.FALSE;
        }
        else return Boolean.TRUE;
    }




}
