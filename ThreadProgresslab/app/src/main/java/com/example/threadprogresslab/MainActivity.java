package com.example.threadprogresslab;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ProgressBar progressBar;
    Button button;
    Handler handler = new Handler();
    int value = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ProgressBar progressBar =(ProgressBar)findViewById(R.id.progressBar);
        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        ProgressThread thread = new ProgressThread();
                        thread.start();

                    }
                }, 5000);


            }
        });
    }
    class ProgressThread extends  Thread{

        public void  run(){
            while (true){
                if(value > 100){
                    break;
                }
                value += 1;
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        progressBar.setProgress(value);

                    }
                });
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
