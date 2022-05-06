package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

//Bomb Throwers are enemies found in the third level.
//As the name suggests they throw bomb objects.
public class BombThrower extends Walker implements StepListener {

    private static final Shape bombThrowerShape = new CircleShape(2);
    private static final BodyImage imageLeft = new BodyImage("data/level3/bombthrower-left.png", 4f);

    private int health;
    private int time;
    private Bomb bomb;
    private GameLevel level;
    //field to keep track if the death of this bomb thrower has been added to the death count of the character.
    private Boolean killAdded;

    public BombThrower(World w) {
        super(w, bombThrowerShape);
        level = (GameLevel)w;
        addImage(imageLeft);
        this.health = 50;
        this.killAdded = Boolean.FALSE;
        getWorld().addStepListener(this);

    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public Boolean getKillAdded() {
        return killAdded;
    }

    public void setKillAdded(Boolean killAdded) {
        this.killAdded = killAdded;
    }

    //when the bomb thrower falls out of the world or his health is equal to zero, it dies.
    public boolean isAlive(){
        if (health <= 0 || this.getPosition().y < -25){
            this.destroy();
            return Boolean.FALSE;
        } else return Boolean.TRUE;
    }

    //bomb throwers shoot bombs at an angled point
    public void shoot(){
        bomb = new Bomb(this.getWorld());
        bomb.setPosition(new Vec2(this.getPosition().x-3, this.getPosition().y));
        bomb.setLinearVelocity(new Vec2(-10f, 5f));
        bomb.setAngularVelocity(0);
        BombImpact bombImpact = new BombImpact(bomb);
        bomb.addCollisionListener(bombImpact);
    }

    //bomb throwers shoot only if the character is close to them
    //bomb throwers shoot every two seconds
    @Override
    public void preStep(StepEvent stepEvent) {
        if (this.isAlive() == Boolean.TRUE){
            if (this.getPosition().x - level.getCharacter().getPosition().x < 20){
                if (time % 120 == 0){
                    shoot();
                }
            }
        time++;
        }
    }

    @Override
    public void postStep(StepEvent stepEvent) {

    }
}
