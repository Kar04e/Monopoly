package pl.monopoly.logic;

import pl.monopoly.view.BoardView;
import pl.monopoly.view.Display;

import java.util.LinkedList;
import java.util.List;

public class Game {
    private final Board board = new Board(this);
    private final BoardView boardView = new BoardView();
    private LinkedList<Player> queue;
    public static int playersNumber = 4;

    // methods
    //setup

    public void addPlayers(List<Player> players) {
        queue = new LinkedList<>(players.subList(0,playersNumber));
    }

    public Player actualPlayer() {
        return queue.peek();
    }

    public void interactiveField() {
        board.getField(actualPlayer().getFieldNumber()).action(actualPlayer(), board);
    }

    public void nextRound() {
        Display.refreshScoreBoard();
        Player actual = queue.remove();
        queue.add(actual);
    }

    // get/set
    public BoardView getBoardView() {
        return boardView;
    }

    public boolean playerSingle(Player player) {
        int replays = 0;

        for (Player player1 : queue) {
            if (player.getFieldNumber() == player1.getFieldNumber()) {
                replays++;
            }
        }

        if (replays == 1) {
            return true;
        }
        return false;

    }
}
