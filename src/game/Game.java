package game;

import city.cs.engine.SoundClip;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;

import java.awt.*;
import java.io.IOException;

/**
 * Your main game entry point
 */
public class Game {

    private GameLevel level;
    private GameView view;
    private CharacterController characterController;
    private final JFrame frame;
    private MainMenu mainMenu;
    private InGameMenu inGameMenu;
    private SettingMenu settingMenu;
    private ControlsMenu controlsMenu;
    private ObjectivesMenu objectivesMenu;
    private Boolean menuVisible, mainMenuVisible, showControls, showObjectives;
    private SoundClip bgMusic;


    /** Initialise a new Game. */
    public Game() {

        mainMenuVisible = Boolean.TRUE;
        menuVisible = Boolean.FALSE;

        showControls = Boolean.FALSE;
        showObjectives = Boolean.FALSE;


        frame = new JFrame("City Game");
        mainMenu = new MainMenu(this);
        inGameMenu = new InGameMenu(this);
        settingMenu = new SettingMenu(this);
        controlsMenu = new ControlsMenu(this);
        objectivesMenu = new ObjectivesMenu(this);



        level = new LevelOne("yes");
        view = new GameView(this, level, 800,800, level.getCharacter());
        view.addEnemiesLevelOne(((LevelOne)level).getNinja(), ((LevelOne)level).getNinjaBoss());
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

        if (mainMenuVisible){
            playBackgroundMusic();
            frame.add(mainMenu.getMainPanel());
        }
        //frame.add(view);

        // enable the frame to quit the application
        // when the x button is pressed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        // don't let the frame be resized
        //frame.setResizable(false);
        // size the frame to fit the world view
        frame.pack();
        // finally, make the frame visible
        frame.setVisible(true);

        //optional: uncomment this to make a debugging view
        //JFrame debugView = new DebugViewer(world, 500, 500);

        // start our game world simulation!
        level.start();


        checkLevelCompletion();
    }

    public JFrame getFrame() {
        return frame;
    }

    public InGameMenu getMainMenu() {
        return inGameMenu;
    }

    public GameView getView() {
        return view;
    }

    public GameLevel getLevel() {
        return level;
    }

    public SoundClip getBgMusic() {
        return bgMusic;
    }

    public Boolean getMainMenuVisible() {
        return mainMenuVisible;
    }

    public Boolean getShowControls() {
        return showControls;
    }

    public void setShowControls(Boolean showControls) {
        this.showControls = showControls;
    }

    public Boolean getShowObjectives() {
        return showObjectives;
    }

    public void setShowObjectives(Boolean showObjectives) {
        this.showObjectives = showObjectives;
    }

    public ControlsMenu getControlsMenu() {
        return controlsMenu;
    }

    public ObjectivesMenu getObjectivesMenu() {
        return objectivesMenu;
    }

    public void checkLevelCompletion(){
        while (level.isRunning()){

            /*if (level.getCompleted()){
                System.out.println("yes");
                goToNextLevel();
            }*/
            if (level.objectivesDone()){
                goToNextLevel();
            }
        }
    }

    public void setNewLevel(GameLevel l){
        level.stop();
        level = l;
        mainMenuVisible = Boolean.FALSE;
        frame.remove(mainMenu.getMainPanel());
        frame.add(view);
        frame.pack();
        level.startBackgroundMusic();
        if (level instanceof LevelOne){
            view.addEnemiesLevelOne(((LevelOne)level).getNinja(), ((LevelOne)level).getNinjaBoss());
        } else if (level instanceof LevelTwo){
            view.addEnemiesLevelTwo(((LevelTwo)level).getMummies(), ((LevelTwo)level).getMummyBoss());
        } else if (level instanceof LevelThree){
            view.addEnemiesLevelThree(((LevelThree)level).getBombThrowers());
        }
        view.setWorld(level);
        view.updateLevel(level);
        view.updateCharacter(level.getCharacter());
        characterController.updateCharacter(level.getCharacter());
        level.addStepListener(new Tracker(view, level.getCharacter(), level));
        level.start();





    }

    public void goToNextLevel(){
        if (level instanceof LevelOne){
            level.getBackgroundMusic().stop();
            level.stop();
            level = new LevelTwo("yes");
            level.startBackgroundMusic();
            view.addEnemiesLevelTwo(((LevelTwo)level).getMummies(), ((LevelTwo)level).getMummyBoss());
            updateLevelElements();
        } else if (level instanceof LevelTwo){
            level.getBackgroundMusic().stop();
            level.stop();
            level = new LevelThree("yes");
            level.startBackgroundMusic();
            view.addEnemiesLevelThree(((LevelThree)level).getBombThrowers());
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
            frame.remove(inGameMenu.getMainPanel());
            menuVisible = Boolean.FALSE;
            frame.pack();
            level.start();

        } else {
            frame.add(inGameMenu.getMainPanel(), BorderLayout.WEST);
            menuVisible = Boolean.TRUE;
            frame.pack();
            level.stop();
        }
    }

    public void transitionToSettings(String menu){
        if (menu.equals("main")){
            frame.remove(mainMenu.getMainPanel());
            frame.add(settingMenu.getMainPanel());
            frame.pack();
        } else if (menu.equals("ingame")){
            frame.remove(inGameMenu.getMainPanel());
            frame.add(settingMenu.getMainPanel(), BorderLayout.WEST);
            frame.pack();
        }

    }

    public void transitionToInGameMenu(){
        if (mainMenuVisible){
            frame.remove(settingMenu.getMainPanel());
            frame.add(mainMenu.getMainPanel());
            frame.pack();
        } else {
            frame.remove(settingMenu.getMainPanel());
            frame.add(inGameMenu.getMainPanel(), BorderLayout.WEST);
            frame.pack();
        }

    }

    public void transitionToControlsMenu(){
        frame.remove(inGameMenu.getMainPanel());
        frame.add(controlsMenu.getMainPanel(), BorderLayout.WEST);
        frame.pack();
    }

    public void transitionToInGameMenuFromControls(){
        frame.remove(controlsMenu.getMainPanel());
        frame.add(inGameMenu.getMainPanel(), BorderLayout.WEST);
        frame.pack();
    }

    public void transitionToObjectivesMenu(){
        frame.remove(inGameMenu.getMainPanel());
        frame.add(objectivesMenu.getMainPanel(), BorderLayout.WEST);
        frame.pack();
    }

    public void transitionToInGameMenuFromObjectives(){
        frame.remove(objectivesMenu.getMainPanel());
        frame.add(inGameMenu.getMainPanel(), BorderLayout.WEST);
        frame.pack();
    }

    public void startNewGame(){
        mainMenuVisible = Boolean.FALSE;
        frame.remove(mainMenu.getMainPanel());
        frame.add(view);
        frame.pack();
    }

    public void playBackgroundMusic(){
        try {
            bgMusic = new SoundClip("data/bgm1.wav");
            bgMusic.setVolume(0.5);
            bgMusic.loop();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    /** Run the game. */
    public static void main(String[] args) {
        new Game();
    }
}
