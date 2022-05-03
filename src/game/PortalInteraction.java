package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.SensorEvent;
import city.cs.engine.SensorListener;
import org.jbox2d.common.Vec2;

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
                if (e.getContactBody().getPosition().x < this.portal.getPosition().x){
                    ((Character) e.getContactBody()).setChangeGravity(Boolean.TRUE);
                    e.getContactBody().setPosition(new Vec2(e.getContactBody().getPosition().x+8f, e.getContactBody().getPosition().y));
                    ((Character) e.getContactBody()).setGravityScale(-((Character) e.getContactBody()).getGravityScale());

                    ((LevelFour)level).getTimer().start();
                } else {
                    ((Character) e.getContactBody()).setChangeGravity(Boolean.FALSE);
                    if (((Character) e.getContactBody()).getGravityScale() < 0){
                        ((Character) e.getContactBody()).setGravityScale(-((Character) e.getContactBody()).getGravityScale());
                    }
                    e.getContactBody().setPosition(new Vec2(e.getContactBody().getPosition().x-8f, e.getContactBody().getPosition().y));

                    ((LevelFour)level).getTimer().stop();
                }

            } else if (this.type.equals("gravity") && this.direction.equals("end")){
                if (e.getContactBody().getPosition().x < this.portal.getPosition().x){
                    ((Character) e.getContactBody()).setChangeGravity(Boolean.FALSE);
                    e.getContactBody().setPosition(new Vec2(e.getContactBody().getPosition().x+8f, e.getContactBody().getPosition().y));
                    if (((Character) e.getContactBody()).getGravityScale() < 0){
                        ((Character) e.getContactBody()).setGravityScale(-((Character) e.getContactBody()).getGravityScale());
                    }

                    ((LevelFour)level).getTimer().stop();
                } else {
                    ((Character) e.getContactBody()).setChangeGravity(Boolean.TRUE);
                    ((Character) e.getContactBody()).setGravityScale(-((Character) e.getContactBody()).getGravityScale());
                    e.getContactBody().setPosition(new Vec2(e.getContactBody().getPosition().x-8f, e.getContactBody().getPosition().y));

                    ((LevelFour)level).getTimer().start();
                }
            }
        }
    }

    @Override
    public void endContact(SensorEvent e) {
    }
}
