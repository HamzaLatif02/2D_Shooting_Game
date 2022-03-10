package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class Ninja extends Walker {

    private static final Shape ninjaShape = new CircleShape(2);
    private static final BodyImage image = new BodyImage("data/ninja-left.png", 4f);

    private int health;
    private String direction;

    public Ninja(World world) {
        super(world, ninjaShape);
        addImage(image);
        this.health = 20;
        this.direction = "left";
        //setAlwaysOutline(true);
    }

    public void setHealth(int health){this.health = health;}
    public int getHealth(){return health;}

    public void checkHealth(){
        if (health <= 0){
            this.destroy();
        }
    }

    public void shoot(){
        Shuriken s = new Shuriken(this.getWorld());

        if (this.direction.equals("left")){
            s.setPosition(new Vec2(this.getPosition().x-3,this.getPosition().y));
            s.setLinearVelocity(new Vec2(-20,0));
        } else {
            s.setPosition(new Vec2(this.getPosition().x+3, this.getPosition().y));
            s.setLinearVelocity(new Vec2(20, 0));
        }


    }
}
