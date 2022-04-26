package game;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class MainMenu {
    private JPanel mainPanel;
    private JButton exitButton;
    private JButton settingsButton;
    private JButton newgameButton;
    private JButton loadgameButton;
    private JLabel mainMenuText;
    private JPanel controlsPanel;
    private JPanel titlePanel;

    private Game game;

    public MainMenu(Game game){

        newgameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.getBgMusic().stop();
                game.startNewGame();
            }
        });

        loadgameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.transitionToLoadGameSelectorMenu();
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
