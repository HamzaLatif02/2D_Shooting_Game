package game;

import city.cs.engine.DynamicBody;
import city.cs.engine.StaticBody;

import java.io.*;

public class GameSaverLoader {

    public static void save(String fileName, GameLevel level) throws IOException {
        boolean append = false;
        FileWriter writer = null;
        try {
            writer = new FileWriter(fileName, append);

            writer.write(level.getLevelName() + "\n");

            for (int i=0; i< level.getStaticBodies().size(); i++){
                StaticBody sb = level.getStaticBodies().get(i);

                writer.write(sb.getClass().getSimpleName() + "," + sb.getPosition().x + "," + sb.getPosition().y + "\n");
            }

            for (int i=0; i<level.getDynamicBodies().size(); i++){
                DynamicBody db = level.getDynamicBodies().get(i);

                if (db instanceof Character){
                    writer.write(db.getClass().getSimpleName() + "," + db.getPosition().x + "," + db.getPosition().y + "," + ((Character) db).getHealth() + "," + ((Character) db).getDirection() + "," + ((Character) db).getPoints() + "," + ((Character) db).getSpeed() + "," + ((Character) db).getChangeGravity() + "," + ((Character) db).getEnemiesKilled() + "\n");
                } else if ( db instanceof BombThrower){
                    writer.write(db.getClass().getSimpleName() + "," + db.getPosition().x + "," + db.getPosition().y + "," + ((BombThrower) db).getHealth() + "\n");
                } else if ( db instanceof Mummy){
                    writer.write(db.getClass().getSimpleName() + "," + db.getPosition().x + "," + db.getPosition().y + "," + ((Mummy) db).getHealth() + "," + ((Mummy) db).getDirection() + "," + ((Mummy) db).getDoesMove() + "\n");
                } else if ( db instanceof MummyBoss){
                    writer.write(db.getClass().getSimpleName() + "," + db.getPosition().x + "," + db.getPosition().y + "," + ((MummyBoss) db).getHealth() + "," + ((MummyBoss) db).getDirection() + "\n");
                } else if ( db instanceof Ninja){
                    writer.write(db.getClass().getSimpleName() + "," + db.getPosition().x + "," + db.getPosition().y + "," + ((Ninja) db).getHealth() + "," + ((Ninja) db).getDirection() + "\n");
                } else if ( db instanceof NinjaBoss){
                    writer.write(db.getClass().getSimpleName() + "," + db.getPosition().x + "," + db.getPosition().y + "," + ((NinjaBoss) db).getHealth() + "," + ((NinjaBoss) db).getDirection() + "\n");
                }
                else {
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
