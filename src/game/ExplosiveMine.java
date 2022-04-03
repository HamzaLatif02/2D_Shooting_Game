package game;

import city.cs.engine.*;

public class ExplosiveMine extends StaticBody {

    private static final Shape mineShape = new CircleShape(1.5f);
    private GhostlyFixture ghostMineShape;
    private Sensor mineSensor;
    private ExplosiveMineContact explosiveMineContact;
    private static final BodyImage mineImage = new BodyImage("data/level3/explosivemine.png", 3f);
    private BodyImage explosionImage = new BodyImage("data/level3/explosion2.png", 10f);

    private int damage;

    public ExplosiveMine(World w) {
        super(w);
        this.damage = 10;
        addImage(mineImage);
        ghostMineShape = new GhostlyFixture(this, mineShape);
        mineSensor = new Sensor(this, mineShape);
        explosiveMineContact = new ExplosiveMineContact(this);
        mineSensor.addSensorListener(explosiveMineContact);
    }

    public BodyImage getExplosionImage() {
        return explosionImage;
    }

    public int getDamage() {
        return damage;
    }
}
