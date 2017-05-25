package com.morasclass.mora.hiitblast;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

/**
 * Created by n398447 on 4/20/2017.
 */

public class Tab2Chat extends Fragment implements  View.OnClickListener{

    SetTimer setTimer;
    Video video;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab2chat, container, false);

        //timer
        TextView timerView = (TextView) rootView.findViewById(R.id.timerTextView);
        Button b = (Button) rootView.findViewById(R.id.timerButton);


        super.onCreate(savedInstanceState);
        //setContentView(R.layout.tab1contacts);


        //video
        Button vidB = (Button) rootView.findViewById(R.id.videoButton);
        VideoView vid = (VideoView) rootView.findViewById(R.id.videoView5);
        MediaController med = new MediaController(this.getContext());
        String path = "android.resource://" + this.getActivity().getPackageName() + "/" + R.raw.vid;

        vidB.setOnClickListener(this);

        video = new Video(vid,vidB,med,path);
        setTimer = new SetTimer(b,timerView);
        return rootView;
    }

    @Override
    public void onClick(View view) {
        video.videoPlay(view);
    }

}
