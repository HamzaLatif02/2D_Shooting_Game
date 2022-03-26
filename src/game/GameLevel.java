package game;

import city.cs.engine.World;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;

public abstract class GameLevel extends World {

    private Character character;

    public GameLevel(){

        character = new Character(this);
        character.setPosition(new Vec2(0f, -8f));

    }

    public Character getCharacter(){return character;}


    public abstract Boolean isCompleted();

    public abstract Image getBackground();

}