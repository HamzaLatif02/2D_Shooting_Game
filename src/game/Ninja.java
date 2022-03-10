package game;

import city.cs.engine.*;

public class Ninja extends Walker {

    private static final Shape ninjaShape = new CircleShape(2);
    private static final BodyImage image = new BodyImage("data/ninja-left.png", 4f);

    private int health;

    public Ninja(World world) {
        super(world, ninjaShape);
        addImage(image);
        this.health = 20;
        //setAlwaysOutline(true);
    }

    public void setHealth(int health){this.health = health;}
    public int getHealth(){return health;}

    public void checkHealth(){
        if (health <= 0){
            this.destroy();
        }
    }
}
