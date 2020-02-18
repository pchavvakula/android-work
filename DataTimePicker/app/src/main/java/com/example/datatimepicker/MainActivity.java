package com.example.datatimepicker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.text.SimpleDateFormat;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    Picker picker;
    SimpleDateFormat format = new SimpleDateFormat("MM-DD-YYYY HH:mm");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView)findViewById(R.id.textview);
        picker = (picker)findViewById(R.id.picker);

        picker.setOnDateTimeChangeListener(new OnDateTimeChangeListener(){


        }
    }
}
