package game;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

//user can choose where to save the current game
public class SaveGameSelectorMenu {
    private JPanel mainPanel;
    private JPanel titlePanel;
    private JPanel controlsPanel;
    private JPanel titlePanel2;
    private JPanel controlsPanel2;
    private JPanel backButtonPanel;
    private JButton backButton;
    private JButton game1Button;
    private JButton game2Button;
    private JButton game3Button;
    private JButton selectGameButton;

    private Game game;

    public SaveGameSelectorMenu(Game g){
        this.game = g;

        //save game in file game1
        game1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new GameSaverLoader(game).save("data/game1/game1.txt", game.getLevel());
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        //save game in file game2
        game2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new GameSaverLoader(game).save("data/game2/game2.txt", game.getLevel());
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        //save game in file game3
        game3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new GameSaverLoader(game).save("data/game3/game3.txt", game.getLevel());
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        //choose path where user saves file
        selectGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                //set initial directory
                fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
                //not all extension are accepted
                fileChooser.setAcceptAllFileFilterUsed(false);
                //only text file are accepted
                fileChooser.addChoosableFileFilter(new FileNameExtensionFilter(".txt","txt"));
                fileChooser.showSaveDialog(mainPanel);

                String path = fileChooser.getSelectedFile().getAbsolutePath();

                //add .txt at the end of filename if not there already
                if (!path.endsWith(".txt")){
                    path += ".txt";
                }

                //try and save file in the path chosen by user
                if (fileChooser.getSelectedFile() != null){
                    try {
                        new GameSaverLoader(game).save(path, game.getLevel());
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.transitionToInGameMenuFromSaveGame();
            }
        });

    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
