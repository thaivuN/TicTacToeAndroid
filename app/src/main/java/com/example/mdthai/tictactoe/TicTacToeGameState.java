package com.example.mdthai.tictactoe;

import java.io.Serializable;

/**
 * Created by MDThai on 9/22/2016.
 */
public class TicTacToeGameState implements TicTacToe {


    //True for player 1
    //False for player 2
    private boolean turn;

    private int []board;

    private boolean isAIMode;

    public TicTacToeGameState(){

        this.board = new int[9];
        this.turn = true;
        //By default, no AI mode
        this.isAIMode = false;

    }

    public TicTacToeGameState(boolean isAIMode)
    {
        this.board = new int[9];
        this.turn = true;
        this.isAIMode = isAIMode;
    }

    public Winner makeAMove (Square square)
    {
            //Making sure the move is possible
            if (board[square.getValue()] == 0) {

                //Check for Player 1 turn
                if(getTurn() == true)
                    board[square.getValue()] = 1;
                else{
                    //At this point, it is player 2 turn

                    //Check for AI MODE
                    if (isAIMode){
                        //Make random move
                        board[getAINextPosition()] = 2;
                    }
                    else
                    {
                        //Make human player 2 move
                        board[square.getValue()] = 2;
                    }
                }


                setTurn(!getTurn());
            }

            //To DO

            return null;

    }

    public boolean getTurn(){
        return turn;
    }

    public void setTurn(boolean turn){
        this.turn = turn;
    }

    public int[] getBoard()
    {
        return board;
    }

    public void setBoard(int [] board)
    {
        this.board = board;
    }

    public boolean getMode()
    {
        return isAIMode;
    }

    public void setAIMode(boolean aiMode)
    {
        this.isAIMode = aiMode;
    }



    private int getAINextPosition(){
        return 0;
    }


}
