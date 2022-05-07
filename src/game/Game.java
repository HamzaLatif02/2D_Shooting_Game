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

    /** contain all the info about the level*/
    private GameLevel level;
    /** game view, focus on character*/
    private GameView view;
    /** controller for the character*/
    private CharacterController characterController;
    /** main frame that contains rest of frames*/
    private final JFrame frame;
    /** visible at the start of the game*/
    private MainMenu mainMenu;
    /** visible when pressing esc key, pauses the game*/
    private InGameMenu inGameMenu;
    /** contains game settings*/
    private SettingMenu settingMenu;
    /** contains current level controls info*/
    private ControlsMenu controlsMenu;
    /** contains current level objectives info*/
    private ObjectivesMenu objectivesMenu;
    /** menu for when user looses*/
    private GameLostMenu gameLostMenu;
    /** menu for when user wins*/
    private GameWonMenu gameWonMenu;
    /** user can choose file to load game from*/
    private LoadGameSelectorMenu loadGameSelectorMenu;
    /** user can choose file to save game to*/
    private SaveGameSelectorMenu saveGameSelectorMenu;
    /** whether the in game menu is visible*/
    private Boolean menuVisible;
    /** whether the main menu is visible*/
    private Boolean mainMenuVisible;
    /** whether to show controls on screen*/
    private Boolean showControls;
    /** whether to show objectives on screen*/
    private Boolean showObjectives;
    /** contains file audio*/
    private SoundClip bgMusic;


    /** Initialise a new Game. */
    public Game() throws IOException {

        mainMenuVisible = Boolean.TRUE;
        menuVisible = Boolean.FALSE;

        showControls = Boolean.FALSE;
        showObjectives = Boolean.FALSE;

        //initialise all the game menus
        frame = new JFrame("City Game");
        mainMenu = new MainMenu(this);
        inGameMenu = new InGameMenu(this);
        settingMenu = new SettingMenu(this);
        controlsMenu = new ControlsMenu(this);
        objectivesMenu = new ObjectivesMenu(this);
        gameLostMenu = new GameLostMenu(this);
        gameWonMenu = new GameWonMenu(this);
        loadGameSelectorMenu = new LoadGameSelectorMenu(this);
        saveGameSelectorMenu = new SaveGameSelectorMenu(this);

        playBackgroundMusic();
        frame.add(mainMenu.getMainPanel());

        // enable the frame to quit the application when the x button is pressed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        // don't let the frame be resized
        frame.setResizable(false);
        frame.pack();
        // finally, make the frame visible
        frame.setVisible(true);
    }

    /** Getter for mainMenu field
     * @return main menu field*/
    public MainMenu getMainMenu() {
        return mainMenu;
    }

    /** Getter for view field
     * @return view field*/
    public GameView getView() {
        return view;
    }

    /** Getter for level field
     * @return level field*/
    public GameLevel getLevel() {
        return level;
    }

    /** Getter for bgMusic field
     * @return bgMusic field*/
    public SoundClip getBgMusic() {
        return bgMusic;
    }

    /** Getter for mainMenuVisible field
     * @return mainMenuVisible field*/
    public Boolean getMainMenuVisible() {
        return mainMenuVisible;
    }

    /** Getter for showControls field
     * @return showControls field*/
    public Boolean getShowControls() {
        return showControls;
    }

    /** Setter for showControls field
     * @param showControls whether to show controls on screen or not*/
    public void setShowControls(Boolean showControls) {
        this.showControls = showControls;
    }

    /** Getter for showObjectives field
     * @return showObjectives field*/
    public Boolean getShowObjectives() {
        return showObjectives;
    }

    /** Setter for showObjectives field
     * @param showObjectives whether to show objectives on screen or not*/
    public void setShowObjectives(Boolean showObjectives) {
        this.showObjectives = showObjectives;
    }

    /** Getter for controlsMenu field
     * @return controlsMenu field*/
    public ControlsMenu getControlsMenu() {
        return controlsMenu;
    }

    /** Getter for objectivesMenu field
     * @return objectivesMenu field*/
    public ObjectivesMenu getObjectivesMenu() {
        return objectivesMenu;
    }

    /** Getter for inGameMenu field
     * @return inGameMenu field*/
    public InGameMenu getInGameMenu() {
        return inGameMenu;
    }

    /** Getter for loadGameSelectorMenu field
     * @return loadGameSelectorMenu field*/
    public LoadGameSelectorMenu getLoadGameSelectorMenu() {
        return loadGameSelectorMenu;
    }

    /** Create a new level based on the parameter passed
     * @param l which level to start*/
    //create a new level based on the parameter passed
    public void setNewLevel(GameLevel l){
        level = l;
        view = new GameView(this, level, 800,800, level.getCharacter());
        mainMenuVisible = Boolean.FALSE;
        frame.remove(loadGameSelectorMenu.getMainPanel());
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
        characterController = new CharacterController(this, level.getCharacter());
        view.addMouseListener(new GiveFocus(view));
        view.addKeyListener(characterController);
        level.addStepListener(new Tracker(view, level.getCharacter(), level));
        level.startBackgroundMusic();
        level.start();
        frame.remove(mainMenu.getMainPanel());
        frame.add(view);
        frame.pack();
    }

    /**Go to next level after the previous one has been completed*/
    //go to the next level after the previous one has been completed
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
            level.getBackgroundMusic().stop();
            level.stop();
            level = new LevelFour("yes");
            updateLevelElements();
        } else if (level instanceof LevelFour){
            transitiontoGameWonMenu();
            level.stop();
        }
    }

    /** Update character fields and update view fields when a level changes*/
    //update character fields & update view fields when a level changes
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

    /** Hide or show in game menu from game view*/
    //hide or show in game menu from game view
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

    /** Hide main menu or in game menu and show settings menu
     * @param menu describes from which menu to transit, main menu or in game menu*/
    //hide main menu or in game menu & show settings menu
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

    /** Hide main menu or in game menu and show settings menu*/
    //hide main menu or in game menu & show settings menu
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

    /** Hide in game menu and show controls menu*/
    //hide in game menu & show controls menu
    public void transitionToControlsMenu(){
        frame.remove(inGameMenu.getMainPanel());
        frame.add(controlsMenu.getMainPanel(), BorderLayout.WEST);
        frame.pack();
    }

    /** Hide controls menu & show in game menu*/
    //hide controls menu & show in game menu
    public void transitionToInGameMenuFromControls(){
        frame.remove(controlsMenu.getMainPanel());
        frame.add(inGameMenu.getMainPanel(), BorderLayout.WEST);
        frame.pack();
    }

    /** Hide in game menu and show objectives menu*/
    //hide in game menu & show objectives menu
    public void transitionToObjectivesMenu(){
        frame.remove(inGameMenu.getMainPanel());
        frame.add(objectivesMenu.getMainPanel(), BorderLayout.WEST);
        frame.pack();
    }

    /** Hide objectives menu and show in game menu*/
    //hide objectives menu & show in game menu
    public void transitionToInGameMenuFromObjectives(){
        frame.remove(objectivesMenu.getMainPanel());
        frame.add(inGameMenu.getMainPanel(), BorderLayout.WEST);
        frame.pack();
    }

    /** Show game lost menu*/
    //show game lost menu
    public void transitionToGameLostMenu(){
        frame.add(gameLostMenu.getMainPanel(), BorderLayout.WEST);
        frame.pack();
        level.stop();
    }

    /** Show game won menu*/
    //show game won menu
    public void transitiontoGameWonMenu(){
        frame.add(gameWonMenu.getMainPanel(), BorderLayout.WEST);
        frame.pack();
        level.stop();
    }

    /** Show main menu and hide other visible menu*/
    //show main menu & hide any other visible menu
    public void transitionToMainMenu(){
        frame.remove(view);
        frame.remove(gameLostMenu.getMainPanel());
        frame.remove(gameWonMenu.getMainPanel());
        mainMenuVisible = Boolean.TRUE;
        frame.add(mainMenu.getMainPanel());
        frame.pack();
    }

    /** Hide main menu and show load game menu*/
    //hide main menu & show load game menu
    public void transitionToLoadGameSelectorMenu(){
        frame.remove(mainMenu.getMainPanel());
        frame.add(loadGameSelectorMenu.getMainPanel());
        frame.pack();
    }

    /** hide laod game menu and show main menu*/
    //hide load game menu & show main menu
    public void transitionToMainMenuFromLoadGame(){
        frame.remove(loadGameSelectorMenu.getMainPanel());
        frame.add(mainMenu.getMainPanel());
        frame.pack();
    }

    /** Hide in game menu and show save game menu*/
    //hide in game menu & show save game menu
    public void transitionToSaveGameSelectorMenu(){
        frame.remove(inGameMenu.getMainPanel());
        frame.add(saveGameSelectorMenu.getMainPanel(), BorderLayout.WEST);
        frame.pack();
    }

    /** Hide save game menu and show in game menu*/
    //hide save game menu & show in game menu
    public void transitionToInGameMenuFromSaveGame(){
        frame.remove(saveGameSelectorMenu.getMainPanel());
        frame.add(inGameMenu.getMainPanel(), BorderLayout.WEST);
        frame.pack();
    }

    /** Start a new game from level one*/
    //start a new game from level one
    public void startNewGame(){
        mainMenuVisible = Boolean.FALSE;
        level = new LevelOne("yes");
        view = new GameView(this, level, 800,800, level.getCharacter());
        view.addEnemiesLevelOne(((LevelOne)level).getNinja(), ((LevelOne)level).getNinjaBoss());
        characterController = new CharacterController(this, level.getCharacter());
        view.addMouseListener(new GiveFocus(view));
        view.addKeyListener(characterController);
        level.addStepListener(new Tracker(view, level.getCharacter(), level));
        level.startBackgroundMusic();
        level.start();
        frame.remove(mainMenu.getMainPanel());
        frame.add(view);
        frame.pack();
    }

    /** Play background music*/
    //play background music
    public void playBackgroundMusic(){
        try {
            bgMusic = new SoundClip("data/bgm1.wav");
            bgMusic.setVolume(0.5);
            bgMusic.loop();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    /** Restart current level
     * @param l level to restart*/
    //restart current level
    public void restartLevel(GameLevel l){
        level.stop();
        frame.remove(gameLostMenu.getMainPanel());
        frame.pack();
        if (l instanceof LevelOne){
            level = new LevelOne("yes");
            level.startBackgroundMusic();
            view.addEnemiesLevelOne(((LevelOne)level).getNinja(), ((LevelOne)level).getNinjaBoss());
            updateLevelElements();
        } else if (l instanceof LevelTwo){
            level = new LevelTwo("yes");
            level.startBackgroundMusic();
            view.addEnemiesLevelTwo(((LevelTwo)level).getMummies(), ((LevelTwo)level).getMummyBoss());
            updateLevelElements();
        } else if (l instanceof LevelThree){
            level = new LevelThree("yes");
            level.startBackgroundMusic();
            view.addEnemiesLevelThree(((LevelThree)level).getBombThrowers());
            updateLevelElements();
        } else if (l instanceof LevelFour){
            level = new LevelFour("yes");
            level.startBackgroundMusic();
            updateLevelElements();
        }
    }

    /** Run the game. */
    public static void main(String[] args) throws IOException {
        new Game();
    }
}
