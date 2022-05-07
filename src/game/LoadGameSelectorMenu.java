package game;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

//user can choose from which file to load a game
public class LoadGameSelectorMenu {
    private JPanel mainPanel;
    private JPanel titlePanel;
    private JPanel controlsPanel;
    private JPanel titlePanel2;
    private JPanel controlsPanel2;
    private JLabel selectOneGameText;
    private JLabel loadYourOwnText;
    private JButton game1Button;
    private JButton game2Button;
    private JButton game3Button;
    private JButton selectGameButton;
    private JPanel backButtonPanel;
    private JButton backButton;

    private Game game;

    public LoadGameSelectorMenu(Game g){
        this.game =g;


        //load game from game1 file
        game1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    GameLevel loadedLevel = new GameSaverLoader(game).load("data/game1/game1.txt");
                    if (loadedLevel != null){
                        game.getBgMusic().stop();
                        game.setNewLevel(loadedLevel);
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        //load game from game2 file
        game2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    GameLevel loadedLevel = new GameSaverLoader(game).load("data/game2/game2.txt");
                    if (loadedLevel != null){
                        game.getBgMusic().stop();
                        game.setNewLevel(loadedLevel);
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        //load game from game3 file
        game3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    GameLevel loadedLevel = new GameSaverLoader(game).load("data/game3/game3.txt");
                    if (loadedLevel != null){
                        game.getBgMusic().stop();
                        game.setNewLevel(loadedLevel);
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        //user can browse in his computer and choose a file to load game
        selectGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                //set initial directory
                fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
                //not all files types are accepted
                fileChooser.setAcceptAllFileFilterUsed(false);
                //only accept txt files
                fileChooser.addChoosableFileFilter(new FileNameExtensionFilter(".txt","txt"));
                fileChooser.showOpenDialog(mainPanel);

                //if user has selected a file, try and load game
                if (fileChooser.getSelectedFile() != null){
                    try {
                        GameLevel loadedLevel = new GameSaverLoader(game).load(fileChooser.getSelectedFile().getAbsolutePath());
                        if (loadedLevel != null){
                            game.getBgMusic().stop();
                            game.setNewLevel(loadedLevel);
                        }
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.transitionToMainMenuFromLoadGame();
            }
        });
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
