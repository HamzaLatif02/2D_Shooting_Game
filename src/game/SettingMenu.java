package game;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.MouseAdapter;

//show game settings
public class SettingMenu {
    private JPanel mainPanel;
    private JButton backButton;
    private JComboBox VolumeSelector;
    private JCheckBox muteVolumeCheckBox;
    private JLabel settingText;
    private JLabel volumeSelectText;
    private JCheckBox muteSoundEffectsCheckBox;
    private JCheckBox showControlsCheckBox;
    private JCheckBox showObjectivesCheckBox;
    private JPanel backButtonPanel;
    private JPanel controlsPanel;
    private JPanel titlePanel;
    private JSlider volumeSlider;

    private Game game;

    public SettingMenu(Game g){
        this.game = g;

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.transitionToInGameMenu();
            }
        });

        muteVolumeCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean muted = muteVolumeCheckBox.isSelected();

                //if mute volume is ticked then mute volume
                if (muted){
                    if (game.getMainMenuVisible()){
                        game.getBgMusic().stop();
                    } else {
                        game.getLevel().getBackgroundMusic().pause();
                    }
                //when unticked, resume background music
                } else {
                    if (game.getMainMenuVisible()){
                        game.getBgMusic().resume();
                        game.getBgMusic().setVolume((float)volumeSlider.getValue()/50);
                    } else {
                        game.getLevel().getBackgroundMusic().resume();
                        game.getLevel().getBackgroundMusic().setVolume((float)volumeSlider.getValue()/50);
                    }
                }
            }
        });

        muteSoundEffectsCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean muted = muteSoundEffectsCheckBox.isSelected();

                if (muted){
                    game.getLevel().setPlaySoundEffects(Boolean.FALSE);
                } else {
                    game.getLevel().setPlaySoundEffects(Boolean.TRUE);
                }
            }
        });

        //show controls in game view
        showControlsCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean show = showControlsCheckBox.isSelected();

                if (show){
                    game.setShowControls(Boolean.TRUE);
                } else {
                    game.setShowControls(Boolean.FALSE);
                }
            }
        });

        //show objectives in game view
        showObjectivesCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean show = showObjectivesCheckBox.isSelected();

                if (show){
                    game.setShowObjectives(Boolean.TRUE);
                } else {
                    game.setShowObjectives(Boolean.FALSE);
                }
            }
        });

        //slider used to adjust volume
        volumeSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (!volumeSlider.getValueIsAdjusting()){
                    if (game.getMainMenuVisible()){
                        if (muteVolumeCheckBox.isSelected()){
                            muteVolumeCheckBox.setSelected(false);
                            game.getBgMusic().resume();
                        }
                        game.getBgMusic().setVolume((float)volumeSlider.getValue()/50);
                    } else {
                        if (muteVolumeCheckBox.isSelected()){
                            muteVolumeCheckBox.setSelected(false);
                            game.getLevel().getBackgroundMusic().resume();
                        }
                        game.getLevel().getBackgroundMusic().setVolume((float)volumeSlider.getValue()/50);
                    }
                }
            }
        });

    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
