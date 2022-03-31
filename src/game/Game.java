package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import javax.swing.JFrame;

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


    /** Initialise a new Game. */
    public Game() {


        level = new LevelOne();
        view = new GameView(level, 800,800, level.getCharacter(), ((LevelOne)level).getNinja(), ((LevelOne)level).getNinjaBoss());

        //1. make an empty game world
        //GameWorld world = new GameWorld();

        characterController = new CharacterController(level.getCharacter());

        //3. make a view to look into the game world
        //GameView view = new GameView(world, 800, 800, world.getCharacter(), world.getNinja(), world.getNinjaBoss());

        view.addMouseListener(new GiveFocus(view));

        view.addKeyListener(characterController);

        level.addStepListener(new Tracker(view, level.getCharacter(), level));

        //optional: draw a 1-metre grid over the view
        //view.setGridResolution(1);

        //4. create a Java window (frame) and add the game
        //   view to it
        final JFrame frame = new JFrame("City Game");
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

        while (level.isRunning()){
            /*if (level.getCompleted()){
                goToNextLevel();
            }*/
            if (level.objectivesDone()){
                goToNextLevel();
            }
        }

        /*while (world.isRunning()){
            if (world.getCharacter().checkLife() == Boolean.FALSE){
                world.oneStep();
                world.stop();
            } else if (world.getCharacter().getPoints() > 44 && world.getNinjaBoss().isAlive() == Boolean.FALSE){
                world.oneStep();
                world.stop();
            }
        }*/
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
            updateLevelElements();
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


    /** Run the game. */
    public static void main(String[] args) {

        new Game();
    }
}
