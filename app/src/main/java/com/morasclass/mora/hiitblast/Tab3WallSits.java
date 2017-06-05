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

public class Tab3WallSits extends Fragment implements  View.OnClickListener, VideoView.OnTouchListener, SeekBar.OnSeekBarChangeListener{

    Video video;
    SetTimer timer;
     Description description;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab3wall, container, false);

        //timer
            Button but = (Button) rootView.findViewById(R.id.timerButton);
            TextView tv = (TextView) rootView.findViewById(R.id.timerTextView);
            timer = new SetTimer(but,tv);

        //video
            VideoView vid = (VideoView) rootView.findViewById(R.id.videoWall);
            String path = "android.resource://" + this.getActivity().getPackageName() + "/" + R.raw.wallsits;
            vid.setOnTouchListener(this);
            SeekBar bar = (SeekBar) rootView.findViewById(R.id.wallSeek);
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
    public void onClick(View v) {
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
