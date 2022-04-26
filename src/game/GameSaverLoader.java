package game;

import city.cs.engine.DynamicBody;
import city.cs.engine.StaticBody;
import city.cs.engine.Walker;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.io.*;

public class GameSaverLoader {

    private static Game game;
    public GameSaverLoader(Game g){
        this.game = g;
    }


    public static void save(String fileName, GameLevel level) throws IOException {
        boolean append = false;
        FileWriter writer = null;
        try {
            writer = new FileWriter(fileName, append);

            writer.write(level.getLevelName() + "\n");

            for (int i=0; i< level.getStaticBodies().size(); i++){
                StaticBody sb = level.getStaticBodies().get(i);

                if (sb instanceof Coin){
                    writer.write(sb.getClass().getSimpleName() + "," + sb.getPosition().x + "," + sb.getPosition().y + "," + ((Coin) sb).getValue() + "\n");
                } else if (sb instanceof DoublePlatform){
                    writer.write(sb.getClass().getSimpleName() + "," + sb.getPosition().x + "," + sb.getPosition().y + "," + ((DoublePlatform) sb).getDirection() + "," + ((DoublePlatform) sb).getTime() + "\n");
                } else if (sb instanceof HealthPotion){
                    writer.write(sb.getClass().getSimpleName() + "," + sb.getPosition().x + "," + sb.getPosition().y + "," + ((HealthPotion) sb).getType() + "\n");
                } else if (sb instanceof Portal){
                    writer.write(sb.getClass().getSimpleName() + "," + sb.getPosition().x + "," + sb.getPosition().y + "," + ((Portal) sb).getType() + "," + ((Portal) sb).getDirection() + "\n");
                } else if (sb instanceof SinglePlatform){
                    writer.write(sb.getClass().getSimpleName() + "," + sb.getPosition().x + "," + sb.getPosition().y + "," + ((SinglePlatform) sb).getMovement() + "," + ((SinglePlatform) sb).getTime1() + "," + ((SinglePlatform) sb).getTime2() + "\n");
                } else if (sb instanceof SpeedPotion){
                    writer.write(sb.getClass().getSimpleName() + "," + sb.getPosition().x + "," + sb.getPosition().y + "," + ((SpeedPotion) sb).getType() + "\n");
                }
                else {
                    writer.write(sb.getClass().getSimpleName() + "," + sb.getPosition().x + "," + sb.getPosition().y + "\n");
                }

            }

            for (int i=0; i<level.getDynamicBodies().size(); i++){
                DynamicBody db = level.getDynamicBodies().get(i);

                if (db instanceof Character){
                    writer.write(db.getClass().getSimpleName() + "," + db.getPosition().x + "," + db.getPosition().y + "," + ((Character) db).getHealth() + "," + ((Character) db).getDirection() + "," + ((Character) db).getPoints() + "," + ((Character) db).getSpeed() + "," + ((Character) db).getChangeGravity() + "," + ((Character) db).getEnemiesKilled() + "\n");
                } else if ( db instanceof BombThrower){
                    writer.write(db.getClass().getSimpleName() + "," + db.getPosition().x + "," + db.getPosition().y + "," + ((BombThrower) db).getHealth() + "\n");
                } else if ( db instanceof Mummy){
                    writer.write(db.getClass().getSimpleName() + "," + db.getPosition().x + "," + db.getPosition().y + "," + ((Mummy) db).getHealth() + "," + ((Mummy) db).getDirection() + "," + ((Mummy) db).getDoesMove() + "," + ((Mummy) db).getTime() + "\n");
                } else if ( db instanceof MummyBoss){
                    writer.write(db.getClass().getSimpleName() + "," + db.getPosition().x + "," + db.getPosition().y + "," + ((MummyBoss) db).getHealth() + "," + ((MummyBoss) db).getDirection() + "," + ((MummyBoss) db).getTime() + "\n");
                } else if ( db instanceof Ninja){
                    writer.write(db.getClass().getSimpleName() + "," + db.getPosition().x + "," + db.getPosition().y + "," + ((Ninja) db).getHealth() + "," + ((Ninja) db).getDirection() + "," + ((Ninja) db).getTime() + "\n");
                } else if ( db instanceof NinjaBoss){
                    writer.write(db.getClass().getSimpleName() + "," + db.getPosition().x + "," + db.getPosition().y + "," + ((NinjaBoss) db).getHealth() + "," + ((NinjaBoss) db).getDirection() + "," + ((NinjaBoss) db).getTime() +"\n");
                } else if (db instanceof Projectile){
                    writer.write(db.getClass().getSimpleName() + "," + db.getPosition().x + "," + db.getPosition().y + "," + ((Projectile) db).getTime() + "\n");
                } else if (db instanceof PoisonProjectile){
                    writer.write(db.getClass().getSimpleName() + "," + db.getPosition().x + "," + db.getPosition().y + "," + ((PoisonProjectile) db).getTime() + "\n");
                }  else if (db instanceof Bomb){
                    writer.write(db.getClass().getSimpleName() + "," + db.getPosition().x + "," + db.getPosition().y + "," + ((Bomb) db).getTime() + "\n");
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

        JOptionPane.showMessageDialog(game.getView(), "Game successfully saved", "Game Saved", JOptionPane.INFORMATION_MESSAGE);
    }


    public static GameLevel load(String fileName) throws IOException {
        FileReader fr = null;
        BufferedReader reader = null;
        try {
            fr = new FileReader(fileName);
            reader = new BufferedReader(fr);

            String line = reader.readLine();

            if (line == null){
                JOptionPane.showMessageDialog(game.getMainMenu().getMainPanel(), "This file does not contain a saved level", "Level not found", JOptionPane.ERROR_MESSAGE);
                return null;
            }

            GameLevel level = null;
            if (line.equals("LevelOne")){
                level = new LevelOne("no");
            } else if (line.equals("LevelTwo")){
                level = new LevelTwo("no");
            } else if (line.equals("LevelThree")){
                level = new LevelThree("no");
            } else {
                JOptionPane.showMessageDialog(game.getMainMenu().getMainPanel(), "This file does not contain a saved level", "Level not found", JOptionPane.ERROR_MESSAGE);
                return null;
            }

            line = reader.readLine();

            if (line == null){
                JOptionPane.showMessageDialog(game.getMainMenu().getMainPanel(), "This file does not contain a saved level", "Level not found", JOptionPane.ERROR_MESSAGE);
                return null;
            }

            while (line != null) {

                String[] tokens = line.split(",");

                if (tokens[0].equals("Bomb")){
                    Bomb bomb = new Bomb(level);
                    bomb.setPosition(new Vec2(Float.parseFloat(tokens[1]), Float.parseFloat(tokens[2])));
                    bomb.setTime(Integer.parseInt(tokens[3]));
                } else if (tokens[0].equals("BombThrower")){
                    BombThrower bombThrower = new BombThrower(level);
                    ((LevelThree)level).getBombThrowers().add(bombThrower);
                    bombThrower.setPosition(new Vec2(Float.parseFloat(tokens[1]), Float.parseFloat(tokens[2])));
                    bombThrower.setHealth(Integer.parseInt(tokens[3]));
                } else if (tokens[0].equals("Character")){
                    level.getCharacter().setPosition(new Vec2(Float.parseFloat(tokens[1]), Float.parseFloat(tokens[2])));
                    level.getCharacter().setHealth(Integer.parseInt(tokens[3]));
                    level.getCharacter().setDirection(tokens[4]);
                    level.getCharacter().setPoints(Integer.parseInt(tokens[5]));
                    level.getCharacter().setSpeed(Float.parseFloat(tokens[6]));
                    level.getCharacter().setChangeGravity(Boolean.parseBoolean(tokens[7]));
                    level.getCharacter().setEnemiesKilled(Integer.parseInt(tokens[8]));
                } else if (tokens[0].equals("Coin")){
                    Coin coin = new Coin(level, tokens[3]);
                    coin.setPosition(new Vec2(Float.parseFloat(tokens[1]), Float.parseFloat(tokens[2])));
                } else if (tokens[0].equals("DoublePlatform")){
                    DoublePlatform doublePlatform;
                    if (tokens[3].equals("null")){
                        doublePlatform = new DoublePlatform(level);
                    } else {
                        doublePlatform = new DoublePlatform(level, tokens[3]);
                    }
                    doublePlatform.setPosition(new Vec2(Float.parseFloat(tokens[1]), Float.parseFloat(tokens[2])));
                    doublePlatform.setTime(Integer.parseInt(tokens[4]));
                } else if (tokens[0].equals("ExplosiveMine")){
                    ExplosiveMine explosiveMine = new ExplosiveMine(level);
                    explosiveMine.setPosition(new Vec2(Float.parseFloat(tokens[1]), Float.parseFloat(tokens[2])));
                } else if (tokens[0].equals("GroundPlatform")){
                    GroundPlatform groundPlatform = new GroundPlatform(level);
                    groundPlatform.setPosition(new Vec2(Float.parseFloat(tokens[1]), Float.parseFloat(tokens[2])));
                } else if (tokens[0].equals("HealthPotion")){
                    HealthPotion healthPotion = new HealthPotion(level, tokens[3]);
                    healthPotion.setPosition(new Vec2(Float.parseFloat(tokens[1]), Float.parseFloat(tokens[2])));
                } else if (tokens[0].equals("MinusCoin")){
                    MinusCoin minusCoin = new MinusCoin(level);
                    minusCoin.setPosition(new Vec2(Float.parseFloat(tokens[1]), Float.parseFloat(tokens[2])));
                } else if (tokens[0].equals("Mummy")){
                    Mummy mummy = new Mummy(level, tokens[5]);
                    ((LevelTwo)level).getMummies().add(mummy);
                    mummy.setPosition(new Vec2(Float.parseFloat(tokens[1]), Float.parseFloat(tokens[2])));
                    mummy.setTime(Integer.parseInt(tokens[6]));
                    mummy.setHealth(Integer.parseInt(tokens[3]));
                    mummy.setDirection(tokens[4]);
                } else if (tokens[0].equals("MummyBoss")){
                    MummyBoss mummyBoss = new MummyBoss(level);
                    ((LevelTwo)level).getMummyBoss().add(mummyBoss);
                    mummyBoss.setPosition(new Vec2(Float.parseFloat(tokens[1]), Float.parseFloat(tokens[2])));
                    mummyBoss.setTime(Integer.parseInt(tokens[5]));
                    mummyBoss.setHealth(Integer.parseInt(tokens[3]));
                    mummyBoss.setDirection(tokens[4]);
                } else if (tokens[0].equals("Ninja")){
                    Ninja ninja = new Ninja(level);
                    ((LevelOne)level).getNinja().add(ninja);
                    ninja.setPosition(new Vec2(Float.parseFloat(tokens[1]), Float.parseFloat(tokens[2])));
                    ninja.setTime(Integer.parseInt(tokens[5]));
                    ninja.setHealth(Integer.parseInt(tokens[3]));
                    ninja.setDirection(tokens[4]);
                } else if (tokens[0].equals("NinjaBoss")){
                    NinjaBoss ninjaBoss = new NinjaBoss(level);
                    ((LevelOne)level).getNinjaBoss().add(ninjaBoss);
                    ninjaBoss.setPosition(new Vec2(Float.parseFloat(tokens[1]), Float.parseFloat(tokens[2])));
                    ninjaBoss.setTime(Integer.parseInt(tokens[5]));
                    ninjaBoss.setHealth(Integer.parseInt(tokens[3]));
                    ninjaBoss.setDirection(tokens[4]);
                } else if (tokens[0].equals("PoisonProjectile")){
                    PoisonProjectile poisonProjectile = new PoisonProjectile(level);
                    poisonProjectile.setPosition(new Vec2(Float.parseFloat(tokens[1]), Float.parseFloat(tokens[2])));
                    poisonProjectile.setTime(Integer.parseInt(tokens[3]));
                    PoisonProjectileImpact poisonProjectileImpact = new PoisonProjectileImpact(poisonProjectile);
                    poisonProjectile.addCollisionListener(poisonProjectileImpact);
                } else if (tokens[0].equals("Portal")){
                    Portal portal;
                    if (tokens[3].equals("null") && tokens[4].equals("null")){
                        level.getPortal().setPosition(new Vec2(Float.parseFloat(tokens[1]), Float.parseFloat(tokens[2])));
                    } else {
                        portal = new Portal(level, tokens[3], tokens[4]);
                        portal.setPosition(new Vec2(Float.parseFloat(tokens[1]), Float.parseFloat(tokens[2])));
                    }

                } else if (tokens[0].equals("Projectile")){
                    Projectile projectile = new Projectile(level);
                    projectile.setPosition(new Vec2(Float.parseFloat(tokens[1]), Float.parseFloat(tokens[2])));
                    projectile.setTime(Integer.parseInt(tokens[3]));
                } else if (tokens[0].equals("Shuriken")){
                    Shuriken shuriken = new Shuriken(level);
                    shuriken.setPosition(new Vec2(Float.parseFloat(tokens[1]), Float.parseFloat(tokens[2])));
                    ShurikenImpact shurikenImpact = new ShurikenImpact(shuriken);
                    shuriken.addCollisionListener(shurikenImpact);
                } else if (tokens[0].equals("SinglePlatform")){
                    SinglePlatform singlePlatform;
                    if (tokens[3].equals("null")){
                        singlePlatform = new SinglePlatform(level);
                    } else {
                        singlePlatform = new SinglePlatform(level, tokens[3]);
                    }
                    singlePlatform.setPosition(new Vec2(Float.parseFloat(tokens[1]), Float.parseFloat(tokens[2])));
                    singlePlatform.setTime1(Integer.parseInt(tokens[4]));
                    singlePlatform.setTime2(Integer.parseInt(tokens[5]));
                } else if (tokens[0].equals("SpeedPotion")){
                    SpeedPotion speedPotion = new SpeedPotion(level, tokens[3]);
                    speedPotion.setPosition(new Vec2(Float.parseFloat(tokens[1]), Float.parseFloat(tokens[2])));
                } else if (tokens[0].equals("WallPlatform")){
                    WallPlatform wallPlatform = new WallPlatform(level);
                    wallPlatform.setPosition(new Vec2(Float.parseFloat(tokens[1]), Float.parseFloat(tokens[2])));
                } else {
                    JOptionPane.showMessageDialog(game.getMainMenu().getMainPanel(), "This file does not contain a saved level", "Level not found", JOptionPane.ERROR_MESSAGE);
                    return null;
                }

                line = reader.readLine();
            }
            return level;
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
