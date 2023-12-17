package org.example;
import java.io.Serializable;
public class SerwerGame implements Serializable{
    GameBoard gameBoard = new GameBoard();
    private Player player1;
    private Player player2;

    private boolean continueGame = true;

    public void setcontinueGame(boolean do_cont) {
        continueGame = do_cont;
        if (!do_cont) {
            player1.set_contiune_game(false);
            player2.set_contiune_game(false);
        }
    }

    private void check_players_to_continue_game() {
        if (!player1.get_contiune_game() || !player2.get_contiune_game()) {
            continueGame = false;
        }
    }
    public boolean getContinueGame() {
        check_players_to_continue_game();
        return continueGame;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public void startGame(int map_hight, int map_width) {
        gameBoard.createMap(map_hight, map_width);
        player1.setYour_tour(true);

    }
}
