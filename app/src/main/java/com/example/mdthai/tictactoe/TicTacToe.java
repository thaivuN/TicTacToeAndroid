package com.example.mdthai.tictactoe;

/**
 * Created by MDThai on 9/22/2016.
 */
public interface TicTacToe {

    public Winner makeAMove(Square square);
    public boolean getTurn();
    public void setTurn(boolean turn);
    public int[] getBoard();
    public void setBoard(int [] board);
    public boolean getMode();
    public void setAIMode (boolean aiMode);
}
