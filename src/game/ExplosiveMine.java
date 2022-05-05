package game;

import city.cs.engine.*;

public class ExplosiveMine extends StaticBody {

    private static final Shape mineShape = new CircleShape(1.5f);
    private static final Shape mineShape2 = new CircleShape(3f);
    private GhostlyFixture ghostMineShape;
    private Sensor mineSensor;
    private ExplosiveMineContact explosiveMineContact;
    private static final BodyImage mineImage = new BodyImage("data/level3/explosivemine.png", 3f);
    private static final BodyImage mineImage2 = new BodyImage("data/level4/explosivemine2.png", 3f);
    private static final BodyImage mineImage3 = new BodyImage("data/level4/explosivemine3.png", 6f);
    private BodyImage explosionImage = new BodyImage("data/level3/explosion.png", 10f);
    private BodyImage explosionImage2 = new BodyImage("data/level3/explosion2.png", 10f);
    private BodyImage explosionImage3 = new BodyImage("data/level4/explosion3.png", 10f);

    private int damage;
    private String damageValue;
    private World world;

    public ExplosiveMine(World w, String damageValue) {
        super(w);
        this.world = w;
        this.damageValue = damageValue;
        if (damageValue.equals("single")){
            this.damage = 10;
            if (world instanceof LevelThree){
                addImage(mineImage);
            } else if (world instanceof LevelFour){
                addImage(mineImage2);
            }
            ghostMineShape = new GhostlyFixture(this, mineShape);
            mineSensor = new Sensor(this, mineShape);
            explosiveMineContact = new ExplosiveMineContact(this);
            mineSensor.addSensorListener(explosiveMineContact);
        } else if (damageValue.equals("double")){
            this.damage = 20;
            addImage(mineImage3);
            ghostMineShape = new GhostlyFixture(this, mineShape2);
            mineSensor = new Sensor(this, mineShape2);
            explosiveMineContact = new ExplosiveMineContact(this);
            mineSensor.addSensorListener(explosiveMineContact);
        }
    }

    public BodyImage getExplosionImage() {
        if (damageValue.equals("single")){
            if (world instanceof LevelThree){
                return explosionImage2;
            } else if (world instanceof LevelFour){
                return explosionImage;
            }
        } else if (damageValue.equals("double")){
            if (world instanceof LevelFour){
                return explosionImage3;
            }
        }
        return null;
    }

    public int getDamage() {
        return damage;
    }

    public String getDamageValue() {
        return damageValue;
    }


}
