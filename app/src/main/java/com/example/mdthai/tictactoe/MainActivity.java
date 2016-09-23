package com.example.mdthai.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TicTacToe tttGame;
    private int pOneCounter;
    private int pTwoCounter;
    private int tieCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tttGame = new TicTacToeGameState();


    }

    @Override
    protected void onStart(){
        super.onStart();

        TextView tv = (TextView) findViewById(R.id.desc);
        ImageButton button = (ImageButton) findViewById(R.id.box1);



    }

    public void clickImages(View view)
    {
        ImageButton clickedBtn = (ImageButton) view;
        Square block = resolveButton(clickedBtn);
        if (block != null) {
            Winner result = tttGame.makeAMove(block);
            //TO DO: CHANGE IMAGE SRC

            //DISABLE button
            clickedBtn.setEnabled(false);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState)
    {
        savedInstanceState.putIntArray("board", tttGame.getBoard());
        savedInstanceState.putBoolean("turn", tttGame.getTurn());
        savedInstanceState.putBoolean("mode", tttGame.getAIMode());

    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);

        tttGame = new TicTacToeGameState();
        tttGame.setBoard(savedInstanceState.getIntArray("board"));
        tttGame.setTurn(savedInstanceState.getBoolean("turn"));
        tttGame.setAIMode(savedInstanceState.getBoolean("mode"));

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


}
