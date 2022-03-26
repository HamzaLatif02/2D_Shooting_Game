package game;

import city.cs.engine.*;

public class Projectile extends DynamicBody {

    private static final Shape projectileShape = new PolygonShape(-0.29f,0.17f, 0.059f,0.299f, 0.288f,0.008f, 0.083f,-0.3f, -0.275f,-0.199f);
    private static final BodyImage image = new BodyImage("data/level1/projectile2.png",1f);
    private static final BodyImage image2 = new BodyImage("data/level2/projectile3.png",1f);

    private int damage;

    public Projectile(World w) {
        super(w, projectileShape);

        if (w instanceof LevelOne ){
            this.addImage(image);
        } else if (w instanceof LevelTwo){
            this.addImage(image2);
        }

        this.damage = 5;
    }

    public void setDamage(int damage){this.damage = damage;}
    public int getDamage(){return damage;}
}
