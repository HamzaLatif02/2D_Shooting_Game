package game;

import city.cs.engine.UserView;
import city.cs.engine.World;
import city.cs.engine.WorldView;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;

public class GameView extends UserView {

    private Character character;
    private Ninja[] ninja;
    private NinjaBoss ninjaBoss;
    private GameLevel level;
    private Mummy[] mummy;
    private MummyBoss mummyBoss;

    public GameView(GameLevel l, int width, int height, Character c, Ninja[] n, NinjaBoss nb){
        super (l,width,height);
        ninja = n;
        character = c;
        ninjaBoss = nb;
        level = l;
    }

    public void addEnemies(Mummy[] m, MummyBoss mb){
        mummy = m;
        mummyBoss = mb;
    }

    public void updateCharacter(Character character){
        this.character = character;
    }

    public void updateLevel(GameLevel level){
        this.level = level;
    }

    @Override
    protected void paintBackground(Graphics2D g){
        g.drawImage(level.getBackground() , 0,0, this);
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
        if (level instanceof LevelOne){
            g.setColor(new Color(73,152,183));
        } else if (level instanceof LevelTwo){
            g.setColor(new Color(88,219,109));
        }

        g.fillRect(150,40,character.getHealth(),10);

        if (level instanceof LevelTwo){
            g.setColor(Color.black);
            g.drawString("Speed: ", 100, 70);
            g.drawRect(150, 60, 60, 10);
            g.setColor(new Color(181,247,189));
            g.fillRect(150,60, (int) (character.getSpeed()*10f),10);
        }

        if (level instanceof LevelOne){
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

        } else if (level instanceof LevelTwo){
            for (Mummy mummy : mummy){
                if (mummy.isAlive()){
                    g.setColor(Color.black);
                    g.drawRect(Math.round(this.worldToView(mummy.getPosition()).x-25),Math.round(this.worldToView(mummy.getPosition()).y-50),50, 5);
                    g.setColor(new Color(168,201,117));
                    g.fillRect(Math.round(this.worldToView(mummy.getPosition()).x-25),Math.round(this.worldToView(mummy.getPosition()).y-50), Math.round(mummy.getHealth()), 5);
                }
            }

            if (mummyBoss.isAlive()){
                g.setColor(Color.black);
                g.drawRect(Math.round(this.worldToView(mummyBoss.getPosition()).x-100),Math.round(this.worldToView(mummyBoss.getPosition()).y-110),200, 5);
                g.setColor(new Color(0,255,176));
                g.fillRect(Math.round(this.worldToView(mummyBoss.getPosition()).x-100),Math.round(this.worldToView(mummyBoss.getPosition()).y-110), Math.round(mummyBoss.getHealth()/2), 5);
            }
        }


        if (!character.isAlive()){
            g.setFont(new Font("Arial", Font.BOLD, 100));
            g.setColor(Color.black);
            g.drawString("YOU LOST", 203, 403);
            g.setFont(new Font("Arial", Font.BOLD, 100));
            g.setColor(new Color(181,40,2));
            g.drawString("YOU LOST", 200,400);
        }

        /*if (level.objectivesDone()){
            g.setFont(new Font("Arial", Font.BOLD, 40));
            g.setColor(Color.black);
            g.drawString("LEVEL COMPLETED", Math.round(this.worldToView(level.getPortal().getPosition()).x-150), Math.round(this.worldToView(level.getPortal().getPosition()).y+200));
            g.setFont(new Font("Arial", Font.BOLD, 40));
            g.setColor(new Color(73,152,183));
            g.drawString("LEVEL COMPLETED", Math.round(this.worldToView(level.getPortal().getPosition()).x-148),Math.round(this.worldToView(level.getPortal().getPosition()).y+198));

        }*/
    }
}
