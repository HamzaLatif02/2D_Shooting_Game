package game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class InGameMenu {
    private JPanel mainPanel;
    private JButton continueButton;
    private JButton settingsButton;
    private JButton exitButton;
    private JButton saveButton;
    private JLabel gameText;
    private JLabel pausedText;
    private JPanel gamePausedPanel;

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
                try {
                    new GameSaverLoader().save("data/gamesaved.txt", game.getLevel());
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
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
