package game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingMenu {
    private JPanel mainPanel;
    private JButton backButton;

    private Game game;

    public SettingMenu(Game game){
        this.game = game;
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.transitionToMainMenu();
            }
        });
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
