package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.*;
import java.io.IOException;

/**
 * Main character, controlled by the user
 */
//Character class for the main characters controlled by the user
public class Character extends Walker {
    private static final Shape characterShape = new CircleShape(2);

    //character images level one
    private static final BodyImage imageRight = new BodyImage("data/level1/character-right.png", 6f);
    private static final BodyImage imageLeft = new BodyImage("data/level1/character-left.png",6f);
    private static final BodyImage imageRightMoving = new BodyImage("data/level1/character-right-flame.png",6f);
    private static final BodyImage imageLeftMoving = new BodyImage("data/level1/character-left-flame.png",6f);
    //character images level two
    private static final BodyImage imageRight2 = new BodyImage("data/level2/character2-right.png", 6f);
    private static final BodyImage imageLeft2 = new BodyImage("data/level2/character2-left.png",6f);
    private static final BodyImage imageRightMoving2 = new BodyImage("data/level2/character2-right-flame.png",6f);
    private static final BodyImage imageLeftMoving2 = new BodyImage("data/level2/character2-left-flame.png",6f);
    //character images level three
    private static final BodyImage imageRight3 = new BodyImage("data/level3/character3-right.png", 6f);
    private static final BodyImage imageLeft3 = new BodyImage("data/level3/character3-left.png",6f);
    private static final BodyImage imageRightMoving3 = new BodyImage("data/level3/character3-right-flame.png",6f);
    private static final BodyImage imageLeftMoving3 = new BodyImage("data/level3/character3-left-flame.png",6f);
    private static final BodyImage imageRight3UpsideDown = new BodyImage("data/level3/character3-right-upsidedown.png", 6f);
    private static final BodyImage imageLeft3UpsideDown = new BodyImage("data/level3/character3-left-upsidedown.png",6f);
    private static final BodyImage imageRightMoving3UpsideDown = new BodyImage("data/level3/character3-right-upsidedown-flame.png",6f);
    private static final BodyImage imageLeftMoving3UpsideDown = new BodyImage("data/level3/character3-left-upsidedown-flame.png",6f);
    //character images level four
    private static final BodyImage imageRight4 = new BodyImage("data/level4/character4-right.png", 6f);
    private static final BodyImage imageLeft4 = new BodyImage("data/level4/character4-left.png",6f);
    private static final BodyImage imageRightMoving4 = new BodyImage("data/level4/character4-right-flame.png",6f);
    private static final BodyImage imageLeftMoving4 = new BodyImage("data/level4/character4-left-flame.png",6f);
    private static final BodyImage imageRight4UpsideDown = new BodyImage("data/level4/character4-right-upsidedown.png", 6f);
    private static final BodyImage imageLeft4UpsideDown = new BodyImage("data/level4/character4-left-upsidedown.png",6f);
    private static final BodyImage imageRightMoving4UpsideDown = new BodyImage("data/level4/character4-right-flame-upsidedown.png",6f);
    private static final BodyImage imageLeftMoving4UpsideDown = new BodyImage("data/level4/character4-left-flame-upsidedown.png",6f);

    private int points, health;
    private float speed;
    private String direction;
    //field to keep track if the character can change gravity. used in level three and four
    private Boolean changeGravity;
    private int enemiesKilled;

    /**
     * Initialise a new Character
     * @param world which game to create the character in
     */
    public Character (World world) {
        super(world, characterShape);

        if (getWorld() instanceof LevelOne ){
            this.addImage(imageRight);
        } else if (getWorld() instanceof LevelTwo){
            this.addImage(imageRight2);
        } else if (getWorld() instanceof LevelThree){
            this.addImage(imageRight3);
        } else if (getWorld() instanceof LevelFour){
            this.addImage(imageRight4);
        }

        this.points = 0;
        this.health = 100;
        this.direction = "right";
        this.speed = 5;
        this.changeGravity = Boolean.FALSE;
        this.enemiesKilled = 0;
    }

    /**
     * Get character points
     * @return points field
     */
    public int getPoints() {
        return points;
    }

