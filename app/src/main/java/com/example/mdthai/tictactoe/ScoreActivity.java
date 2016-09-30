package com.example.mdthai.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by MDThai on 9/29/2016.
 */

public class ScoreActivity extends AppCompatActivity {

    TextView p1View;
    TextView p2View;
    TextView aiView;
    TextView tieView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scoreactivity_main);

        int p1count = 0;
        int p2count = 0;
        int tiecount= 0;
        int aicount = 0;
        Intent i = getIntent();

        if (i.hasExtra("p1Count"))
            p1count = i.getExtras().getInt("p1Count");

        if (i.hasExtra("p2Count"))
            p2count = i.getExtras().getInt("p2Count");

        if(i.hasExtra("pAICount"))
            aicount = i.getExtras().getInt("pAICount");

        if (i.hasExtra("tieCount"))
            tiecount = i.getExtras().getInt("tieCount");

        p1View = (TextView) findViewById(R.id.score_p1_text);
        p2View = (TextView) findViewById(R.id.score_p2_text);
        aiView = (TextView) findViewById(R.id.score_Ai_text);
        tieView = (TextView) findViewById(R.id.score_tie_text);

        p1View.setText(getString(R.string.score_p1) + " " + p1count);
        p2View.setText(getString(R.string.score_p2) + " " + p2count);
        aiView.setText(getString(R.string.score_ai) + " " + aicount);
        tieView.setText(getString(R.string.score_tie) + " " + tiecount);

    }

    /**
     * Closes the activity
     * @param view
     */
    public void onBtnFinish(View view){
        super.finish();
    }
}
