package com.example.mdthai.tictactoe;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

/**
 * MainActivity handles the UI aspects of the Tic Tac Toe game.
 *
 * @author Thai-Vu Nguyen and Seaim Khan
 * @version 22/09/2016
 * @since 1.8
 */
public class MainActivity extends AppCompatActivity {

    private TicTacToe tttGame;
    private int pOneCounter;
    private int pTwoCounter;
    private int pAICounter;
    private int tieCounter;

    /**
     * onCreate method is called when activity is accessed.
     *
     * @param savedInstanceState A reference to a Bundle object that allows the activity to
     *                           be restored to a previous state using data stored in the bundle.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tttGame = new TicTacToeGameState();

        restorePreferences();
        setDescriptionPlay();

    }


    /**
     * Launches the Help Activity.
     *
     * @param view The View object that contains the activity`s UI elements.
     */
    public void launchHelp(View view){
        Intent intent = new Intent(this, HelpActivity.class);
        startActivity(intent);
    }

    public void launchScore(View view){
        Intent intent = new Intent(this, ScoreActivity.class);

        intent.putExtra("p1Count", pOneCounter);
        intent.putExtra("p2Count", pTwoCounter);
        intent.putExtra("pAICount", pAICounter);
        intent.putExtra("tieCount", tieCounter);

        startActivity(intent);
    }
    /**
     * The image click logic for the Tic Tac Toe game.
     *
     * @param view The View object that contains the activity`s UI elements.
     */
    public void clickImages(View view)
    {
        ImageButton clickedBtn = (ImageButton) view;
        Square block = resolveButton(clickedBtn);
        if (block != null) {
            Winner result = tttGame.makeAMove(block);


            if (tttGame.getTurn() == false) {
                //Player 1 Image
                clickedBtn.setBackgroundResource(R.drawable.x);
            }
            else
            {
                //Player 2 Image
                clickedBtn.setBackgroundResource(R.drawable.o);
            }
            //DISABLE button
            clickedBtn.setEnabled(false);

            if (result == Winner.P_ONE || result == Winner.P_TWO || result == Winner.TIE){
                Toast toast = null;

                if (result == Winner.P_ONE){
                    pOneCounter++;
                    popAToast(R.string.you_win);
                }
                else if (result == Winner.P_TWO)
                {
                    pTwoCounter++;
                    popAToast(R.string.he_win);
                }
                else{
                    tieCounter++;
                    popAToast(R.string.tie_win);
                }

                disableBtn();
                savePreferences();

            }
            else
            {
                if(tttGame.getAIMode())
                {

                    Square aiMove = tttGame.getAINextPosition();

                    Winner aiWin = tttGame.makeAMove(aiMove);
                    ImageButton aiBtn = (ImageButton) findViewById(findIDbySquare(aiMove));

                    aiBtn.setBackgroundResource(R.drawable.o);
                    aiBtn.setEnabled(false);

                    if (aiWin == Winner.P_TWO || aiWin == Winner.TIE){
                        Toast toast = null;
                        if(aiWin == Winner.P_TWO) {
                            pAICounter++;
                            popAToast(R.string.ai_win);

                        }
                        else {
                            popAToast(R.string.tie_win);
                            tieCounter++;
                        }
                        disableBtn();
                        savePreferences();
                    }

                }
            }

        }
    }

