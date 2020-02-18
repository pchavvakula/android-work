package com.example.audiolab;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {
    MediaPlayer player;
    int position = 0;//pause restart
    Button button1,button2,button3,button4;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1  = (Button)findViewById(R.id.button);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
}
    Button button2  = (Button)findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Button button2  = (Button)findViewById(R.id.button2);
            button2.setOnClickListener(new View.OnClickListener() {
                @Override

                public void onClick(View v) {
                    Button button4  = (Button)findViewById(R.id.button4);
                    button2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                }

    });
}
public  void  playAudio (){
                    try {
                        closePlayer();
                        player = MediaPlayer.create(this,R.raw.song);
                        player.start();
                        Toast.makeText(this,"Start",Toast.LENGTH_LONG).show();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    }
                    public void  pauseAudio(){
                if(player ! = null){
                    position = player.getCurrentPosition();
                    player.pause();
                    Toast.makeText("Paused..",Toast.LENGTH_LONG).show();
                        }
            }
            public void resumeAudio()
                if(player ! = null)
}

