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
    private GameLevel level;

    public GameView(GameLevel level, int width, int height, Character c, Ninja[] n, NinjaBoss nb){
        super (level,width,height);
        background = new ImageIcon("data/level1/background.png").getImage();
        ninja = n;
        character = c;
        ninjaBoss = nb;
        this.level = level;

    }

    @Override
    protected void paintBackground(Graphics2D g){
        g.drawImage(background, 0,0, this);
    }

    @Override
    protected void paintForeground(Graphics2D g){

        g.drawString("Coins: " + character.getPoints(),20,50);

        g.drawString("Controls", 350,50);
        g.drawString("Move: Arrows or WASD", 350, 65);
        g.drawString("Shoot: C or K", 350, 80);

        g.drawString("To Win", 600, 50);
        g.drawString("Collect min 45 coins AND", 600, 65);
        g.drawString("Defeat the final boss", 600, 80);

        g.drawString("Health:" , 100,50);
        g.drawRect(150,40,100, 10);
        g.setColor(new Color(73,152,183));
        g.fillRect(150,40,character.getHealth(),10);

        for (Ninja ninja : ninja){
            if (ninja.isAlive()){
                g.setColor(Color.black);
                g.drawRect(Math.round(this.worldToView(ninja.getPosition()).x-25),Math.round(this.worldToView(ninja.getPosition()).y-50),50, 5);
                g.setColor(new Color(181,40,2));
                g.fillRect(Math.round(this.worldToView(ninja.getPosition()).x-25),Math.round(this.worldToView(ninja.getPosition()).y-50), Math.round(ninja.getHealth()*2.5f), 5);
            }
        }

        if (ninjaBoss.isAlive()){
            g.setColor(Color.black);
            g.drawRect(Math.round(this.worldToView(ninjaBoss.getPosition()).x-100),Math.round(this.worldToView(ninjaBoss.getPosition()).y-110),200, 5);
            g.setColor(new Color(147,3,140));
            g.fillRect(Math.round(this.worldToView(ninjaBoss.getPosition()).x-100),Math.round(this.worldToView(ninjaBoss.getPosition()).y-110), Math.round(ninjaBoss.getHealth()), 5);
        }

        if (!character.isAlive()){
            g.setFont(new Font("Arial", Font.BOLD, 100));
            g.setColor(Color.black);
            g.drawString("YOU LOST", 203, 403);
            g.setFont(new Font("Arial", Font.BOLD, 100));
            g.setColor(new Color(181,40,2));
            g.drawString("YOU LOST", 200,400);
        }

        /*if (level.isCompleted()){
            g.setFont(new Font("Arial", Font.BOLD, 100));
            g.setColor(Color.black);
            g.drawString("YOU WON", 203, 403);
            g.setFont(new Font("Arial", Font.BOLD, 100));
            g.setColor(new Color(73,152,183));
            g.drawString("YOU WON", 200,400);
        }*/


    }
}
