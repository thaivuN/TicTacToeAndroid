package com.example.mdthai.tictactoe;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

/**
 * Created by MDThai on 9/29/2016.
 */

public class HelpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.helpactivity_main);

        Log.d("Help Activity", "Help Activity Launched");
    }

    public void onFinishBtn(View view){
        Log.d("Help Activity", "Finishing Help Activity");
        super.finish();
    }

}
