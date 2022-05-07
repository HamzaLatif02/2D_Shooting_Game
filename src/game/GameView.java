package game;

import city.cs.engine.UserView;
import city.cs.engine.World;
import city.cs.engine.WorldView;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import javax.swing.text.Style;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

//game visual
public class GameView extends UserView {

    private Game game;
    private Character character;
    private ArrayList<Ninja> ninja;
    private ArrayList<NinjaBoss> ninjaBoss;
    private GameLevel level;
    private ArrayList<Mummy> mummy;
    private ArrayList<MummyBoss> mummyBoss;
    private ArrayList<BombThrower> bombThrowers;


    public GameView(Game g, GameLevel l, int width, int height, Character c){
        super (l,width,height);
        game = g;
        character = c;
        level = l;
    }

    public void addEnemiesLevelTwo(ArrayList<Mummy> m, ArrayList<MummyBoss> mb){
        mummy = m;
        mummyBoss = mb;
    }

    public void addEnemiesLevelOne(ArrayList<Ninja> n, ArrayList<NinjaBoss> nb){
        ninja = n;
        ninjaBoss = nb;
    }
    public void addEnemiesLevelThree(ArrayList<BombThrower> bt){
        bombThrowers = bt;
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

        //background transparent box
        g.setColor(new Color(255,255,255,75));
        g.fillRect(10,35,80,30);
        g.setColor(Color.white);
        g.drawRect(10, 35, 80, 30);

        g.setFont(new Font("JetBrains Mono", 0, 16));

        //show how many coins the user has collected
        ImageIcon coinImage = new ImageIcon("data/coin.png");
        g.drawImage(coinImage.getImage(), 20, 35, 30,30,null);
        g.setColor(Color.black);
        g.drawString(""+character.getPoints(),60,55);

        g.setFont(new Font("JetBrains Mono", 0, 12));

        //show game controls if the option is on
        g.setColor(new Color(255,255,255,75));
        if (game.getShowControls()){
            //background transparent box
            g.fillRect(340, 35, 160, 80);
            g.setColor(Color.white);
            g.drawRect(340, 35, 160, 80);
            //controls text
            g.setColor(Color.black);
            g.drawString("Controls", 350,50);
            g.drawString("Pause: Esc", 350, 65);
            g.drawString("Move: Arrows or WASD", 350, 80);

            if (!(level instanceof LevelFour)){
                g.drawString("Shoot: C or K", 350, 95);
            }

            if ((level instanceof LevelThree || level instanceof LevelFour) && character.getChangeGravity()){
                g.drawString("Gravity: Spacebar", 350, 110);
            }
        }

        //show level objectives if option is on
        g.setColor(new Color(255,255,255,75));
        if (game.getShowObjectives()){
            //background transparent box
            g.fillRect(590, 35, 190, 50);
            g.setColor(Color.white);
            g.drawRect(590, 35, 190, 50);
            //objectives text
            g.setColor(Color.black);
            g.drawString("To Win", 600, 50);
            if (level instanceof LevelOne || level instanceof LevelTwo){
                g.drawString("Collect min 45 coins AND", 600, 65);
                g.drawString("Defeat the final boss", 600, 80);
            } else if (level instanceof LevelThree){
                g.drawString("Collect min 120 coins AND", 600, 65);
                g.drawString("Defeat all enemies", 600, 80);
            } else if (level instanceof LevelFour){
                g.drawString("Finish the level", 600, 65);
                g.drawString("under 1 minute", 600, 80);
            }
        }


        //show character health
        ImageIcon health = new ImageIcon("data/health.png");
        //background transparent box
        g.setColor(new Color(255,255,255,75));
        g.fillRect(90, 35, 170, 30);
        g.setColor(Color.white);
        g.drawRect(90, 35, 170, 30);
        //health bar
        g.setColor(Color.black);
        g.drawImage(health.getImage(), 100, 35, 30, 30, null);
        g.drawRect(140,45,100, 10);
        if (level instanceof LevelOne){
            g.setColor(new Color(73,152,183));
        } else if (level instanceof LevelTwo){
            g.setColor(new Color(88,219,109));
        } else if (level instanceof LevelThree){
            g.setColor(new Color(246,216,172));
        } else if (level instanceof LevelFour){
            g.setColor(new Color(83,105,122));
        }

        g.fillRect(140,45,character.getHealth(),10);

        //show character speed in level two
        if (level instanceof LevelTwo){
            //background transparent box
            g.setColor(new Color(255,255,255,75));
            g.fillRect(90, 65, 130, 30);
            g.setColor(Color.white);
            g.drawRect(90, 65, 130, 30);
            //speed bar
            ImageIcon speed = new ImageIcon("data/speed.png");
            g.setColor(Color.black);
            g.drawImage(speed.getImage(), 100, 65, 30, 30, null);
            g.drawRect(140, 75, 60, 10);
            g.setColor(new Color(181,247,189));
            g.fillRect(140,75, (int) (character.getSpeed()*10f),10);
        }

        g.setFont(new Font("JetBrains Mono", 0, 16));
        //show how many enemies the character has killed in level three
        if (level instanceof LevelThree){
            //background transparent box
            g.setColor(new Color(255,255,255,75));
            g.fillRect(10, 65, 100, 30);
            g.setColor(Color.white);
            g.drawRect(10, 65, 100, 30);
            //kill count
            ImageIcon kills = new ImageIcon("data/kills.png");
            g.drawImage(kills.getImage(), 20, 65, 30, 30, null);
            g.setColor(Color.black);
            g.drawString("" + character.getEnemiesKilled() + "/10", 60, 85);
        }

        //show timer in level four
        if (level instanceof LevelFour){
                //background transparent box
                g.setColor(new Color(255,255,255,75));
                g.fillRect(330, 630, 200, 150);
                g.setColor(Color.white);
                g.drawRect(330, 630, 200, 150);
                //timer text
                ImageIcon timer = new ImageIcon("data/timer.png");
                g.drawImage(timer.getImage(), 370, 640, 80, 80, null);
                g.setFont(new Font("JetBrains Mono", 0, 40));
                g.setColor(Color.black);
                g.drawString(((LevelFour) level).getTimer().getMinutes() + ":" + ((LevelFour) level).getTimer().getSeconds() + ":" + ((LevelFour) level).getTimer().getTime(), 350, 760);
                g.setColor(Color.white);
                g.drawString(((LevelFour) level).getTimer().getMinutes() + ":" + ((LevelFour) level).getTimer().getSeconds() + ":" + ((LevelFour) level).getTimer().getTime(), 352, 762);

        }

        g.setFont(new Font("JetBrains Mono", 0, 12));

        //display text near gravity portal
        if (level instanceof LevelThree){
            g.setFont(new Font("JetBrains Mono", Font.BOLD, 35));
            g.setColor(Color.black);
            g.drawString("PRESS SPACEBAR", Math.round(this.worldToView(new Vec2(85f, 0f)).x), Math.round(this.worldToView(new Vec2(0f, 22f)).y));
            g.drawString("TO CHANGE GRAVITY", Math.round(this.worldToView(new Vec2(85f, 0f)).x), Math.round(this.worldToView(new Vec2(0f, 20f)).y));
            g.setFont(new Font("JetBrains Mono", Font.BOLD, 35));
            g.setColor(new Color(146, 239, 143));
            g.drawString("PRESS SPACEBAR", Math.round(this.worldToView(new Vec2(84.9f, 0f)).x), Math.round(this.worldToView(new Vec2(0f, 21.9f)).y));
            g.drawString("TO CHANGE GRAVITY", Math.round(this.worldToView(new Vec2(84.9f, 0f)).x), Math.round(this.worldToView(new Vec2(0f, 19.9f)).y));
        }

        //show enemies health above them
        if (level instanceof LevelOne){
            for (Ninja ninja : ninja){
                if (ninja.isAlive()){
                    g.setColor(Color.black);
                    g.drawRect(Math.round(this.worldToView(ninja.getPosition()).x-25),Math.round(this.worldToView(ninja.getPosition()).y-50),50, 5);
                    g.setColor(new Color(181,40,2));
                    g.fillRect(Math.round(this.worldToView(ninja.getPosition()).x-25),Math.round(this.worldToView(ninja.getPosition()).y-50), Math.round(ninja.getHealth()*2.5f), 5);
                }
            }

            if (ninjaBoss.get(0).isAlive()){
                g.setColor(Color.black);
                g.drawRect(Math.round(this.worldToView(ninjaBoss.get(0).getPosition()).x-100),Math.round(this.worldToView(ninjaBoss.get(0).getPosition()).y-110),200, 5);
                g.setColor(new Color(147,3,140));
                g.fillRect(Math.round(this.worldToView(ninjaBoss.get(0).getPosition()).x-100),Math.round(this.worldToView(ninjaBoss.get(0).getPosition()).y-110), Math.round(ninjaBoss.get(0).getHealth()), 5);
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

            if (mummyBoss.get(0).isAlive()){
                g.setColor(Color.black);
                g.drawRect(Math.round(this.worldToView(mummyBoss.get(0).getPosition()).x-100),Math.round(this.worldToView(mummyBoss.get(0).getPosition()).y-110),200, 5);
                g.setColor(new Color(0,255,176));
                g.fillRect(Math.round(this.worldToView(mummyBoss.get(0).getPosition()).x-100),Math.round(this.worldToView(mummyBoss.get(0).getPosition()).y-110), Math.round(mummyBoss.get(0).getHealth()/2), 5);
            }
        } else if (level instanceof LevelThree){
            for (BombThrower bombThrower : bombThrowers){
                if (bombThrower.isAlive()){
                    g.setColor(Color.black);
                    g.drawRect(Math.round(this.worldToView(bombThrower.getPosition()).x-25),Math.round(this.worldToView(bombThrower.getPosition()).y-50),50, 5);
                    g.setColor(new Color(79,193,179));
                    g.fillRect(Math.round(this.worldToView(bombThrower.getPosition()).x-25),Math.round(this.worldToView(bombThrower.getPosition()).y-50), Math.round(bombThrower.getHealth()), 5);
                }
            }
        }

        //write loss text if character dies
        if (!character.isAlive()){
            game.transitionToGameLostMenu();
            g.setFont(new Font("JetBrains Mono", Font.BOLD, 100));
            g.setColor(Color.black);
            g.drawString("YOU LOST", 203, 403);
            g.setFont(new Font("JetBrains Mono", Font.BOLD, 100));
            g.setColor(new Color(181,40,2));
            g.drawString("YOU LOST", 200,400);
        }

        //display text when user completes level
        if (level.objectivesDone() && (level instanceof LevelOne || level instanceof LevelTwo || level instanceof LevelThree)){
            g.setFont(new Font("JetBrains Mono", Font.BOLD, 40));
            g.setColor(Color.black);
            g.drawString("LEVEL COMPLETED", Math.round(this.worldToView(level.getPortal().getPosition()).x-150), Math.round(this.worldToView(level.getPortal().getPosition()).y+200));
            g.setFont(new Font("JetBrains Mono", Font.BOLD, 40));
            g.setColor(new Color(73,152,183));
            g.drawString("LEVEL COMPLETED", Math.round(this.worldToView(level.getPortal().getPosition()).x-148),Math.round(this.worldToView(level.getPortal().getPosition()).y+198));
        } else if (level.objectivesDone() && level instanceof LevelFour){
            g.setFont(new Font("JetBrains Mono", Font.BOLD, 40));
            g.setColor(Color.black);
            g.drawString("GAME COMPLETED", Math.round(this.worldToView(level.getPortal().getPosition()).x-150), Math.round(this.worldToView(level.getPortal().getPosition()).y+200));
            g.setFont(new Font("JetBrains Mono", Font.BOLD, 40));
            g.setColor(new Color(73,152,183));
            g.drawString("GAME COMPLETED", Math.round(this.worldToView(level.getPortal().getPosition()).x-148),Math.round(this.worldToView(level.getPortal().getPosition()).y+198));
        }

        //if (level.getCompleted()){
          //  game.goToNextLevel();
        //}

        if (level.objectivesDone()){
            game.goToNextLevel();
        }
    }
}
