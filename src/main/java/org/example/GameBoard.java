package org.example;

import java.util.ArrayList;

public class GameBoard {
    // 0 - no player, 1 - player1, 2 - player 2
    private ArrayList<ArrayList<SingleFiled>> gameMap = new ArrayList<>();
    private int mapHeight = 0;
    private int mapWidth = 0;

    private Player currentPlayer;

    public void createMap(int height, int width) {
        mapHeight = height;
        mapWidth = width;
        for (int i = 0; i < height; i++) {
            ArrayList<SingleFiled> map_line = new ArrayList<>();
            for (int j = 0; j < width; j++) {
                SingleFiled field = new SingleFiled(i, j);
                map_line.add(field);
            }
            gameMap.add(map_line);
        }
    }


    public ArrayList<SingleFiled> getSurroundings(int x, int y) {
        ArrayList<SingleFiled> surroundings = new ArrayList<>();

        if (x != 0) {
            surroundings.add(gameMap.get(x-1).get(y));
        }
        if (x != mapHeight - 1) {
            surroundings.add(gameMap.get(x+1).get(y));
        }
        if (y != 0) {
            surroundings.add(gameMap.get(x).get(y-1));
        }
        if (y != mapWidth - 1) {
            surroundings.add(gameMap.get(x).get(y + 1));
        }
        return surroundings;
    }

    public boolean isTaken(int x, int y) {
        return gameMap.get(x).get(y).isTaken();
    }

    public boolean isAbleToPlaceStone(int x, int y) {
        if (isTaken(x,y)) {
            return false;
        }
        /**
         * @Todo
         * trzeba jeszcze wcześniej sprawdzić czy ruch taki nie powoduje że dusimy wszystkie kamienie przeciwnika,
         * jeśli tak to należałoby zwrócić true;
         */
        if (getNumberOfBreaths(x, y, this.currentPlayer) == 0) {
            return false;
        }
        return true;



    }



    private ArrayList<SingleFiled> fundValidSurandignsforBreaths(int x, int y, int player_id, ArrayList<SingleFiled> surroundings) {
        ArrayList<SingleFiled> localSurandings = getSurroundings(x, y);
        for (SingleFiled sur : surroundings) {
            if (sur.get_player_id() == player_id) {
                for (SingleFiled localSur : localSurandings) {
                    surroundings = fundValidSurandignsforBreaths(localSur.getX(), localSur.getY(), player_id, surroundings);
                }
            } else if (!isTaken(sur.getX(),sur.getY())) {
                surroundings.add(sur);
            }
        }
        return surroundings;
    }


    public int getNumberOfBreaths(int x, int y, Player player) {
        this.currentPlayer = player;
        int player_id = player.getId();
        ArrayList<SingleFiled> surr = new ArrayList<SingleFiled>();
        ArrayList<SingleFiled> surroundings = fundValidSurandignsforBreaths(x, y, player_id, surr);
        return surroundings.size();
    }




    public void set_player(Player player) {
        this.currentPlayer = player;
    }

}
