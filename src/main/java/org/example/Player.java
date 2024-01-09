package org.example;
import java.io.Serializable;
public class Player implements Serializable{

    //this has no mening - just a test thing - DELETE afterwards
    public int licznik_ruchow = 0;
    private boolean your_tour = false;

    private boolean contiune_game = true;

    public void surrender() {
        contiune_game = false;
    }

    public void set_contiune_game(boolean contiune_game) {
        this.contiune_game = contiune_game;
    }

    public boolean get_contiune_game() {
        return contiune_game;
    }


    public void setYour_tour(boolean tour) {
        your_tour = tour;
    }

    public boolean getYour_tour() {
        return your_tour;
    }

    private int playerId;

    public int getId() {
        return playerId;
    }

    public Player(int id) {
        this.playerId = id;
    }
}
