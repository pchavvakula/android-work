package com.example.calculator_chavvakula;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button button0,button1,button2,button3,button4,button5,button6,button7,button8,button9,
    buttonAdd,buttonSub,buttonMul,buttonDiv,button10,buttonDot,buttonC,buttonEqual;
    EditText editText;
    float ValueOne,ValueTwo;
    boolean MyAddition,MySubtraction,MyMultiplication,MyDivision;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            button1 = (Button)findViewById(R.id.button);
            button2 = (Button)findViewById(R.id.button2);
            button3 = (Button)findViewById(R.id.button3);
            buttonAdd = (Button)findViewById(R.id.buttonAdd);
            button4 = (Button)findViewById(R.id.button4);
            button5 = (Button)findViewById(R.id.button5);
            button6 = (Button)findViewById(R.id.button6);
            buttonSub = (Button)findViewById(R.id.buttonSub);
            button7 = (Button)findViewById(R.id.button7);
            button8 = (Button)findViewById(R.id.button8);
            button9 = (Button)findViewById(R.id.button9);
            buttonMul = (Button)findViewById(R.id.buttonMul);
            button0 = (Button)findViewById(R.id.button0);
            buttonDot = (Button)findViewById(R.id.buttonDot);
            buttonC = (Button)findViewById(R.id.buttonC);
            buttonDiv = (Button)findViewById(R.id.buttonDiv);
            buttonEqual = (Button)findViewById(R.id.Equal);
            editText = (EditText)findViewById(R.id.editText);

            button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    editText.setText(editText.getText()+ "1");
                }

           });

            button2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    editText.setText(editText.getText()+ "2");
                }
            });

            button3.setOnClickListener(new View.OnClickListener() {

                public void onClick(View v) {
                    editText.setText(editText.getText()+ "3");
                }
            });

            button4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    editText.setText(editText.getText()+ "4");
                }
            });

            button5.setOnClickListener(new View.OnClickListener() {

                public void onClick(View v) {
                    editText.setText(editText.getText()+ "5");
                }
            });

            button6.setOnClickListener(new View.OnClickListener() {

                public void onClick(View v) {
                    editText.setText(editText.getText()+ "6");
                }
            });

            button7.setOnClickListener(new View.OnClickListener() {

                public void onClick(View v) {
                    editText.setText(editText.getText()+ "7");
                }
            });

            button8.setOnClickListener(new View.OnClickListener() {

                public void onClick(View v) {
                    editText.setText(editText.getText()+ "8");
                }
            });

            button9.setOnClickListener(new View.OnClickListener() {

                public void onClick(View v) {
                    editText.setText(editText.getText()+ "9");
                }
            });

            button0.setOnClickListener(new View.OnClickListener() {

                public void onClick(View v) {
                    editText.setText(editText.getText()+ "0");
                }
            });

            buttonDot.setOnClickListener(new View.OnClickListener() {

                public void onClick(View v) {
                    editText.setText(editText.getText()+ ".");
                }
            });

            buttonAdd.setOnClickListener(new View.OnClickListener() {

                public void onClick(View v) {
                    if(editText==null){
                        editText.setText("");
                    }else{
                        ValueOne = Float.parseFloat(editText.getText()+"");
                        MyAddition=true;
                        editText.setText(null);
                    }
                }
            });

            buttonSub.setOnClickListener(new View.OnClickListener() {

                public void onClick(View v) {

                    ValueOne = Float.parseFloat(editText.getText()+"");
                    MySubtraction=true;
                    editText.setText(null);
                }

            });
            buttonMul.setOnClickListener(new View.OnClickListener() {

                public void onClick(View v) {

                    ValueOne = Float.parseFloat(editText.getText()+"");
                    MyMultiplication=true;
                    editText.setText(null);
                }

            });
            buttonDiv.setOnClickListener(new View.OnClickListener() {

                public void onClick(View v) {

                    ValueOne = Float.parseFloat(editText.getText()+"");
                    MyDivision=true;
                    editText.setText(null);
                }

            });

            buttonEqual.setOnClickListener(new View.OnClickListener() {

                public void onClick(View v) {
                    ValueTwo= Float.parseFloat(editText.getText()+"");

                    if(MyAddition == true){
                        editText.setText(ValueOne + ValueTwo+"");
                        MyAddition= false;
                    }
                    if(MySubtraction == true){
                        editText.setText(ValueOne - ValueTwo+"");
                        MySubtraction= false;
                    }
                    if(MyMultiplication == true){
                        editText.setText(ValueOne * ValueTwo+"");
                        MyMultiplication= false;
                    }
                    if(MyDivision == true){
                        editText.setText(ValueOne / ValueTwo+"");
                        MyDivision= false;
                    }
                }
            });

            buttonC.setOnClickListener(new View.OnClickListener() {

                public void onClick(View v) {
                    editText.setText("");
                }
            });


        }
    }