    /**
     * Saves data into memory.
     *
     * @param savedInstanceState A reference to a Bundle object that allows the activity to
     *                           be restored to a previous state using data stored in the bundle.
     */
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState)
    {
        savedInstanceState.putIntArray("board", tttGame.getBoard());
        savedInstanceState.putBoolean("turn", tttGame.getTurn());
        savedInstanceState.putBoolean("mode", tttGame.getAIMode());

        savedInstanceState.putInt("p1Count", pOneCounter);
        savedInstanceState.putInt("p2Count", pTwoCounter);
        savedInstanceState.putInt("pAICount",pAICounter);
        savedInstanceState.putInt("tieCount", tieCounter);

        boolean[] enabled = getState();
        savedInstanceState.putBooleanArray("state", enabled);
    }

    /**
     * Reads and restores from memory.
     *
     * @param savedInstanceState A reference to a Bundle object that allows the activity to
     *                           be restored to a previous state using data stored in the bundle.
     */
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);

        tttGame = new TicTacToeGameState();
        tttGame.setBoard(savedInstanceState.getIntArray("board"));
        tttGame.setTurn(savedInstanceState.getBoolean("turn"));
        tttGame.setAIMode(savedInstanceState.getBoolean("mode"));

        pOneCounter = savedInstanceState.getInt("p1Count");
        pTwoCounter = savedInstanceState.getInt("p2Count");
        pAICounter = savedInstanceState.getInt("pAICount");
        tieCounter = savedInstanceState.getInt("tieCount");

        restoreBoard(savedInstanceState.getIntArray("board"), savedInstanceState.getBooleanArray("state"));
        setDescriptionPlay();



    }

    /**
     * Saves data to SharedPreferences for future use.
     */
    private void savePreferences(){
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        editor.putInt("p1Count", pOneCounter);
        editor.putInt("p2Count", pTwoCounter);
        editor.putInt("pAICount", pAICounter);
        editor.putInt("tieCount", tieCounter);

        editor.commit();
    }

    /**
     * Reads and Loads data from SharedPreferences.
     *
     */
    private void restorePreferences(){
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);

        pOneCounter = prefs.getInt("p1Count",0);
        pTwoCounter = prefs.getInt("p2Count",0);
        pAICounter = prefs.getInt("pAICount",0);
        tieCounter = prefs.getInt("tieCount",0);

    }


    /**
     * Resets the Game.
     *
     * @param view The View object that contains the activity`s UI elements.
     */
    public void resetGame(View view)
    {
        boolean mode = tttGame.getAIMode();
        tttGame = new TicTacToeGameState(mode);
        resetBoard();


    }

    /**
     * Resets the counters.
     *
     * @param view The View object that contains the activity`s UI elements.
     */
    public void zeroCounters(View view)
    {
        tieCounter = 0;
        pTwoCounter = 0;
        pOneCounter =0;
        pAICounter = 0;


        savePreferences();
        popAToast(R.string.zero_text);

    }

    /**
     * Starts a new game and switches the mode of the Game.
     *
     * @param view The View object that contains the activity`s UI elements.
     */
    public void onPlayGame(View view)
    {
        boolean newMode = !tttGame.getAIMode();

        tttGame = new TicTacToeGameState(newMode);
        resetBoard();
        setDescriptionPlay();

    }

    /**
     * Resets the board view
     */
    private void resetBoard(){

        int [] ids = new int[]{
                R.id.box1, R.id.box2, R.id.box3, R.id.box4, R.id.box5, R.id.box6,
                R.id.box7, R.id.box8, R.id.box9
        };

        for (int i = 0; i < ids.length; i++)
        {
            ImageButton btnToDisable = (ImageButton)findViewById(ids[i]);
            btnToDisable.setEnabled(true);
            btnToDisable.setBackgroundResource(R.drawable.tile);
        }



    }

    /**
     * Restore the state of the board
     * @param board
     * @param state
     */
    private void restoreBoard(int[]board, boolean[] state)
    {
        int [] ids = new int[]{
                R.id.box1, R.id.box2, R.id.box3, R.id.box4, R.id.box5, R.id.box6,
                R.id.box7, R.id.box8, R.id.box9
        };

        for (int i = 0; i < board.length; i++)
        {

            ImageButton btn = (ImageButton)findViewById(ids[i]);
            if (board[i] == 1)
            {
                btn.setBackgroundResource(R.drawable.x);

            }
            else if (board[i] == 2)
            {
                btn.setBackgroundResource(R.drawable.o);

            }
            else if(board[i] ==0)
            {

                btn.setBackgroundResource(R.drawable.tile);
            }

            btn.setEnabled(state[i]);
        }


    }

    /**
     * returns the enabled states of the tiles of the board
     * @return array of boolean
     */
    private boolean[] getState(){
        int [] ids = new int[]{
                R.id.box1, R.id.box2, R.id.box3, R.id.box4, R.id.box5, R.id.box6,
                R.id.box7, R.id.box8, R.id.box9
        };

        boolean[] enabled = new boolean[ids.length];

        for (int i = 0; i<ids.length; i++)
        {
            ImageButton btn = (ImageButton)findViewById(ids[i]);
            enabled[i] = btn.isEnabled();
        }

        return enabled;
    }

    /**
     * Disable all ImageButton objects
     */
    private void disableBtn(){
        int [] ids = new int[]{
                R.id.box1, R.id.box2, R.id.box3, R.id.box4, R.id.box5, R.id.box6,
                R.id.box7, R.id.box8, R.id.box9
        };

        for (int i = 0; i < ids.length; i++)
        {
            ImageButton btnToDisable = (ImageButton)findViewById(ids[i]);
            btnToDisable.setEnabled(false);
        }

    }

    private void popAToast(int string_id)
    {
        Toast toast = Toast.makeText(MainActivity.this,getString(string_id), Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    private void setDescriptionPlay(){
        TextView tv = (TextView) findViewById(R.id.desc);

        if (tttGame.getAIMode() == true)
            tv.setText(getString(R.string.descriptAI));
        else
            tv.setText(getString(R.string.descriptPlay));
    }



    /**
     * Returns a square enum
     * @param button ImageButton
     * @return Square enum
     */
    private Square resolveButton (ImageButton button)
    {
        String name = getResources().getResourceEntryName(button.getId());

        switch (name)
        {
            case "box1":
                return Square.ONE;
            case "box2":
                return Square.TWO;
            case "box3":
                return Square.THREE;
            case "box4":
                return Square.FOUR;
            case "box5":
                return Square.FIVE;
            case "box6":
                return Square.SIX;
            case "box7":
                return Square.SEVEN;
            case "box8":
                return Square.EIGHT;
            case "box9":
                return Square.NINE;
            default:
                return null;

        }

    }

    private int findIDbySquare(Square square)
    {
        switch (square.getValue()){
            case 0:
                return R.id.box1;
            case 1:
                return R.id.box2;
            case 2:
                return R.id.box3;
            case 3:
                return R.id.box4;
            case 4:
                return R.id.box5;
            case 5:
                return R.id.box6;
            case 6:
                return R.id.box7;
            case 7:
                return R.id.box8;
            default:
                return R.id.box9;
        }
    }


}
