package com.example.vediolab;

import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        videoView = (VideoView)findViewById(R.id.videoView);
        MediaController controller  = new MediaController(this);
        videoView.setMediaController(controller);
        videoView,setVideopath("android.resource://"com.example.vediolab/" +R.raw.sample_vedio);

                vedioview.setOnPreparedListener(new Mediapl)

    }
}
