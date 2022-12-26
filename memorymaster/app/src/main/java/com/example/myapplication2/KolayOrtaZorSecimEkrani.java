package com.example.myapplication2;



import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class KolayOrtaZorSecimEkrani extends AppCompatActivity {
    Button KolayButton;
    Button OrtaButton;
    Button ZorButton;
    Button MenuButton;
    Context context = this;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kolay_orta_zor_secim_ekrani);

        KolayButton=findViewById(R.id.buttonKolayMP);
        OrtaButton=findViewById(R.id.buttonOrtaMP);
        ZorButton=findViewById(R.id.buttonZorMP);
        MenuButton=findViewById(R.id.buttonMenMp);


        KolayButton.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Intent ıntent=new Intent(context,KolayOyunEkrani.class);
              ıntent.putExtra("milisec", 45000);

              //play=MediaPlayer.create(KolayOyunEkrani,R.raw.anamuzik);
              //play.start();
              startActivity(ıntent);


          }
      });
      OrtaButton.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
           Intent ıntent=new Intent(context,OrtaOyunEkrani.class);
              ıntent.putExtra("milisec", 45000);
              startActivity(ıntent);



          }
      });
        ZorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ıntent=new Intent(context,ZorOyunEkrani.class);
                ıntent.putExtra("milisec", 45000);
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