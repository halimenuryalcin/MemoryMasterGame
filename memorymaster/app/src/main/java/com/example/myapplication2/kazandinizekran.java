package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class kazandinizekran extends AppCompatActivity {
    MediaPlayer kazandinizplay;
    Button menübutton;
    Context context = this;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kazandinizekran);
        menübutton=findViewById(R.id.buttonMenügiris);

        kazandinizplay=MediaPlayer.create(this,R.raw.kazandiniz);
        kazandinizplay.start();



        menübutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                kazandinizplay.pause();
                try {
                    this.finalize();

                    Intent intent = new Intent(context,MainActivity.class);
                    startActivity(intent);
                }
                catch (Throwable throwable){
                    throwable.printStackTrace();
                }
            }
        });


    }
}