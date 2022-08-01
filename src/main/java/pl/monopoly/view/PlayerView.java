package pl.monopoly.view;

import pl.monopoly.logic.Player;

import javax.swing.*;
import java.awt.*;

public class PlayerView {
    private Player player;

    // create
    public PlayerView(Player player) {

        this.player = player;

    }

    public void render(Graphics graphics) {

        int distance1=0, distance2=0, normalField = 73, bigFieldAddition = 15;

        if (player.getFieldNumber() <= 10) {

            distance1 = - normalField * player.getFieldNumber();

        } else if (player.getFieldNumber() > 10 && player.getFieldNumber() <= 20) {

            distance1 = - normalField * 10;
            distance2 = - normalField * (player.getFieldNumber() - 10);

        } else if (player.getFieldNumber() > 20 && player.getFieldNumber() <= 30) {

            distance1 = -normalField * 10 + normalField * (player.getFieldNumber() - 20);
            distance2 = -normalField * 10;

        } else if (player.getFieldNumber() > 30) {

            distance2 = -normalField * 10 + normalField * (player.getFieldNumber() - 30);

        }

        if (player.getFieldNumber() > 0) {distance1 -= bigFieldAddition;} //todo refactoring
        if (player.getFieldNumber() >= 10) {distance1 -= bigFieldAddition;}
        if (player.getFieldNumber() > 10) {distance2 -= bigFieldAddition;}
        if (player.getFieldNumber() >= 20) {distance2 -= bigFieldAddition;}
        if (player.getFieldNumber() > 20) {distance1 += bigFieldAddition;}
        if (player.getFieldNumber() >= 30) {distance1 += bigFieldAddition;}
        if (player.getFieldNumber() > 30) {distance2 += bigFieldAddition;}

        new ImageIcon("");
        ImageIcon playerIcon = switch (player.getId()) {
            case 0 -> new ImageIcon("src\\main\\java\\pl\\monopoly\\images\\playersImages\\red.png");
            case 1 -> new ImageIcon("src\\main\\java\\pl\\monopoly\\images\\playersImages\\blue.png");
            case 2 -> new ImageIcon("src\\main\\java\\pl\\monopoly\\images\\playersImages\\green.png");
            case 3 -> new ImageIcon("src\\main\\java\\pl\\monopoly\\images\\playersImages\\purple.png");
            default -> new ImageIcon();
        };
        graphics.drawImage(playerIcon.getImage(), 790+10*player.getId() + distance1, 790+10*player.getId() + distance2, 50, 50, null);
        graphics.setFont(new Font(Font.SANS_SERIF,  Font.BOLD, 30));
        graphics.setColor(Color.GREEN);
        graphics.drawString(player.getMoney()+"", 790+10*player.getId() + distance1, 790+10*player.getId() + distance2);

    }

}
