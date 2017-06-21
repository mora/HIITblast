package com.morasclass.mora.hiitblast;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.VideoView;

/**
 * Created by n398447 on 4/20/2017.
 */

public class Tab1Lunges extends Fragment implements  View.OnClickListener, VideoView.OnTouchListener, SeekBar.OnSeekBarChangeListener{

    SetTimer setTimer;
    Video video;
    Description description;
    Button bu;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab1lunges, container, false);

        //timer
        TextView timerView = (TextView) rootView.findViewById(R.id.timerTextView);
        Button b = (Button) rootView.findViewById(R.id.timerButton);
        setTimer = new SetTimer(b,timerView);

        super.onCreate(savedInstanceState);

        //video
        VideoView vid = (VideoView) rootView.findViewById(R.id.videoLunge);
        String path = "android.resource://" + this.getActivity().getPackageName() + "/" + R.raw.lunge;
        vid.setOnTouchListener(this);
        SeekBar bar = (SeekBar) rootView.findViewById(R.id.lungeSeek);
        bar.setOnSeekBarChangeListener(this);

        video = new Video(vid,bar,path);

        //description
        TextView title = (TextView) rootView.findViewById(R.id.title);
        TextView des = (TextView)rootView.findViewById(R.id.description);

        title.setOnClickListener(this);

        description = new Description(title,des);

        return rootView;
    }

    @Override
    public void onClick(View view) {
        description.change();
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        video.tappedVideo(v);
        return false;
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        video.changeVideoProgress(progress);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
