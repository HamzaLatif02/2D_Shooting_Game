package game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MainMenu {
    private JPanel mainPanel;
    private JButton exitButton;
    private JButton settingsButton;
    private JButton newgameButton;
    private JButton loadgameButton;
    private JLabel mainMenuText;

    private Game game;

    public MainMenu(Game game){

        newgameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.getBgMusic().stop();
                game.getLevel().startBackgroundMusic();
                game.startNewGame();
            }
        });

        loadgameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    GameLevel loadedLevel = new GameSaverLoader().load("data/gamesaved.txt");
                    game.getBgMusic().stop();
                    game.setNewLevel(loadedLevel);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        settingsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.transitionToSettings("main");
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });



    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
