package com.example.threadlab;

import android.os.Handler;
import android.os.Message;
import android.renderscript.Sampler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    Button button,button2;
    //int value=0;
    ValueHandler handler = new ValueHandler();
    Handler handler2 = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView)findViewById(R.id.textView);
        button =(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //BackgroundThread thread = new BackgroundThread();
                //thread.start();//run () called
                new Thread(new Runnable() {
                    int value=0;
                    boolean running = false;
                    @Override
                    public void run() {
                        running = true;
                        while (running){
                            value +=1;

                            handler2.post(new Runnable() {
                                @Override
                                public void run() {
                                    textView.setText("value -" + value);
                                }
                            });
                        try {
                            Thread.sleep(millis: 1000);
                        }catch (Exception e){}
                    }}
                });

            }
        });
        button2 = (Button)findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //textView.setText("Current value : "+ value);

            }
        });
    }
    class BackgroundThread extends Thread{
        int value=0;
        boolean running = false;
        public void  run(){
            running = true;
            while (running){
                value += 1;
                Message message = handler.obtainMessage();
                Bundle bundle = new Bundle();
                bundle.putInt("Value",value);
                message.setData(bundle);
                handler.sendMessage(message);

                try {
                    Thread.sleep( millis:1000);

                }catch (Exception e){}
            }

        }
    }
    class  ValueHandler extends Handler{

        @Override
        public void handleMessage(Message msg) {//handle message
            super.handleMessage(msg);
        }
    }

}
