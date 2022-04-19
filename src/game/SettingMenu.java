package game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.MouseAdapter;

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

    private Game game;

    public SettingMenu(Game g){
        this.game = g;

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.transitionToInGameMenu();
            }
        });


        VolumeSelector.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = VolumeSelector.getSelectedIndex();
                muteVolumeCheckBox.setSelected(false);
                switch (i) {
                    case 0:
                        if (game.getMainMenuVisible()){
                            game.getBgMusic().resume();
                            game.getBgMusic().setVolume(2);
                        } else {
                            game.getLevel().getBackgroundMusic().resume();
                            game.getLevel().getBackgroundMusic().setVolume(2);
                        }
                        break;

                    case 1:
                        if (game.getMainMenuVisible()){
                            game.getBgMusic().resume();
                            game.getBgMusic().setVolume(1.5);
                        } else {
                            game.getLevel().getBackgroundMusic().resume();
                            game.getLevel().getBackgroundMusic().setVolume(1.5);
                        }
                        break;
                    case 2:
                        if (game.getMainMenuVisible()){
                            game.getBgMusic().resume();
                            game.getBgMusic().setVolume(1);
                        } else {
                            game.getLevel().getBackgroundMusic().resume();
                            game.getLevel().getBackgroundMusic().setVolume(1);
                        }
                        break;
                    case 3:
                        if (game.getMainMenuVisible()){
                            game.getBgMusic().resume();
                            game.getBgMusic().setVolume(0.5);
                        } else {
                            game.getLevel().getBackgroundMusic().resume();
                            game.getLevel().getBackgroundMusic().setVolume(0.5);
                        }
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + i);
                }


            }
        });

        muteVolumeCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean muted = muteVolumeCheckBox.isSelected();

                if (muted){
                    if (game.getMainMenuVisible()){
                        game.getBgMusic().stop();
                    } else {
                        game.getLevel().getBackgroundMusic().pause();
                    }
                } else {
                    if (game.getMainMenuVisible()){
                        game.getBgMusic().resume();
                        game.getBgMusic().setVolume(0.5);
                    } else {
                        game.getLevel().getBackgroundMusic().resume();
                        game.getLevel().getBackgroundMusic().setVolume(0.5);
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
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
