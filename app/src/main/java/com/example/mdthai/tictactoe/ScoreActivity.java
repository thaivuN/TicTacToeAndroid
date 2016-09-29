package com.example.mdthai.tictactoe;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by MDThai on 9/29/2016.
 */

public class ScoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scoreactivity_main);
    }

    /**
     * Closes the activity
     * @param view
     */
    public void onBtnFinish(View view){
        super.finish();
    }
}
