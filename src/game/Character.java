package game;

import city.cs.engine.*;

public class Character extends Walker {
    private static final Shape characterShape = new BoxShape(1,2);
    private static final BodyImage image = new BodyImage("data/character-left.png", 4f);

    private int credits;

    public Character (World world) {
        super(world, characterShape);
        addImage(image);
        this.credits = 0;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }


}
