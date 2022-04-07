package game;

import java.io.*;

public class GameSaverLoader {

    public static void save(String fileName, GameLevel level) throws IOException {
        boolean append = false;
        FileWriter writer = null;
        try {
            writer = new FileWriter(fileName, append);
            writer.write(level.getLevelName() + "\n");
            for (int i=0; i< level.getStaticBodies().size(); i++){
                writer.write(level.getStaticBodies().get(i).getClass().getSimpleName() + "," + level.getStaticBodies().get(i).getPosition().x + "," + level.getStaticBodies().get(i).getPosition().y + "\n");
            }

            for (int i=0; i<level.getDynamicBodies().size(); i++){
                if (level.getDynamicBodies().get(i) instanceof Character){
                    writer.write(level.getDynamicBodies().get(i).getClass().getSimpleName() + "," + level.getDynamicBodies().get(i).getPosition().x + "," + level.getDynamicBodies().get(i).getPosition().y + "," + ((Character) level.getDynamicBodies().get(i)).getPoints() + "," + ((Character) level.getDynamicBodies().get(i)).getHealth() + "," + ((Character) level.getDynamicBodies().get(i)).getDirection() + "," + ((Character) level.getDynamicBodies().get(i)).getSpeed() + "," + ((Character) level.getDynamicBodies().get(i)).getChangeGravity() + "," + ((Character) level.getDynamicBodies().get(i)).getEnemiesKilled() + "\n");
                } else {
                    writer.write(level.getDynamicBodies().get(i).getClass().getSimpleName() + "," + level.getDynamicBodies().get(i).getPosition().x + "," + level.getDynamicBodies().get(i).getPosition().y + "\n");
                }

            }

        } finally {
            if (writer != null) {
                writer.close();
            }
        }
        System.out.println("game saved");
    }


    public static GameLevel load(String fileName) throws IOException {
        FileReader fr = null;
        BufferedReader reader = null;
        try {
            System.out.println("Reading " + fileName + " ...");
            fr = new FileReader(fileName);
            reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
                // file is assumed to contain one name, score pair per line
                String[] tokens = line.split(",");
                String level = tokens[0];
                float positionX = Float.parseFloat(tokens[1]);
                float positionY = Float.parseFloat(tokens[2]);
                int points = Integer.parseInt(tokens[3]);
                System.out.println("Level: " + level + ", PositionX: " + positionX + ", PositionY: " + positionY + ", Points: " + points);
                line = reader.readLine();
            }
            System.out.println("...done.");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                reader.close();
            }
            if (fr != null) {
                fr.close();
            }
        }
        return null;
    }
}
