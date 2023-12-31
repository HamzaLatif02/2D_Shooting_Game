package game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//show the game controls for the current level
public class ControlsMenu {
    private JPanel mainPanel;
    private JLabel controlsText;
    private JButton backButton;
    private JLabel moveText;
    private JLabel shootText;
    private JLabel changeGravityText;
    private JLabel pauseGameText;
    private JPanel textPanel;
    private JPanel backButtonPanel;
    private JPanel titlePanel;

    private Game game;

    public ControlsMenu(Game g){
        this.game = g;


        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.transitionToInGameMenuFromControls();
            }
        });

    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public JLabel getChangeGravityText() {
        return changeGravityText;
    }

    public JLabel getShootText() {
        return shootText;
    }
}
