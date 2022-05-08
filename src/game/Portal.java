package game;

import city.cs.engine.*;

//portals are used to go to next level or enable the ability to change gravity

/**
 * Used to go to next level or enable the ability to change gravity
 */
public class Portal extends StaticBody {

    private static final Shape portalShape = new CircleShape(2.5f);
    private static final BodyImage portalImage = new BodyImage("data/portal.png", 15f);
    private static final BodyImage gravityPortalImageLeft = new BodyImage("data/level3/gravityportal-left.png", 15f);
    private static final BodyImage gravityPortalImageRight = new BodyImage("data/level3/gravityportal-right.png", 15f);
    private GhostlyFixture ghostPortalShape;
    private Sensor portalSensor;
    private PortalInteraction portalInteraction;

    private String type, direction;

    /**
     * Initialise a new Portal, used to transition to next level
     * @param w in which world the portal is placed
     */
    public Portal(World w) {
        super(w, portalShape);
        addImage(portalImage);
        this.portalInteraction = new PortalInteraction(this, (GameLevel) w);
        this.addCollisionListener(portalInteraction);
    }

    /**
     * Initialise a new special Portal, user can decide its use
     * @param w in which world the portal is placed
     * @param type what type is the portal, ex "gravity"
     * @param direction whether it's the starting portal or the ending portal
     */
    public Portal(World w, String type, String direction){
        super(w, portalShape);
        this.type = type;
        this.direction = direction;
        ghostPortalShape = new GhostlyFixture(this, portalShape);
        portalSensor = new Sensor(this, portalShape);

        if (type.equals("gravity") && direction.equals("start")){
            addImage(gravityPortalImageLeft);
            this.portalInteraction = new PortalInteraction(this, (GameLevel) w,"gravity", "start");
        } else if (type.equals("gravity") && direction.equals("end")){
            addImage(gravityPortalImageRight);
            this.portalInteraction = new PortalInteraction(this, (GameLevel) w,"gravity", "end");
        }

        portalSensor.addSensorListener(portalInteraction);
    }

    /**
     * Get type of the portal
     * @return type field
     */
    public String getType() {
        return type;
    }

    /**
     * Get direction of the portal
     * @return direction field
     */
    public String getDirection() {
        return direction;
    }
}
