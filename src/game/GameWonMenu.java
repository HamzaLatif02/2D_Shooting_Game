package game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//menu for when player wins the game
public class GameWonMenu {
    private JPanel mainPanel;
    private JLabel gameWonText;
    private JButton playAgainButton;
    private JButton mainMenuButton;
    private JButton exitGameButton;
    private JPanel titlePanel;
    private JPanel controlsPanel;

    private Game game;

    public GameWonMenu(Game g){
        this.game = g;

        mainMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.transitionToMainMenu();
            }
        });


        exitGameButton.addActionListener(new ActionListener() {
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
