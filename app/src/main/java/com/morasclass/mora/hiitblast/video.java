package com.morasclass.mora.hiitblast;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

/**
 * Created by n342432 on 5/24/2017.
 */

public class video extends AppCompatActivity {
    Button b;
    VideoView vid;
    MediaController med;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab1contacts);
        //b = (Button) findViewById(R.id.button);
        vid = (VideoView) findViewById(R.id.videoView5);
        med = new MediaController(this);
    }
    public void videoPlay(View v){
        /*vid.setOnPreparedListener (new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.reset();
            }
        });*/

        String path = "android.resource://" + getPackageName() + "/" + R.raw.video_arg_10;
        Log.i("path: ", path);
        Uri uri = Uri.parse(path);
        Log.i("got","here");
        vid.setVideoPath(path);
        Log.i("and","here");
        vid.setMediaController(med);
        //vid.requestFocus();
        //Log.i("and even","here");
        vid.start();
    }


}
