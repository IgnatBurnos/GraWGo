package org.example;

public class Player {

    private int playerid;

    private boolean your_tour = false;

    private boolean is_surrender = false;
    public void surrender() {
        is_surrender = true;
    }

    public boolean get_surrender() {
        return is_surrender;
    }

    public void setYour_tour(boolean tour) {
        your_tour = tour;
    }

    public boolean getYour_tour() {
        return your_tour;
    }
    Player(int playerid) {
        this.playerid = playerid;
    }


}
