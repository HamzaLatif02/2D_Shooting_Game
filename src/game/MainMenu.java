package game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu {
    private JPanel mainPanel;
    private JButton startButton;
    private JButton settingsButton;
    private JButton exitButton;

    private Game game;

    public MainMenu(Game game){
        this.game = game;

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.getFrame().dispose();
                new Game();
            }
        });

        settingsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.transitionToSettings();
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
