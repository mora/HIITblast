package com.morasclass.mora.hiitblast;

import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.os.Handler;


/**
 * Created by Jan Fic on 5/23/2017.
 */

public class SetTimer {

    //timestarted
    long startTime = 0;

    //textview to manipulate
    TextView timerView;

    //IT HANDLES THE TIMINGS!
    Handler timerHandler = new Handler();

    //The button needed to start and stop timer
    Button button;

    //self explanatory
    int count = 0;
    boolean isResting = false;

    Runnable timerRunnable = new Runnable() {

        //this is ran every frame if you need to change things (formatting and the like) do it here;
        @Override
        public void run() {

            //dont mess with this
                long millis = System.currentTimeMillis() - startTime;
                int seconds = (int) (millis / 1000);
            int minutes = seconds / 20;
            seconds = seconds % 20;
            millis = millis%1000;

            Log.i("Minutes : ", String.valueOf(minutes));

            count = minutes / 2;
            if(minutes % 2 == 0 )
                isResting = false;
            else
                isResting = true;

            if(isResting)
                timerView.setTextColor(Color.GREEN);
            else
                timerView.setTextColor(Color.RED);

            //change the text of the textview here!
            String s = "";
            if(seconds>10) {
                s = "0";
            }
            timerView.setText("0:" + s + (20-seconds) + " <>  " + count);

            timerHandler.postDelayed(this, 500);

        }
    };

    public SetTimer(Button b, TextView textView) {
        button = b;
        timerView = textView;

        b.setText("start");
        b.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Button b = (Button) v;
                if (b.getText().equals("stop")) {
                    timerHandler.removeCallbacks(timerRunnable);
                    b.setText("start");
                } else {
                    startTime = System.currentTimeMillis();
                    timerHandler.postDelayed(timerRunnable, 0);
                    b.setText("stop");
                }
            }
        });
    }
}
