package game;

import city.cs.engine.*;

public class Portal extends StaticBody {

    private static final Shape portalShape = new CircleShape(2.5f);
    private static final BodyImage portalImage = new BodyImage("data/portal.png", 15f);
    private static final BodyImage gravityPortalImageLeft = new BodyImage("data/level3/gravityportal-left.png", 15f);
    private static final BodyImage gravityPortalImageRight = new BodyImage("data/level3/gravityportal-right.png", 15f);
    private GhostlyFixture ghostPortalShape;
    private Sensor portalSensor;
    private PortalInteraction portalInteraction;


    private String type, direction;

    public Portal(World w) {
        super(w, portalShape);
        addImage(portalImage);
        this.portalInteraction = new PortalInteraction(this, (GameLevel) w);
        this.addCollisionListener(portalInteraction);
        //setAlwaysOutline(true);
    }

    public Portal(World w, String type, String direction){
        super(w, portalShape);
        this.type = type;
        this.direction = direction;
        ghostPortalShape = new GhostlyFixture(this, portalShape);
        portalSensor = new Sensor(this, portalShape);

        if (type.equals("gravity") && direction.equals("left")){
            addImage(gravityPortalImageLeft);
            this.portalInteraction = new PortalInteraction(this, "gravity", "left");
        } else if (type.equals("gravity") && direction.equals("right")){
            addImage(gravityPortalImageRight);
            this.portalInteraction = new PortalInteraction(this, "gravity", "right");
        }

        portalSensor.addSensorListener(portalInteraction);
    }

    public String getType() {
        return type;
    }

    public String getDirection() {
        return direction;
    }
}
