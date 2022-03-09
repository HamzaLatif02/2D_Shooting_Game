package game;

import city.cs.engine.*;

public class Projectile extends DynamicBody {

    private static final Shape projectileShape = new CircleShape(0.3f);
    //private static final BodyImage image = new BodyImage();
    private int damage;

    public Projectile(World w) {
        super(w, projectileShape);
        //addImage();
        this.damage = 5;
    }
}
