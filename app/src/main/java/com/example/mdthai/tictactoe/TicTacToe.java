package com.example.mdthai.tictactoe;

/**
 * Interface for the TicTacToe game logic
 *
 * Created by MDThai on 9/22/2016.
 */
public interface TicTacToe {

    /**
     *
     * @param square Square
     * @return a Winner enum that tells if there is a victor or not
     */
    public Winner makeAMove(Square square);

    /**
     * Returns a boolean value.
     * True for Player 1
     * False for Player 2
     *
     * @return boolean
     */
    public boolean getTurn();

    /**
     * Sets the turn of the Players
     * Set to TRUE to switch to PLAYER 1
     * Set to FALSE to switch to PLAYER 2
     *
     * @param turn boolean
     */
    public void setTurn(boolean turn);

    /**
     * Returns the board array
     * @return the board represented as an int[]
     */
    public int[] getBoard();

    /**
     * Sets the board of the game
     *
     * @param board int[]
     */
    public void setBoard(int [] board);

    /**
     * Checks if the game is in AI Mode
     * TRUE for PLAYER VS AI is on
     * False for PLAYER VS PLAYER
     *
     * @return boolean
     */
    public boolean getAIMode();

    /**
     * Sets the mode of the game
     * set to TRUE for PLAYER vs AI MODE
     * set to FALSE for PLAYER vs PLAYER MODE
     *
     * @param aiMode
     */
    public void setAIMode (boolean aiMode);

    /**
     * Returns the AI's next move
     * @return return the next move of the AI
     */
    public Square getAINextPosition();
}
