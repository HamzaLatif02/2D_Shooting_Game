package game;

import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;
import org.jbox2d.common.Vec2;

//keep the camera view focused on character
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
        //follow character x position
        if (level instanceof LevelOne){
            view.setCentre(new Vec2(character.getPosition().x, 0f));
        //follow character x position, and y position only if y value is bigger than 0
        } else if (level instanceof LevelTwo){
            if (character.getPosition().y > 0f){
                view.setCentre(new Vec2(character.getPosition().x, character.getPosition().y));
            } else {
                view.setCentre(new Vec2(character.getPosition().x, 0f));
            }
        //follow character x position and y position
        //if character is inside gravity changing portal, only follow x position
        } else if (level instanceof LevelThree){
            if (character.getPosition().y > 0f && character.getChangeGravity() == Boolean.FALSE){
                view.setCentre(new Vec2(character.getPosition().x, character.getPosition().y));
            } else if (character.getChangeGravity() == Boolean.TRUE){
                view.setCentre(new Vec2(character.getPosition().x, 29f));
            } else {
                view.setCentre(new Vec2(character.getPosition().x, 0f));
            }
        //follow character x position
        } else if (level instanceof LevelFour){
            view.setCentre(new Vec2(character.getPosition().x, 0f));
        }
    }
}
