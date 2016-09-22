package com.example.mdthai.tictactoe;

/**
 * Enum resenting board of the Tic Tac Toe game
 *
 * Created by MDThai on 9/22/2016.
 */
public enum Square {
    ONE(0), TWO(1), THREE(2), FOUR(3), FIVE(4), SIX(5), SEVEN(6), EIGHT(7), NINE(8);

    private int value;

    private Square(int value)
    {
        this.value = value;
    }

    public int getValue(){
        return value;
    }

}
