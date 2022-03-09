package game;

import city.cs.engine.UserView;
import city.cs.engine.WorldView;

import javax.swing.*;
import java.awt.*;

public class GameView extends UserView {

    private Image background;
    private Character character;

    public GameView(GameWorld world, int width, int height, Character c){
        super (world,width,height);
        background = new ImageIcon("data/background.png").getImage();
        character = c;
    }

    @Override
    protected void paintBackground(Graphics2D g){
        g.drawImage(background, 0,0, this);
    }

    @Override
    protected void paintForeground(Graphics2D g){
        g.drawString("Coins: " + character.getPoints(),50,50);
    }
}
