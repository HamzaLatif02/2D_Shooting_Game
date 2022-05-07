package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.SensorEvent;
import city.cs.engine.SensorListener;
import org.jbox2d.common.Vec2;

//portal collision with rest of world
public class PortalInteraction implements CollisionListener, SensorListener {

    private Portal portal;
    private GameLevel level;
    private String type, direction;

    public PortalInteraction(Portal p, GameLevel level){
        this.portal = p;
        this.level = level;
    }

    public PortalInteraction(Portal p, GameLevel level, String type, String direction){
        this.portal = p;
        this.level = level;
        this.type = type;
        this.direction = direction;
    }

    @Override
    public void collide(CollisionEvent e) {
        //change level
        if (e.getOtherBody() instanceof Character){
            if (level.objectivesDone()){
                level.setCompleted(Boolean.TRUE);
            }
        }
    }

    @Override
    public void beginContact(SensorEvent e) {
        if (e.getContactBody() instanceof Character){
            if (this.type.equals("gravity") && this.direction.equals("start")){
                //enter start of gravity portal from left
                if (e.getContactBody().getPosition().x < this.portal.getPosition().x){
                    //character can change gravity
                    ((Character) e.getContactBody()).setChangeGravity(Boolean.TRUE);
                    //move character beyond portal
                    e.getContactBody().setPosition(new Vec2(e.getContactBody().getPosition().x+8f, e.getContactBody().getPosition().y));
                    //change gravity
                    ((Character) e.getContactBody()).setGravityScale(-((Character) e.getContactBody()).getGravityScale());
                    //start timer if level four
                    if (level instanceof LevelFour){
                        ((LevelFour)level).getTimer().start();
                    }
                //enter start of gravity portal from right
                } else {
                    //character can't change gravity
                    ((Character) e.getContactBody()).setChangeGravity(Boolean.FALSE);
                    //make gravity normal
                    if (((Character) e.getContactBody()).getGravityScale() < 0){
                        ((Character) e.getContactBody()).setGravityScale(-((Character) e.getContactBody()).getGravityScale());
                    }
                    //move character beyond portal
                    e.getContactBody().setPosition(new Vec2(e.getContactBody().getPosition().x-8f, e.getContactBody().getPosition().y));
                    //stop timer if level four
                    if (level instanceof LevelFour){
                        ((LevelFour)level).getTimer().stop();
                    }
                }

            } else if (this.type.equals("gravity") && this.direction.equals("end")){
                //enter end of gravity portal from left
                if (e.getContactBody().getPosition().x < this.portal.getPosition().x){
                    //character can't change gravity
                    ((Character) e.getContactBody()).setChangeGravity(Boolean.FALSE);
                    //move character beyond portal
                    e.getContactBody().setPosition(new Vec2(e.getContactBody().getPosition().x+8f, e.getContactBody().getPosition().y));
                    //make gravity normal
                    if (((Character) e.getContactBody()).getGravityScale() < 0){
                        ((Character) e.getContactBody()).setGravityScale(-((Character) e.getContactBody()).getGravityScale());
                    }
                    //stop timer if level four
                    if (level instanceof LevelFour){
                        ((LevelFour)level).getTimer().stop();
                    }
                //enter end of gravity portal from right
                } else {
                    //character can change gravity
                    ((Character) e.getContactBody()).setChangeGravity(Boolean.TRUE);
                    //change gravity
                    ((Character) e.getContactBody()).setGravityScale(-((Character) e.getContactBody()).getGravityScale());
                    //move character beyond portal
                    e.getContactBody().setPosition(new Vec2(e.getContactBody().getPosition().x-8f, e.getContactBody().getPosition().y));
                    //start timer if level four
                    if (level instanceof LevelFour){
                        ((LevelFour)level).getTimer().start();
                    }
                }
            }
        }
    }

    @Override
    public void endContact(SensorEvent e) {
    }
}
