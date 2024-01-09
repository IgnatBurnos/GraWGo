package org.example;

import java.util.ArrayList;

public class GameBoard {
    // 0 - no player, 1 - player1, 2 - player 2
    private ArrayList<ArrayList<Integer>> gameMap = new ArrayList<>();
    private int mapHeight = 0;
    private int mapWidth = 0;



    public void createMap(int height, int width) {
        mapHeight = height;
        mapWidth = width;
        for (int i = 0; i < height; i++) {
            ArrayList<Integer> map_line = new ArrayList<>();
            for (int j = 0; j < width; j++) {
                map_line.add(0);
            }
            gameMap.add(map_line);
        }
    }

    public void newStone(int player, int height, int width) {
        gameMap.get(height).set(width, player);
    }

    public void removeFromMap(int height, int width) {
        gameMap.get(height).set(width, 0);
    }

    public ArrayList<Integer> getSurroundings(int height, int widht) {
        ArrayList<Integer> surroundings = new ArrayList<>();

        if (height != 0) {
            surroundings.add(gameMap.get(height-1).get(widht));
        }
        if (height != mapHeight - 1) {
            surroundings.add(gameMap.get(height+1).get(widht));
        }
        if (widht != 0) {
            surroundings.add(gameMap.get(height).get(widht-1));
        }
        if (widht != mapWidth - 1) {
            surroundings.add(gameMap.get(height).get(widht + 1));
        }
        return surroundings;
    }

    public boolean isTaken(int height, int width) {
        return gameMap.get(height).get(width) != 0;
    }


}
