package game;

import city.cs.engine.World;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;

public abstract class GameLevel extends World {

    private Character character;
    private Portal portal;
    private Boolean completed;

    public GameLevel(){

        character = new Character(this);
        character.setPosition(new Vec2(0f, -8f));
        this.completed = Boolean.FALSE;
        portal = new Portal(this);

    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public Character getCharacter(){return character;}

    public Portal getPortal() {
        return portal;
    }

    public void setPortal(Portal portal) {
        this.portal = portal;
    }

    public abstract Boolean objectivesDone();

    public abstract Image getBackground();

}