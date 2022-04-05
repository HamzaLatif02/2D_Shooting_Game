package game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.MouseAdapter;

public class SettingMenu {
    private JPanel mainPanel;
    private JButton backButton;
    private JButton volumeDownButton;
    private JButton volumeUpButton;

    private Game game;

    public SettingMenu(Game game){
        this.game = game;
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.transitionToInGameMenu();
            }
        });


    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
