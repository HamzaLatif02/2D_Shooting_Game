package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import javax.swing.*;

import java.awt.*;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * Your main game entry point
 */
public class Game {

    private GameLevel level;
    private GameView view;
    private CharacterController characterController;
    private final JFrame frame;
    private MainMenu mainMenu;
    private SettingMenu settingMenu;
    private Boolean menuVisible;


    /** Initialise a new Game. */
    public Game() {

        menuVisible = Boolean.FALSE;


        frame = new JFrame("City Game");
        mainMenu = new MainMenu(this);
        settingMenu = new SettingMenu(this);


        level = new LevelOne();
        view = new GameView(this, level, 800,800, level.getCharacter(), ((LevelOne)level).getNinja(), ((LevelOne)level).getNinjaBoss());

        //1. make an empty game world
        //GameWorld world = new GameWorld();


        characterController = new CharacterController(this, level.getCharacter());

        //3. make a view to look into the game world
        //GameView view = new GameView(world, 800, 800, world.getCharacter(), world.getNinja(), world.getNinjaBoss());

        view.addMouseListener(new GiveFocus(view));

        view.addKeyListener(characterController);

        level.addStepListener(new Tracker(view, level.getCharacter(), level));


        //optional: draw a 1-metre grid over the view
        //view.setGridResolution(1);

        //4. create a Java window (frame) and add the game
        //   view to it
        //final JFrame frame = new JFrame("City Game");

        frame.add(view);

        // enable the frame to quit the application
        // when the x button is pressed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        // don't let the frame be resized
        frame.setResizable(false);
        // size the frame to fit the world view
        frame.pack();
        // finally, make the frame visible
        frame.setVisible(true);

        //optional: uncomment this to make a debugging view
        //JFrame debugView = new DebugViewer(world, 500, 500);

        // start our game world simulation!
        level.start();


        checkLevelCompletition();
    }

    public JFrame getFrame() {
        return frame;
    }

    public MainMenu getMainMenu() {
        return mainMenu;
    }

    public GameView getView() {
        return view;
    }

    public void checkLevelCompletition(){
        while (this.level.isRunning()){
            /*if (level.getCompleted()){
                goToNextLevel();
            }*/
            if (this.level.objectivesDone()){
                goToNextLevel();
            }
        }
    }

    public void goToNextLevel(){
        if (level instanceof LevelOne){
            level.stop();
            level = new LevelTwo();
            view.addEnemies(((LevelTwo)level).getMummies(), ((LevelTwo)level).getMummyBoss());
            updateLevelElements();

        } else if (level instanceof LevelTwo){
            level.stop();
            level = new LevelThree();
            view.addEnemies(((LevelThree)level).getBombThrowers());
            updateLevelElements();
        } else if (level instanceof LevelThree){
            level.stop();
        }
    }

    public void updateLevelElements(){
        view.setWorld(level);
        view.updateLevel(level);
        view.updateCharacter(level.getCharacter());
        characterController.updateCharacter(level.getCharacter());
        level.addStepListener(new Tracker(view, level.getCharacter(), level));
        level.getCharacter().setPoints(0);
        level.getCharacter().setHealth(100);
        level.getCharacter().setSpeed(6);
        level.start();
    }

    public void toggleMenu(){
        if (menuVisible){
            frame.remove(mainMenu.getMainPanel());
            menuVisible = Boolean.FALSE;
            frame.pack();
            level.start();

        } else {
            frame.add(mainMenu.getMainPanel(), BorderLayout.WEST);
            menuVisible = Boolean.TRUE;
            frame.pack();
            level.stop();
        }
    }

    public void transitionToSettings(){
        frame.remove(mainMenu.getMainPanel());
        frame.add(settingMenu.getMainPanel(), BorderLayout.WEST);
        frame.pack();
    }

    public void transitionToMainMenu(){
        frame.remove(settingMenu.getMainPanel());
        frame.add(mainMenu.getMainPanel(), BorderLayout.WEST);
        frame.pack();
    }

    /** Run the game. */
    public static void main(String[] args) {
        new Game();
    }
}
