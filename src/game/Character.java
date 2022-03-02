package game;

import city.cs.engine.*;

public class Character extends Walker {
    //private static final Shape characterShape = new CircleShape(2);
    private static final Shape characterShape = new PolygonShape(0.71f,1.92f, 2.2f,1.32f, 1.57f,-2.04f, -1.27f,-1.97f, -2.17f,-0.42f, -2.02f,0.82f, -1.32f,1.7f, -0.2f,2.06f);
    private static final BodyImage image = new BodyImage("data/character-left.png", 6f);

    private int credits;

    public Character (World world) {
        super(world, characterShape);
        addImage(image);
        this.credits = 0;
        setAlwaysOutline(true);
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }


}
