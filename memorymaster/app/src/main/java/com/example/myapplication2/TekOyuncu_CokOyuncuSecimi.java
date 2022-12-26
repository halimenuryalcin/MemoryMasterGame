package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TekOyuncu_CokOyuncuSecimi extends AppCompatActivity {
    Button tekoyunucu;
    Button cokoyunucu;
    Context context=this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tek_oyuncu_cok_oyuncu_secimi);
        tekoyunucu=findViewById(R.id.buttonTekOyuncuSecimi);
        cokoyunucu=findViewById(R.id.buttonCokOyuncuSecimi);




        tekoyunucu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    this.finalize();

                    Intent intent = new Intent(context,KolayOrtaZorSecimEkrani.class);
                    startActivity(intent);
                }
                catch (Throwable throwable){
                    throwable.printStackTrace();
                }


            }
        });


        cokoyunucu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    this.finalize();
                    Intent intent = new Intent(context,KolayOrtaZorMultiP.class);
                    startActivity(intent);

                }
                catch (Throwable throwable){
                    throwable.printStackTrace();
                }



            }
        });







    }


}