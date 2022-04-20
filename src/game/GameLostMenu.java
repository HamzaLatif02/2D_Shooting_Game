package game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameLostMenu {
    private JPanel mainPanel;
    private JLabel gameOverText;
    private JButton restartButton;
    private JButton exitGameButton;
    private JButton mainMenuButton;

    private Game game;

    public GameLostMenu(Game g){
        this.game = g;

        restartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.restartLevel(game.getLevel());
            }
        });


        mainMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.setMainMenuVisible(Boolean.TRUE);
                //new Game();
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
