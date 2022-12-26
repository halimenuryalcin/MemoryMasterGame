package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication2.Multiplayer.KolayOyunEkraniMultiP;
import com.example.myapplication2.Multiplayer.OrtaOyunEkraniMultiP;
import com.example.myapplication2.Multiplayer.ZorOyunEkraniMultiP;

public class KolayOrtaZorMultiP extends AppCompatActivity {

    Button KolayButton;
    Button OrtaButton;
    Button ZorButton;
    Button MenuButton;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kolay_orta_zor_multi_p);

        KolayButton=findViewById(R.id.buttonKolayMulti);
        OrtaButton=findViewById(R.id.buttonortaMulti);
        ZorButton=findViewById(R.id.buttonZorMulti);
        MenuButton=findViewById(R.id.buttonGeriMulti);


        KolayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ıntent=new Intent(context, KolayOyunEkraniMultiP.class);
                ıntent.putExtra("milisec", 60000);

                //play=MediaPlayer.create(KolayOyunEkrani,R.raw.anamuzik);
                //play.start();
                startActivity(ıntent);


            }
        });

        OrtaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ıntent=new Intent(context, OrtaOyunEkraniMultiP.class);
                ıntent.putExtra("milisec", 60000);

                //play=MediaPlayer.create(KolayOyunEkrani,R.raw.anamuzik);
                //play.start();
                startActivity(ıntent);



            }
        });
        ZorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ıntent=new Intent(context, ZorOyunEkraniMultiP.class);
                ıntent.putExtra("milisec", 60000);

                //play=MediaPlayer.create(KolayOyunEkrani,R.raw.anamuzik);
                //play.start();
                startActivity(ıntent);



            }
        });
        MenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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