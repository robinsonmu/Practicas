package com.prodigious.deliverySystem.drons;

import com.prodigious.deliverySystem.drons.utils.CardinalPoint;

public class Dron {

    private int x;

    private int y;

    public void move(CardinalPoint direction){
        switch(direction){
            case EAST:
                x++;
                break;
            case WEST:
                x--;
                break;
            case NORTH:
                y++;
                break;
            case SOUTH:
                y--;
                break;
        }
    }
}
