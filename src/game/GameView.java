package game;

import city.cs.engine.UserView;
import city.cs.engine.WorldView;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;

public class GameView extends UserView {

    private Image background;
    private Character character;
    private Ninja[] ninja;
    private NinjaBoss ninjaBoss;

    public GameView(GameWorld world, int width, int height, Character c, Ninja[] n, NinjaBoss nb){
        super (world,width,height);
        background = new ImageIcon("data/background.png").getImage();
        ninja = n;
        character = c;
        ninjaBoss = nb;

    }

    @Override
    protected void paintBackground(Graphics2D g){
        g.drawImage(background, 0,0, this);
    }

    @Override
    protected void paintForeground(Graphics2D g){

        g.drawString("Coins: " + character.getPoints(),50,50);

        g.drawString("Health:" , 250,50);
        g.drawRect(300,40,100, 10);
        g.setColor(new Color(73,152,183));
        g.fillRect(300,40,character.getHealth(),10);

        for (Ninja ninja : ninja){
            if (ninja.isAlive() == Boolean.TRUE){
                g.setColor(Color.black);
                g.drawRect(Math.round(this.worldToView(ninja.getPosition()).x-25),Math.round(this.worldToView(ninja.getPosition()).y-50),50, 5);
                g.setColor(new Color(181,40,2));
                g.fillRect(Math.round(this.worldToView(ninja.getPosition()).x-25),Math.round(this.worldToView(ninja.getPosition()).y-50), Math.round(ninja.getHealth()*2.5f), 5);
            }
        }

        if (ninjaBoss.isAlive() == Boolean.TRUE){
            g.setColor(Color.black);
            g.drawRect(Math.round(this.worldToView(ninjaBoss.getPosition()).x-100),Math.round(this.worldToView(ninjaBoss.getPosition()).y-110),200, 5);
            g.setColor(new Color(147,3,140));
            g.fillRect(Math.round(this.worldToView(ninjaBoss.getPosition()).x-100),Math.round(this.worldToView(ninjaBoss.getPosition()).y-110), Math.round(ninjaBoss.getHealth()), 5);
        }


    }
}