    /**
     * Set character points
     * @param points value to assign to character points
     */
    public void setPoints(int points) {
        this.points = points;
    }

    /**
     * Get charcater direction
     * @return direction field
     */
    public String getDirection() {return direction;}

    /**
     * Set character direction
     * @param direction value to assign to character direction
     */
    public void setDirection(String direction) {this.direction = direction;}

    /**
     * Get character health
     * @return health field
     */
    public int getHealth() {return health;}

    /**
     * Set charcater health
     * @param health value to assign to character health
     */
    public void setHealth(int health) {this.health = health;}

    /**
     * Get character speed
     * @return
     */
    public float getSpeed() {
        return speed;
    }

    /**
     * Set character speed
     * @param speed value to assign to character speed
     */
    public void setSpeed(float speed){this.speed = speed;}

    /**
     * Get whether the character can change gravity
     * @return changeGravity field
     */
    public Boolean getChangeGravity() {
        return changeGravity;
    }

    /**
     * Set whether the character can change gravity
     * @param changeGravity value to assign to changeGravity
     */
    public void setChangeGravity(Boolean changeGravity) {
        this.changeGravity = changeGravity;
    }

    /**
     * Get how many enemies the character has killed
     * @return enemiesKilled field
     */
    public int getEnemiesKilled() {
        return enemiesKilled;
    }

    /**
     * Set how many enemies the character has killed
     * @param enemiesKilled value to assign to enemiesKilled
     */
    public void setEnemiesKilled(int enemiesKilled) {
        this.enemiesKilled = enemiesKilled;
    }

    //character movement
    //change character image depending on whether it moves left or right
    /**
     * Character starts moving left or right, depending on the speed
     * @param speed speed at which the character walks
     */
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
            } else if (getWorld() instanceof LevelFour){
                if (getGravityScale() > 0){
                    this.addImage(imageLeftMoving4);
                } else {
                    this.addImage(imageLeftMoving4UpsideDown);
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
            } else if (getWorld() instanceof LevelFour){
                if (getGravityScale() > 0){
                    this.addImage(imageRightMoving4);
                } else {
                    this.addImage(imageRightMoving4UpsideDown);
                }
            }
            this.setDirection("right");
        }
    }

    //change character image depending on whether it jumps left or right
    /**
     * Character jumps depending on the speed
     * @param speed speed at which the character jumps
     */
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
            } else if (getWorld() instanceof LevelFour){
                if (getGravityScale() > 0){
                    this.addImage(imageLeftMoving4);
                } else {
                    this.addImage(imageLeftMoving4UpsideDown);
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
            } else if (getWorld() instanceof LevelFour){
                if (getGravityScale() > 0){
                    this.addImage(imageRightMoving4);
                } else {
                    this.addImage(imageRightMoving4UpsideDown);
                }
            }

        }
    }


    //change character image depending on whether it stops facing left or right
    /**
     * Character stops moving left or right
     */
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
            } else if (getWorld() instanceof LevelFour){
                if (getGravityScale() > 0){
                    this.addImage(imageLeft4);
                } else {
                    this.addImage(imageLeft4UpsideDown);
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
            } else if (getWorld() instanceof LevelFour){
                if (getGravityScale() > 0){
                    this.addImage(imageRight4);
                } else {
                    this.addImage(imageRight4UpsideDown);
                }
            }
        }
    }

    //character shoots left or right depending on where it is facing, left or right
    /**
     * Character shoot left or right, depending on his direction
     */
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

    //when character is out the world the boundaries or its health is zero it dies
    /**
     * Check if the character is alive and inside world boundaries
     * @return whether the character is alive
     */
    public Boolean isAlive(){
        if (health <= 0 || this.getPosition().y < -25 || (getWorld() instanceof LevelThree && this.getPosition().y > 54)){
            this.destroy();
            getWorld().stop();
            return Boolean.FALSE;
        }
        else return Boolean.TRUE;
    }

}
