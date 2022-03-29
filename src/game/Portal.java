package game;

import city.cs.engine.*;

public class Portal extends StaticBody {

    private static final Shape portalShape = new CircleShape(2.5f);
    private static final BodyImage portalImage = new BodyImage("data/portal.png", 15f);

    public Portal(World w) {
        super(w, portalShape);
        addImage(portalImage);
        PortalInteraction portalInteraction = new PortalInteraction(this, (GameLevel) w);
        this.addCollisionListener(portalInteraction);
        //setAlwaysOutline(true);
    }
}
