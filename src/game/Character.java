package game;

import city.cs.engine.*;

public class Character extends Walker {
    //private static final Shape characterShape = new CircleShape(2);
    private static final Shape characterShape = new PolygonShape(0.71f,1.92f, 2.2f,1.32f, 1.57f,-2.04f, -1.27f,-1.97f, -2.17f,-0.42f, -2.02f,0.82f, -1.32f,1.7f, -0.2f,2.06f);
    private static final BodyImage image = new BodyImage("data/character-right.png", 6f);

    private int points, health;

    public Character (World world) {
        super(world, characterShape);
        addImage(image);
        this.points = 0;
        this.health = 100;
        setAlwaysOutline(true);
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }


}
