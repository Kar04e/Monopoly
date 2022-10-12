package pl.monopoly.view;

import javax.swing.*;
import java.awt.*;

public class SettingsButtonView extends CustomButtonView{
    SettingsInGameView settings;

    public SettingsButtonView() {

        super(80, 80, Display.DEFAULT_WIDTH - 200, Display.DEFAULT_HEIGHT - 764);
        settings = new SettingsInGameView();
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawImage(new ImageIcon("src\\main\\java\\pl\\monopoly\\images\\settingsIcon.png").getImage(), positionX, positionY, width, height, null); //todo dynamiczne ścieżki

    }

    @Override
    public void click() {
        SoundPlayer.playSound(Sound.BUTTON_CLICK);
        settings.displaySettings();
    }
}
