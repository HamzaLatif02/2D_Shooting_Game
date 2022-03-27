package game;

import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;

public class LevelTwo extends GameLevel{

    private Image background;
    private Mummy[] mummies = new Mummy[10];


    public LevelTwo(){
        super();

        setBackground();
        placePlatforms();
        placeMummies();


    }

    public void setBackground(){
        background = new ImageIcon("data/level2/background2.png").getImage();
    }

    public void placePlatforms(){

        new WallPlatform(this).setPosition(new Vec2(-16f,0f));

        new GroundPlatform(this).setPosition(new Vec2(0f,-17.5f));

        new DoublePlatform(this, "horizontal").setPosition(new Vec2(30f, -5f));
        new DoublePlatform(this, "horizontal").setPosition(new Vec2(45f,-1f));

        new GroundPlatform(this).setPosition(new Vec2(70f, -17.5f));

        new SinglePlatform(this).setPosition(new Vec2(70f, -8f));
        new SinglePlatform(this).setPosition(new Vec2(60f,0f));
        new SinglePlatform(this).setPosition(new Vec2(80f,0f));
        new SinglePlatform(this).setPosition(new Vec2(50f,8f));
        new SinglePlatform(this).setPosition(new Vec2(90f,8f));
        new SinglePlatform(this).setPosition(new Vec2(60f,16f));
        new SinglePlatform(this).setPosition(new Vec2(80f,16f));
        new SinglePlatform(this).setPosition(new Vec2(70f,24f));

        new SinglePlatform(this).setPosition(new Vec2(70f, 8f));

        new DoublePlatform(this, "horizontal").setPosition(new Vec2(105f,-8f));
        new DoublePlatform(this, "horizontal").setPosition(new Vec2(120f, 0f));
        new DoublePlatform(this, "horizontal").setPosition(new Vec2(135f, -8f));

        new GroundPlatform(this).setPosition(new Vec2(160f,-17.5f));

        new DoublePlatform(this, "vertical").setPosition(new Vec2(175f, 16f));
        new DoublePlatform(this).setPosition(new Vec2(185f, 16f));
        new DoublePlatform(this).setPosition(new Vec2(200f, 16f));
        new DoublePlatform(this).setPosition(new Vec2(215f, 16f));
        new DoublePlatform(this).setPosition(new Vec2(230f, 16f));
        new DoublePlatform(this).setPosition(new Vec2(245f, 16f));
        new DoublePlatform(this, "vertical").setPosition(new Vec2(255f, 16f));

        new GroundPlatform(this).setPosition(new Vec2(270f,-17.5f));

        new DoublePlatform(this, "vertical").setPosition(new Vec2(285f, 16f));

        new SinglePlatform(this).setPosition(new Vec2(295f, 16f));

        new DoublePlatform(this, "vertical").setPosition(new Vec2(305f, 32f));

        new GroundPlatform( this).setPosition(new Vec2(330f, 26.5f));

        new WallPlatform(this).setPosition(new Vec2(346f,34f));

    }

    public void placeMummies(){

        for (int i =0; i< 5; i++){
            mummies[i] = new Mummy(this, "no");
        }

        for (int i=5; i< 10; i++){
            mummies[i] = new Mummy(this, "yes");
        }

        mummies[0].setPosition(new Vec2(70f,-4f));
        mummies[1].setPosition(new Vec2(70f, 12f));
        mummies[2].setPosition(new Vec2(90f, 12f));
        mummies[3].setPosition(new Vec2(200f, 20f));
        mummies[4].setPosition(new Vec2(295f, 20f));

        mummies[5].setPosition(new Vec2(170f, -8f));
        mummies[6].setPosition(new Vec2(219f,20f));
        mummies[7].setPosition(new Vec2(234f, 20f));
        mummies[8].setPosition(new Vec2(280f, -8f));
        mummies[9].setPosition(new Vec2(335f, 36f));

    }

    @Override
    public Boolean isCompleted() {
        return Boolean.FALSE;
    }

    @Override
    public Image getBackground(){return background;}

}
