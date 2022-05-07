package game;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

//in game menu, can be accessed by pressing esc key
public class InGameMenu {
    private JPanel mainPanel;
    private JButton continueButton;
    private JButton settingsButton;
    private JButton exitButton;
    private JButton saveButton;
    private JLabel gameText;
    private JLabel pausedText;
    private JPanel titlePanel;
    private JButton controlsButton;
    private JButton objectivesButton;
    private JPanel controlsPanel;

    private Game game;

    public InGameMenu(Game game){
        this.game = game;

        continueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.toggleMenu();
            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.transitionToSaveGameSelectorMenu();
            }
        });

        objectivesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //only show objectives for level one and two, which are the same
                if (game.getLevel() instanceof LevelOne || game.getLevel() instanceof LevelTwo){
                    game.getObjectivesMenu().getCoinsTextLevelOneTwo().setVisible(true);
                    game.getObjectivesMenu().getKillTextLevelOneTwo().setVisible(true);
                    game.getObjectivesMenu().getCoinTextLevelThree().setVisible(false);
                    game.getObjectivesMenu().getKillTextLevelThree().setVisible(false);
                //only show objectives for level three
                } else if (game.getLevel() instanceof LevelThree){
                    game.getObjectivesMenu().getCoinsTextLevelOneTwo().setVisible(false);
                    game.getObjectivesMenu().getKillTextLevelOneTwo().setVisible(false);
                    game.getObjectivesMenu().getCoinTextLevelThree().setVisible(true);
                    game.getObjectivesMenu().getKillTextLevelThree().setVisible(true);
                }
                game.transitionToObjectivesMenu();
            }
        });

        controlsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //only show controls for level one and two, which are the same
                if (game.getLevel() instanceof LevelOne || game.getLevel() instanceof LevelTwo){
                    game.getControlsMenu().getChangeGravityText().setVisible(false);
                //only show controls for level three
                } else if (game.getLevel() instanceof LevelThree){
                    game.getControlsMenu().getChangeGravityText().setVisible(true);
                }
                game.transitionToControlsMenu();
            }
        });

        settingsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.transitionToSettings("ingame");
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

    }

    public JPanel getMainPanel(){
        return mainPanel;
    }
}
