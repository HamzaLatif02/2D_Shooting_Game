package game;

import city.cs.engine.*;

public class Projectile extends DynamicBody {

    private static final Shape projectileShape = new PolygonShape(-0.29f,0.17f, 0.059f,0.299f, 0.288f,0.008f, 0.083f,-0.3f, -0.275f,-0.199f);
    private static final BodyImage image = new BodyImage("data/projectile.png",0.6f);
    private int damage;

    public Projectile(World w) {
        super(w, projectileShape);
        addImage(image);
        this.damage = 5;
    }
}
