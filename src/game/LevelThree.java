package game;

import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;

public class LevelThree extends GameLevel{

    private Image background;

    public LevelThree(){
        super();

        //getCharacter().setGravityScale(-getGravity());

        setBackground();
        placePlatforms();
        placePortal();
        placeBombThrowers();

    }

    public void setBackground() {
        this.background = new ImageIcon("data/level3/background3.png").getImage();
    }

    public void placePlatforms(){
        new WallPlatform(this).setPosition(new Vec2(-16f, 0f));
        new GroundPlatform(this).setPosition(new Vec2(0f, -17.5f));

        new DoublePlatform(this, "horizontal").setPosition(new Vec2(30f, -5f));
        new DoublePlatform(this, "vertical").setPosition(new Vec2(30f, 25f));

        new DoublePlatform(this).setPosition(new Vec2(40f, 25f));
        new DoublePlatform(this).setPosition(new Vec2(50f, 25f));
        new DoublePlatform(this).setPosition(new Vec2(60f, 25f));
        new DoublePlatform(this).setPosition(new Vec2(70f, 25f));

        new Portal(this, "gravity", "left").setPosition(new Vec2(77f, 29f));

        new SinglePlatform(this).setPosition(new Vec2(81f, 21f));
        new SinglePlatform(this).setPosition(new Vec2(81f, 37f));

        for (int i=0; i<10; i++){
            new GroundPlatform(this).setPosition(new Vec2(94f + i*35, 11.5f));
        }
        for (int i=0; i<10; i++){
            new GroundPlatform(this).setPosition(new Vec2(94f + i*35, 46.5f));
        }

        //ground1 coordinates 79-109

        //ground2 coordinates 114-144

        new SinglePlatform(this, "vertical").setPosition(new Vec2(117f, 35f));
        //new SinglePlatform(this, "vertical").setPosition(new Vec2(123f, 36f));
        new SinglePlatform(this, "vertical").setPosition(new Vec2(129f, 35f));
        //new SinglePlatform(this, "vertical").setPosition(new Vec2(135f, 36f));
        new SinglePlatform(this, "vertical").setPosition(new Vec2(141f, 35f));

        //ground3 coordinates 149-179

        new SinglePlatform(this).setPosition(new Vec2(152f, 37f));
        new SinglePlatform(this).setPosition(new Vec2(152f, 33f));
        new SinglePlatform(this).setPosition(new Vec2(152f, 29f));

        new SinglePlatform(this).setPosition(new Vec2(164f, 21f));
        new SinglePlatform(this).setPosition(new Vec2(164f, 25f));
        new SinglePlatform(this).setPosition(new Vec2(164f, 29f));

        new SinglePlatform(this).setPosition(new Vec2(176f, 37f));
        new SinglePlatform(this).setPosition(new Vec2(176f, 33f));
        new SinglePlatform(this).setPosition(new Vec2(176f, 29f));

        //ground4 coordinates 184-214

        new DoublePlatform(this).setPosition(new Vec2(190f, 32f));
        new DoublePlatform(this).setPosition(new Vec2(208f, 26f));

        //ground5 coordinates 219-249

        //ground6 coordinates 254-284

        new DoublePlatform(this).setPosition(new Vec2(260f, 26f));
        new DoublePlatform(this).setPosition(new Vec2(278f, 32f));

        //ground7 coordinates 289-319

        new SinglePlatform(this).setPosition(new Vec2(292f, 21f));
        new SinglePlatform(this).setPosition(new Vec2(292f, 25f));
        new SinglePlatform(this).setPosition(new Vec2(292f, 29f));

        new SinglePlatform(this).setPosition(new Vec2(304f, 37f));
        new SinglePlatform(this).setPosition(new Vec2(304f, 33f));
        new SinglePlatform(this).setPosition(new Vec2(304f, 29f));

        new SinglePlatform(this).setPosition(new Vec2(316f, 21f));
        new SinglePlatform(this).setPosition(new Vec2(316f, 25f));
        new SinglePlatform(this).setPosition(new Vec2(316f, 29f));

        //ground8 coordinates 324-354

        new SinglePlatform(this).setPosition(new Vec2(327f, 37f));
        new SinglePlatform(this).setPosition(new Vec2(327f, 29f));

        new SinglePlatform(this).setPosition(new Vec2(339f, 21f));
        new SinglePlatform(this).setPosition(new Vec2(339f, 29f));

        new SinglePlatform(this).setPosition(new Vec2(351f, 37f));
        new SinglePlatform(this).setPosition(new Vec2(351f, 29f));

        //ground9 coordinates 359-389

        new SinglePlatform(this, "vertical").setPosition(new Vec2(362f, 35f));
        new SinglePlatform(this, "vertical").setPosition(new Vec2(374f, 35f));
        new SinglePlatform(this, "vertical").setPosition(new Vec2(386f, 35f));

        //ground10 coordinates 394-424

        //

        new SinglePlatform(this).setPosition(new Vec2(422f, 21f));
        new SinglePlatform(this).setPosition(new Vec2(422f, 37f));

        new Portal(this, "gravity", "right").setPosition(new Vec2(426f, 29f));

        new GroundPlatform(this).setPosition(new Vec2(444f, 11.5f));
        new WallPlatform(this).setPosition(new Vec2(460f, 19f));

    }

    public void placeBombThrowers(){

        new BombThrower(this).setPosition(new Vec2(50f,29f));
        new BombThrower(this).setPosition(new Vec2(70f, 29f));

        new BombThrower(this).setPosition(new Vec2(190f,36f));
        new BombThrower(this).setPosition(new Vec2(208f,30f));

        new BombThrower(this).setPosition(new Vec2(260f, 30f));
        new BombThrower(this).setPosition(new Vec2(278f, 36f));
    }

    public void placePortal(){
        getPortal().setPosition(new Vec2(458f,30.5f));
    }

    @Override
    public Boolean objectivesDone() {
        return Boolean.FALSE;
    }

    @Override
    public Image getBackground() {
        return background;
    }
}
