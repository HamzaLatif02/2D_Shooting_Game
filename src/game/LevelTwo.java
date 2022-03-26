package game;

import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;

public class LevelTwo extends GameLevel{

    private Image background;

    public LevelTwo(){
        super();

        setBackground();
        placePlatforms();

    }

    public void setBackground(){
        background = new ImageIcon("data/level2/background2.png").getImage();
    }

    public void placePlatforms(){

        new WallPlatform(this).setPosition(new Vec2(-16f,0f));

        new GroundPlatform(this).setPosition(new Vec2(0f,-17.5f));
    }


    @Override
    public Boolean isCompleted() {
        return Boolean.FALSE;
    }

    @Override
    public Image getBackground(){return background;}

}
