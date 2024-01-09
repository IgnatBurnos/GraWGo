package org.example;

import javafx.scene.layout.GridPane;

import java.util.ArrayList;


/**
 * this class connects GuiField with an actuall GUI and provides connection between gui and logic (Gamebord)
 * this is ultimate class for game bord
 */
public class GuiBoard extends GridPane {

    private int size;

    /**
     * @// TODO: 09.01.2024
     * trzeba tu zrobić jakąś logike która zarządza playerami, nie mam pomysłu so far ale coś się ogarnie
     */
    private int player = 1;

    private GameBoard gameBoard = new GameBoard();

    public GuiBoard(int size, int size_of_square) {
        this.size = size;
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                GuiField field = new GuiField(x, y, this, size_of_square);
                add(field, x, y);
            }
        }
        gameBoard.createMap(size, size);
    }


    /**
     * @Todo
     * sprawdzić czy użytkownik może w ogole to kolko dodac - jesli tak to zwracamy prawde, jak nie to falsz
     * @param x
     * @param y
     */
    public boolean clickOnGuiField(int x, int y) {
        return true;
    }



}
