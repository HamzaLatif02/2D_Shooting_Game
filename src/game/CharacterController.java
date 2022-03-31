package game;

import city.cs.engine.BodyImage;
import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;
import org.jbox2d.common.Vec2;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class CharacterController implements KeyListener, StepListener {

    //private static final float WALKING_SPEED = 5;
    private Character character;
    private int time;

    public CharacterController(Character character) {
        this.character = character;
        this.time = 0;
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

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        // other key commands omitted
        if (code == KeyEvent.VK_LEFT || code == KeyEvent.VK_A) {
            character.startWalking(-character.getSpeed());
        } else if (code == KeyEvent.VK_RIGHT || code == KeyEvent.VK_D) {
            character.startWalking(character.getSpeed());
        } else if (code == KeyEvent.VK_UP || code == KeyEvent.VK_W){
            character.jump(15f);
        } else if (code == KeyEvent.VK_C || code == KeyEvent.VK_K ){
            if (character.getWorld() instanceof LevelOne){
                character.shoot();
            } else if (character.getWorld() instanceof LevelTwo){
                if (getTime() % 2 == 0){
                    character.shoot();
                }
            }
        } else if (code == KeyEvent.VK_SPACE){
            if (character.getWorld() instanceof LevelThree){
                character.jump(0);
                character.setGravityScale(-character.getGravityScale());
            }

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_LEFT || code == KeyEvent.VK_A) {
            character.stopWalking();
        } else if (code == KeyEvent.VK_RIGHT || code == KeyEvent.VK_D) {
            character.stopWalking();
        } else if (code == KeyEvent.VK_UP || code == KeyEvent.VK_W){
            character.stopWalking();
        } else if (code == KeyEvent.VK_SPACE){
            character.stopWalking();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void preStep(StepEvent stepEvent) {
        setTime(getTime() + 1);
    }

    @Override
    public void postStep(StepEvent stepEvent) {

    }
}