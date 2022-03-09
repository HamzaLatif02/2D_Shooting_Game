package game;

import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;
import org.jbox2d.common.Vec2;

public class Tracker implements StepListener {

    private GameView view;
    private Character character;

    public Tracker (GameView gv, Character c){
        this.view = gv;
        this.character = c;
    }


    @Override
    public void preStep(StepEvent e) {
    }

    @Override
    public void postStep(StepEvent e) {
        view.setCentre(new Vec2(character.getPosition().x, 0f));
    }
}
