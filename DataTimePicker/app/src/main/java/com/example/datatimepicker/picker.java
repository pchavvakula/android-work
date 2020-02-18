package com.example.datatimepicker;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TimePicker;

import java.util.Calendar;
import java.util.Date;

public class picker extends LinearLayout {
    DatePicker datePicker;
    TimePicker timePicker;
    CheckBox checkTimePicker;

    OnDateTimeChangeListener listener;

    public picker(Context context) {
        super(context);
        init(context);
    }

    public picker(Context context,AttributeSet attrs ) {
        super(context, attrs);
        init(context);
    }

    private  void  init (Context context){
        LayoutInflater inflater =(LayoutInflater)Context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate((R.layout.picker,this ,true);

        datePicker = (DatePicker)findViewById(R.id.datePicker);
        timePicker = (TimePicker)findViewById(R.id.timePicker);
        checkTimePicker=(CheckBox) findViewById(R.id.checkTimePicker);

        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        int curYear = calendar.get(Calendar.YEAR);
        int curMonth = calendar.get(calendar.MONTH);
        int curDay = calendar.get(calendar.DAY_OF_MONTH);
        int curHour = calendar.get(calendar.HOUR_OF_DAY);
        int curMinute = calendar.get(calendar.MINUTE);

        datePicker.init(curMonth, curDay, curYear, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int year, int month, int day) {
                if (listener != null) {
                    listener.onDateTimeChange(picker.this, year, month, day, timePicker.getCurrentHour(), timePicker.getCurrentMinute());
                }

            }
        });
        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                if(listener!= null){
                    listener.onDateTimeChange(picker.this,datePicker.getYear(),datePicker.getMonth(),datePicker.getDayOfMonth(),hour,minute);
                }

            }
        });
        timePicker.setCurrentHour(curHour);
        timePicker.setCurrentMinute(curMinute);
        timePicker .setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hour, int minute) {
                if(listener!=null){
                    listener.onDateTimeChange(picker.this,datePicker.getYear(),datePicker.getMonth(),datePicker.getDayOfMonth(),hour,minute);
                }

            }
        });
        checkTimePicker.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                timePicker.setEnabled(isChecked);
                timePicker.setVisibility(checkTimePicker.isChecked() ? View.VISIBLE:View.INVISIBLE);
            }
        });
    }
    public  void  setOnDateTimeChangeListener(OnDateTimeChangeListener listener){
    this.listener = listener;
    }
    public  void  updateDateTime(int year,int month,int day,int hour,int minute){
        datePicker
    }
}





