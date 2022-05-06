package game;

import city.cs.engine.BodyImage;
import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;
import org.jbox2d.common.Vec2;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//Class containing commands to move character in response to key events
public class CharacterController implements KeyListener, StepListener {

    private Character character;
    private int time, delay;
    private Boolean canShoot;
    private Game game;

    public CharacterController(Game game, Character character) {
        this.character = character;
        this.time = 0;
        this.delay = 30;
        this.canShoot = Boolean.FALSE;
        this.game = game;
        character.getWorld().addStepListener(this);
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public void updateCharacter(Character character) {
        this.character = character;
        character.getWorld().addStepListener(this);
    }

    public void setCanShoot(Boolean canShoot) {
        this.canShoot = canShoot;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (character.isAlive()){

            //move with WASD or arrows
            if (code == KeyEvent.VK_LEFT || code == KeyEvent.VK_A) {
                character.startWalking(-character.getSpeed());
            } else if (code == KeyEvent.VK_RIGHT || code == KeyEvent.VK_D) {
                character.startWalking(character.getSpeed());
            } else if (code == KeyEvent.VK_UP || code == KeyEvent.VK_W){
                if (character.getGravityScale() > 0){
                    character.jump(15);
                } else {
                    character.jump(-15);
                }

            //shoot with C or K
            } else if (code == KeyEvent.VK_C || code == KeyEvent.VK_K ){
                if (character.getWorld() instanceof LevelOne){
                    character.shoot();
                } else if (character.getWorld() instanceof LevelTwo){
                    if (canShoot == Boolean.TRUE){
                        character.shoot();
                    }
                }

            //change gravity with Spacebar
            } else if (code == KeyEvent.VK_SPACE){
                    if (character.getChangeGravity() == Boolean.TRUE){
                        character.jump(0);
                        character.setGravityScale(-character.getGravityScale());
                    }

            //open in game menu with Esc
            } else if (code == KeyEvent.VK_ESCAPE){
                game.toggleMenu();
            }
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (character.isAlive()){
            if (code == KeyEvent.VK_LEFT || code == KeyEvent.VK_A) {
                character.stopWalking();
            } else if (code == KeyEvent.VK_RIGHT || code == KeyEvent.VK_D) {
                character.stopWalking();
            } else if (code == KeyEvent.VK_UP || code == KeyEvent.VK_W){
                character.stopWalking();
            } else if (code == KeyEvent.VK_SPACE){
                if (character.getChangeGravity() == Boolean.TRUE){
                    character.stopWalking();
                }
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    //add delay to character shooting
    @Override
    public void preStep(StepEvent stepEvent) {
        if (character.getWorld() instanceof LevelTwo){
            if (time % 2 == 0){
                setCanShoot(Boolean.TRUE);
            } else {
                setCanShoot(Boolean.FALSE);
            }
        } else if (character.getWorld() instanceof LevelThree){
            if (time > delay){
                setTime(0);
                character.shoot();
            }
        }

        setTime(getTime() + 1);
    }

    @Override
    public void postStep(StepEvent stepEvent) {

    }
}