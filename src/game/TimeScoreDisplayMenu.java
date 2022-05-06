package game;

import javax.swing.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.IOException;

public class TimeScoreDisplayMenu {
    private JPanel mainPanel;
    private JPanel titlePanel;
    private JPanel listPanel;
    private JLabel timeScoresText;
    private JList timeScoresList;

    private Game game;


    public TimeScoreDisplayMenu(Game g) throws IOException {
        this.game =g;
        addScores();
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public void addScores(){
        DefaultListModel listModel = null;
        try {
            listModel = new TimeScoreSaverLoader(game).load("data/timescores.txt");
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        System.out.println(listModel);
        this.timeScoresList = new JList(listModel);
    }
}
