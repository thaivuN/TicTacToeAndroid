package com.example.mdthai.tictactoe;

import org.junit.Before;
import org.junit.Test;


import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */

public class TicTacToeTest {

    private TicTacToe ttt;

    public TicTacToeTest(){}

    @Before
    public void setUp(){
        ttt = new TicTacToeGameState();
    }

    @Test
    public void testWinCase1(){
        //Say X = Player 1, O = Player 2, - = Empty
        //X - X
        //O - 0
        //X - O
        int[] board = new int[]{1,0,1,2,0,2,1,0,2};

        ttt.setBoard(board);

        Winner win = ttt.makeAMove(Square.TWO);
        assertEquals(Winner.P_ONE, win);
    }

    @Test
    public void testLoseCase1(){
        //Say X = Player 1, O = Player 2, - = Empty
        //X - X
        //O - 0
        //X - O
        int[] board = new int[]{1,0,1,2,0,2,1,0,2};

        ttt.setBoard(board);

        ttt.setTurn(true);

        //Cursor now on to Player 1
        //Make player 1 do a non-winnable move to Square 8
        Winner player1move = ttt.makeAMove(Square.EIGHT);
        if(player1move.getValue() != Winner.NONE.getValue())
            fail();
        //Cursor now on to Player 2
        Winner win = ttt.makeAMove(Square.FIVE);
        assertEquals(Winner.P_TWO, win);
    }

    @Test
    public void testTieCase1(){
        //Say X = Player 1, O = Player 2, - = Empty
        // 0 X O
        // 0 X X
        // X 0 -
        int[] board = new int[]{2,1,2,2,1,1,1,2,0};

        ttt.setBoard(board);



        //Cursor on to Player 1

        //Make tie
        Winner win = ttt.makeAMove(Square.NINE);
        assertEquals(Winner.TIE, win);

    }

}