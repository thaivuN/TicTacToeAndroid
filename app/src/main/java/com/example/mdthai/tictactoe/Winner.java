package com.example.mdthai.tictactoe;

/**
 * Created by MDThai on 9/22/2016.
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
