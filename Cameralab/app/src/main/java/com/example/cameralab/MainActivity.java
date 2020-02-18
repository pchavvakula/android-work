package com.example.cameralab;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    Button button;
    ImageView imageView;
    private static  final int Request_Image_Capture=101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView)findViewById(R.id.imageView);
        button =(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view
            ) {
                takePicture(view);

            }
        });
    }

public void takePicture (View view){
    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
    if((intent.resolveActivity(getPackageManager())!= null)){
        startActivityForResult(intent,Request_Image_Capture);
    }
}

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==Request_Image_Capture && resultCode==RESULT_OK){
            Bundle extras = data.getExtras();
            Bitmap imageBitmap =(Bitmap)extras.get("data");
            imageView.setImageBitmap(imageBitmap);
        }
    }
}
