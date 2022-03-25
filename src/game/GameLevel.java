package game;

import city.cs.engine.World;

public abstract class GameLevel extends World {

    private Character character;

    public GameLevel(){
        character = new Character(this);
    }

    public Character getCharacter(){return character;}

    public abstract Boolean isCompleted();
}