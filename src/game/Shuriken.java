package game;

import city.cs.engine.*;

//thrown by ninjas in level one
public class Shuriken extends DynamicBody {

    private static final Shape shurikenShape = new BoxShape(0.6f,0.6f);
    private static final BodyImage image = new BodyImage("data/level1/shuriken.png",1.2f);

    private int damage;

    public Shuriken(World w){
        super(w, shurikenShape);
        addImage(image);
        this.damage = 5;
    }

    public int getDamage(){return this.damage;}
}
