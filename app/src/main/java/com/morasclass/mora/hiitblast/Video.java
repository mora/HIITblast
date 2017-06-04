package com.morasclass.mora.hiitblast;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.SeekBar;
import android.widget.VideoView;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by n342432 on 5/24/2017.
 */

public class Video extends AppCompatActivity {
    VideoView vid;
    String path;
    SeekBar bar;


    public Video(VideoView v, final SeekBar bar, String path) {
        vid = v;
        this.path = path;
        Uri uri = Uri.parse(path);
        vid.setVideoPath(path);
        this.bar = bar;
    }

    public void tappedVideo(View v){
        if(vid.isPlaying()) {
            vid.pause();
        }
        else {
            vid.start();
        }
    }

    public void changeVideoProgress(int progress) {
        vid.seekTo(vid.getDuration() * progress/100);
    }
}
