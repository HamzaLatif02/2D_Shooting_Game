package game;

import city.cs.engine.BodyImage;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class CharacterController implements KeyListener {

    private static final float WALKING_SPEED = 4;
    private Character character;

    public CharacterController(Character character) {
        this.character = character;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        // other key commands omitted
        if (code == KeyEvent.VK_LEFT || code == KeyEvent.VK_A) {
            character.startWalking(-WALKING_SPEED);
        } else if (code == KeyEvent.VK_RIGHT || code == KeyEvent.VK_D) {
            character.startWalking(WALKING_SPEED);
        } else if (code == KeyEvent.VK_UP || code == KeyEvent.VK_W){
            character.jump(15f);
        } else if (code == KeyEvent.VK_C || code == KeyEvent.VK_K){
            character.shoot();
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
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

}