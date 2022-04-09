package game;

import city.cs.engine.SoundClip;
import city.cs.engine.World;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;

public abstract class GameLevel extends World {

    private Character character;
    private Portal portal;
    private Boolean completed;
    private String populate;

    public GameLevel(String populate){
        this.populate = populate;

        if (populate.equals("yes")){
            character = new Character(this);
            character.setPosition(new Vec2(0f, -8f));
            this.completed = Boolean.FALSE;
            portal = new Portal(this);
        } else {
            character = new Character(this);
            portal = new Portal(this);
            this.completed = Boolean.FALSE;
        }
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

    public String getPopulate() {
        return populate;
    }

    public abstract Boolean objectivesDone();

    public abstract Image getBackground();

    public abstract String getLevelName();

    public abstract void startBackgroundMusic();

    public abstract SoundClip getBackgroundMusic();

}