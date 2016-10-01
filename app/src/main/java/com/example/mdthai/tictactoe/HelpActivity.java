package com.example.mdthai.tictactoe;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

/**
 * HelpActivity handles the execution and termination of the help activity layout of the game.
 *
 * @author Thai-Vu Nguyen and Seaim Khan
 * @version 29/09/2016
 * @since 1.8
 */
public class HelpActivity extends AppCompatActivity {

    /**
     * onCreate method is called when activity is accessed.
     *
     * @param savedInstanceState A reference to a Bundle object that allows the activity to
     *                           be restored to a previous state using data stored in the bundle.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.helpactivity_main);

        Log.d("Help Activity", "Help Activity Launched");
    }

    /**
     * Event handler for the button that allows user to exit help activity.
     *
     * @param view The View object that contains the activity`s UI elements.
     */
    public void onFinishBtn(View view){
        Log.d("Help Activity", "Finishing Help Activity");
        super.finish();
    }

}
