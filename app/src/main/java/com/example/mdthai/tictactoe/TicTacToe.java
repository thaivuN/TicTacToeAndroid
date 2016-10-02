package com.example.mdthai.tictactoe;

/**
 * Interface for the TicTacToe game logic.
 *
 * @author Thai-Vu Nguyen and Seaim Khan
 * @version 22/09/2016
 * @since 1.8
 */
public interface TicTacToe {

    /**
     * Handles the human player's move, and checks if move is decisive. Works for both players.
     *
     * @param square Square
     * @return a Winner enum that tells if there is a victor or not
     */
    public Winner makeAMove(Square square);


    /**
     * Returns a boolean value representing a player's turn.
     * True for Player 1, False for Player 2.
     *
     * @return boolean A boolean value.
     */
    public boolean getTurn();

    /**
     * Sets the turn of the players.
     *
     * Set to TRUE to switch to PLAYER 1
     * Set to FALSE to switch to PLAYER 2
     *
     * @param turn boolean representing a player's turn.
     */
    public void setTurn(boolean turn);

    /**
     * Returns the board array.
     *
     * @return The board represented as an int[].
     */
    public int[] getBoard();

    /**
     * Sets the board of the game.
     *
     * @param board int[] representation of a board.
     */
    public void setBoard(int [] board);

    /**
     * Checks if the game is in AI Mode.
     * True if PLAYER VS AI, False if PLAYER VS PLAYER.
     *
     * @return boolean A boolean value.
     */
    public boolean getAIMode();

    /**
     * Sets the mode of the game.
     * Set to TRUE for PLAYER VS AI mode
     * Set to FALSE for PLAYER VS PLAYER mode
     *
     * @param aiMode Boolean representation of a game mode.
     */
    public void setAIMode (boolean aiMode);

    /**
     * Returns the AI's next move.
     *
     * @return The next AI move.
     */
    public Square getAINextPosition();
}
