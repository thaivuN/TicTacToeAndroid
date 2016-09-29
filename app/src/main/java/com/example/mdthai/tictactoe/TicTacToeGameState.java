package com.example.mdthai.tictactoe;

import java.io.Serializable;

/**
 * Created by Thai-Vu Nguyen and Seaim Khan on 9/22/2016.
 */
public class TicTacToeGameState implements TicTacToe {


    //True for player 1
    //False for player 2
    private boolean turn;

    private int[] board;

    private boolean isAIMode;

    public TicTacToeGameState() {

        this.board = new int[9];
        this.turn = true;
        //By default, no AI mode
        this.isAIMode = false;

    }

    public TicTacToeGameState(boolean isAIMode) {
        this.board = new int[9];
        this.turn = true;
        this.isAIMode = isAIMode;
    }

    public Winner makeAMove(Square square) {
        //Making sure the move is possible
        if (board[square.getValue()] == 0) {

            //Check for Player 1 turn
            if (getTurn() == true)
                board[square.getValue()] = 1;
            else {
                //At this point, it is player 2 turn

                    board[square.getValue()] = 2;

            }

            Winner win = checkWin();
            setTurn(!getTurn());

            return win;
        }
        else

        return null;

    }

    public boolean getTurn() {
        return turn;
    }

    public void setTurn(boolean turn) {
        this.turn = turn;
    }

    public int[] getBoard() {
        return board;
    }

    public void setBoard(int[] board) {
        this.board = board;
    }

    public boolean getAIMode() {
        return isAIMode;
    }

    public void setAIMode(boolean aiMode) {
        this.isAIMode = aiMode;
    }


    public Square getAINextPosition() {

        //Making sure this doesn't accidentally run into an eternal loop
        if (findZeros() == false)
            return null;

        int rand;
        do {
            rand = (int) (Math.random() * 9);
        }while (board[rand] != 0);


        return resolveSquare(rand);

    }

    private Square resolveSquare(int i){
        switch (i) {
            case 0:
                return Square.ONE;
            case 1:
                return Square.TWO;
            case 2:
                return Square.THREE;
            case 3:
                return Square.FOUR;
            case 4:
                return Square.FIVE;
            case 5:
                return Square.SIX;
            case 6:
                return Square.SEVEN;
            case 7:
                return Square.EIGHT;
            case 8:
                return Square.NINE;
            default:
                throw new IllegalArgumentException
                        ("UNEXPECTED RESULT in resolveSquare(int i)");
        }



    }

    private Winner checkWin(){
        Winner winner = Winner.NONE;

        String cond;

        if (turn == true)
            cond = "111";
        else
            cond = "222";

        //Check for WIN
        String row1 = board[0] + "" + board[1] + "" + board[2];
        String row2 = board[3] + "" + board[4] + "" + board[5];
        String row3 = board[6] + "" + board[7] + "" + board[8];

        String col1 = board[0] + "" + board[3] + "" + board[6];
        String col2 = board[1] + "" + board[4] + "" + board[7];
        String col3 = board[2] + "" + board[5] + "" + board[8];

        String dia1 = board[0] + "" + board[4] + "" + board[8];
        String dia2 = board[2] + "" + board[4] + "" + board[6];

        if (row1.equals(cond) || row2.equals(cond) || row3.equals(cond)
                ||col1.equals(cond) || col2.equals(cond) || col3.equals(cond)
                ||dia1.equals(cond) || dia2.equals(cond)){

            //There is a win
            if (turn == true)
                winner = Winner.P_ONE;
            else
                winner = Winner.P_TWO;

        }


        //Check for TIE if still no Winner
        if (winner.getValue() == Winner.NONE.getValue()) {


            //If no 0 value left in the board array, game is a tie
            if (findZeros() == false)
                winner = Winner.TIE;
        }

        //Return the Winner state
        return winner;
    }

    private boolean findZeros()
    {
        boolean hasZerosLeft = false;
        for (int i = 0; i < board.length && hasZerosLeft == false;i++)
        {
            if (board[i] == 0)
                hasZerosLeft = true;
        }

        return hasZerosLeft;

    }


}
