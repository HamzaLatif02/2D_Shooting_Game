package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class PortalInteraction implements CollisionListener {

    private Portal portal;
    private GameLevel level;

    public PortalInteraction(Portal p, GameLevel level){
        this.portal = p;
        this.level = level;
    }

    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Character){
            if (level.objectivesDone()){
                level.setCompleted(Boolean.TRUE);
            }
        }
    }
}
