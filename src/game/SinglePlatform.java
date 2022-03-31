package game;

import city.cs.engine.*;

public class SinglePlatform extends StaticBody implements StepListener {

    private static final Shape singleShape = new PolygonShape(-1.65f,2.00f, 1.65f,2.00f, 2.0f,1.65f, 2.0f,-1.65f, 1.65f,-2.00f, -1.65f,-2.00f, -2.00f,-1.65f, -2.00f,1.65f);
    private static final BodyImage image = new BodyImage("data/level1/platform-single.png",4f);
    private static final BodyImage image2 = new BodyImage("data/level2/sandstone-platform-single.png",4f);
    private static final BodyImage image3 = new BodyImage("data/level3/stone-platform-single.png", 4f);

    SinglePlatform(World w){
        super(w,singleShape);

        if (w instanceof LevelOne){
            addImage(image);
        } else if (w instanceof LevelTwo){
            addImage(image2);
        } else if (w instanceof LevelThree){
            addImage(image3);
        }
        //setAlwaysOutline(true);
    }

    @Override
    public void preStep(StepEvent stepEvent) {

    }

    @Override
    public void postStep(StepEvent stepEvent) {

    }
}
