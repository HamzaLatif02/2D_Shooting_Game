package game;

import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;
import org.jbox2d.common.Vec2;

public class Tracker implements StepListener {

    private GameView view;
    private Character character;
    private GameLevel level;

    public Tracker (GameView gv, Character c, GameLevel l){
        this.view = gv;
        this.character = c;
        this.level = l;
    }


    @Override
    public void preStep(StepEvent e) {
    }

    @Override
    public void postStep(StepEvent e) {
        if (level instanceof LevelOne){
            view.setCentre(new Vec2(character.getPosition().x, 0f));
        } else if (level instanceof LevelTwo){
            if (character.getPosition().y > 0f){
                view.setCentre(new Vec2(character.getPosition().x, character.getPosition().y));
            } else {
                view.setCentre(new Vec2(character.getPosition().x, 0f));
            }
        }
    }
}
