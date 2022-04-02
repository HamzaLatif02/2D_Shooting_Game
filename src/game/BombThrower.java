package game;

import city.cs.engine.*;

public class BombThrower extends Walker {

    private static final Shape bombThrowerShape = new CircleShape(2);
    private static final BodyImage imageLeft = new BodyImage("data/level3/bombthrower-left.png", 4f);

    private int health;

    public BombThrower(World w) {
        super(w, bombThrowerShape);
        addImage(imageLeft);
        this.health = 100;
    }
}
