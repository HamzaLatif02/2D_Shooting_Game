package game;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TimeScoreSaverLoader {

    private static Game game;

    public TimeScoreSaverLoader(Game g){
        this.game = g;
    }

    public static void save(String fileName, GameLevel level) throws IOException {
        boolean append = false;
        FileWriter writer = null;

        try {

            writer = new FileWriter(fileName, append);

            writer.write(((LevelFour) level).getTimer().getMinutes() + "," + ((LevelFour) level).getTimer().getSeconds() + "," + ((LevelFour) level).getTimer().getTime() + "\n");

        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }

    public static DefaultListModel load(String fileName) throws IOException {
        FileReader fr = null;
        BufferedReader reader = null;

        DefaultListModel listModel = new DefaultListModel();
        String timeScore;

        try {
            fr = new FileReader(fileName);
            reader = new BufferedReader(fr);

            String line = reader.readLine();

            if (line == null){
                JOptionPane.showMessageDialog(game.getMainMenu().getMainPanel(), "No previous games on this device", "No previous games", JOptionPane.ERROR_MESSAGE);
                return null;
            }

            while (line != null){
                String[] tokens = line.split(",");

                timeScore = (tokens[0] + ":" + tokens[1] + ":" + tokens[2]);
                listModel.addElement(timeScore);
                line = reader.readLine();
            }
        } finally {
            if (reader != null) {
                reader.close();
            }
            if (fr != null) {
                fr.close();
            }
        }
        return listModel;
    }
}
