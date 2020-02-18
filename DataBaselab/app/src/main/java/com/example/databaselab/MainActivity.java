package com.example.databaselab;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editText,editText2,editText3,editText4,editText5;//step1
    TextView textView;
    Button button,button2,button3,button4;
    SQLiteDatabase database;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText)findViewById(R.id.editText);
        textView = (TextView)findViewById(R.id.textView);
        button =(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String databaseName = editText.getText().toString();
                openDatabase(databaseName);

            }
        });

        editText2 = (EditText)findViewById(R.id.editText2);
        button2 =(Button)findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tableName = editText2.getText().toString();
                createTable(tableName);

            }
        });

        editText3 = (EditText)findViewById(R.id.editText3);
        editText4 = (EditText)findViewById(R.id.editText4);
        editText5 = (EditText)findViewById(R.id.editText5);
        button3 =(Button)findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editText3.getText().toString().trim();
                String ageStr = editText4.getText().toString().trim();
                String mobile = editText5.getText().toString().trim();
                int age = -1;
                try {
                    age = Integer.parseInt(ageStr);
                } catch (Exception e) {

                }
                insertData(name, age, mobile);
            }
        });

        button4 =(Button)findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tableName = editText2.getText().toString();
                selectData(tableName);
            }
        });

    }


//step1
public void openDatabase (String databaseName){
    println("openDatabase() called..");
    database = openOrCreateDatabase(databaseName,MODE_PRIVATE,null);
    if(database!= null){
        println("Database opened");

    }
}
public void  println(String data){
        textView.append(data+"\n");
        }

        //step2
public void createTable(String tableName) {
    println("createTable called...");
    if (database != null) {
        String sql = "create table " + tableName + "(_id integer PRIMARY KEY autoincrement, name text,age integer,mobile  text)";
        database.execSQL(sql);
        println("Table created");
    } else {
        println("Open database first");
    }
}

//step4
        public void insertData(String name,int age,String mobile){
            println ("insertData() called");
        if(database!=null) {
            String sql = "insert into customer2 (name,age, mobile) values ('Priya','30','123-123-1234')";
            database.execSQL(sql);
            println("Data inserted");
        }
        else{
            println("open database first");
        }
        }
        public void selectData(String tableName){
    println("selectedData() called");
    if (database!=null){
        String sql = "select name,age,mobile from "+tableName;
        Cursor cursor = database.rawQuery(sql,null);
        println("Number of record"+cursor.getCount());
        for (int i=0;i<cursor.getCount();i++){
            cursor.moveToNext();
            String name = cursor.getString(0);
            int age = cursor.getInt(1);
            String mobile = cursor.getString(2);
            println("#"+i+" "+name+","+age+","+mobile);
        }
        cursor.close();
    }
    }
}