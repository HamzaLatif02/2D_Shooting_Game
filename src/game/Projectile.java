package game;

import city.cs.engine.*;

public class Projectile extends DynamicBody {

    private static final Shape projectileShape = new PolygonShape(-0.48f,0.286f, 0.096f,0.5f, 0.48f,0.012f, 0.136f,-0.5f, -0.458f,-0.332f);
    private static final BodyImage image = new BodyImage("data/level1/projectile2.png",1f);
    private static final BodyImage image2 = new BodyImage("data/level2/projectile4.png",1f);

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
