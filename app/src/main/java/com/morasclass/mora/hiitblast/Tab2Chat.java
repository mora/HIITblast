package com.morasclass.mora.hiitblast;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by n398447 on 4/20/2017.
 */

public class Tab2Chat extends Fragment {

    SetTimer setTimer;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab2chat, container, false);

        TextView timerView = (TextView) rootView.findViewById(R.id.timerTextView);
        Button b = (Button) rootView.findViewById(R.id.timerButton);

        setTimer = new SetTimer(b,timerView);

        return rootView;
    }

    //add override to super.onpause
    //https://stackoverflow.com/questions/4597690/android-timer-how-to

}
