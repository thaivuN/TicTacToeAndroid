package com.example.mdthai.tictactoe;

/**
 * Enum representing winner of the Tic Tac Toe game.
 *
 * @author Thai-Vu Nguyen and Seaim Khan
 * @version 22/09/2016
 * @since 1.8
 */
public enum Winner {
    NONE(0), P_ONE(1), P_TWO(2), TIE(3);

    private int value;
    private Winner(int value)
    {
        this.value = value;
    }

    public int getValue()
    {
        return value;
    }

}
