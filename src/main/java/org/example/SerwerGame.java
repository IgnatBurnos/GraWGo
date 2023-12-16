package org.example;

public class SerwerGame {
    GameBoard gameBoard = new GameBoard();
    private Player player1;
    private Player player2;

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
