package game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//show objectives for current level
public class ObjectivesMenu {
    private JPanel mainPanel;
    private JButton backButton;
    private JLabel objectivesText;
    private JLabel coinsTextLevelOneTwo;
    private JLabel killTextLevelOneTwo;
    private JLabel coinTextLevelThree;
    private JLabel killTextLevelThree;
    private JPanel backButtonPanel;
    private JPanel textPanel;
    private JPanel titlePanel;

    private Game game;

    public ObjectivesMenu(Game g){
        this.game = g;

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.transitionToInGameMenuFromObjectives();
            }
        });
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public JLabel getCoinsTextLevelOneTwo() {
        return coinsTextLevelOneTwo;
    }

    public JLabel getKillTextLevelOneTwo() {
        return killTextLevelOneTwo;
    }

    public JLabel getCoinTextLevelThree() {
        return coinTextLevelThree;
    }

    public JLabel getKillTextLevelThree() {
        return killTextLevelThree;
    }
}
