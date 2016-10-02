package com.example.mdthai.tictactoe;

/**
 * Enum representing board of the Tic Tac Toe game.
 *
 * @author Thai-Vu Nguyen and Seaim Khan
 * @version 22/09/2016
 * @since 1.8
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
