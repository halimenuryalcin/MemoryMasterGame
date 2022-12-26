package com.example.myapplication2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication2.Houses.Gryffindor;
import com.example.myapplication2.Houses.Houses;
import com.example.myapplication2.Houses.Slytherin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class OrtaOyunEkrani extends AppCompatActivity {
    List<ImageButton> imageButtonList=new ArrayList<>();
    ImageButton imageButtonOrt1;
    ImageButton imageButtonOrt2;
    ImageButton imageButtonOrt3;
    ImageButton imageButtonOrt4;
    ImageButton imageButtonOrt5;
    ImageButton imageButtonOrt6;
    ImageButton imageButtonOrt7;
    ImageButton imageButtonOrt8;
    ImageButton imageButtonOrt9;
    ImageButton imageButtonOrt10;
    ImageButton imageButtonOrt11;
    ImageButton imageButtonOrt12;
    ImageButton imageButtonOrt13;
    ImageButton imageButtonOrt14;
    ImageButton imageButtonOrt15;
    ImageButton imageButtonOrt16;
    ImageButton sesackapaorta;
    List<Houses>imageList=new ArrayList<>();
    TextView ortaskor;

    CountDownTimer countDownTimer;
    Context context = this;

    TextView txtTimer;

    List<Object>karşılaştırma=new ArrayList<>();
    int temp;
    int temp2;
    int sayac=0;
    int sessayac=2;
    double skor=0;
    int sec;
    int kazancsayac=0;
    MediaPlayer play;
    MediaPlayer bulunduplay;
    MediaPlayer sureplay;








    @SuppressLint({"SuspiciousIndentation", "WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orta_oyun_ekrani);
        imageButtonOrt1=findViewById(R.id.imageButtonort1);
        imageButtonOrt2=findViewById(R.id.imageButtonort2);
        imageButtonOrt3 = findViewById(R.id.imageButtonort3);
        imageButtonOrt4 = findViewById(R.id.imageButtonort4);
        imageButtonOrt5 = findViewById(R.id.imageButtonort5);
        imageButtonOrt6 = findViewById(R.id.imageButtonort6);
        imageButtonOrt7 = findViewById(R.id.imageButtonort7);
        imageButtonOrt8 = findViewById(R.id.imageButtonort8);
        imageButtonOrt9 = findViewById(R.id.imageButtonort9);
        imageButtonOrt10 = findViewById(R.id.imageButtonort10);
        imageButtonOrt11 = findViewById(R.id.imageButtonort11);
        imageButtonOrt12 = findViewById(R.id.imageButtonort12);
        imageButtonOrt13 = findViewById(R.id.imageButtonort13);
        imageButtonOrt14 = findViewById(R.id.imageButtonort14);
        imageButtonOrt15 = findViewById(R.id.imageButtonort15);
        imageButtonOrt16 = findViewById(R.id.imageButtonort16);
        Intent intent = getIntent();
        int milisec = intent.getIntExtra("milisec",0);
        txtTimer = findViewById(R.id.textViewsureorta);
        sureplay=MediaPlayer.create(this,R.raw.surebitince);
        play=MediaPlayer.create(this,R.raw.anamuzik);
        play.start();
        bulunduplay=MediaPlayer.create(this,R.raw.bulundu);
        ortaskor=findViewById(R.id.textViewskorOrta);





        Gryffindor Harry=new Gryffindor(R.drawable.harryimage,"Harry",10);
        Gryffindor Dumbledore=new Gryffindor(R.drawable.dumbledoreimage,"Dumbledore",20);
        Gryffindor Ron=new Gryffindor(R.drawable.ronimage,"Ron",8);
        Gryffindor Hermione=new Gryffindor(R.drawable.hermioneimage,"Hermione",10);
        Gryffindor McGonagall=new Gryffindor(R.drawable.mcgonagallimage,"McGonagall",13);

        Slytherin Severus=new Slytherin(R.drawable.severusimage,"Severus",18);
        Slytherin TomRiddle=new Slytherin(R.drawable.tomriddleimage,"Tom Riddle",20);
        Slytherin Draco=new Slytherin(R.drawable.dracoimage,"Draco",5);


        sesackapaorta=(ImageButton)findViewById(R.id.sesaackapaorta);

        imageButtonList.add(imageButtonOrt1);
        imageButtonList.add(imageButtonOrt2);
        imageButtonList.add(imageButtonOrt3);
        imageButtonList.add(imageButtonOrt4);
        imageButtonList.add(imageButtonOrt5);
        imageButtonList.add(imageButtonOrt6);
        imageButtonList.add(imageButtonOrt7);
        imageButtonList.add(imageButtonOrt8);
        imageButtonList.add(imageButtonOrt9);
        imageButtonList.add(imageButtonOrt10);
        imageButtonList.add(imageButtonOrt11);
        imageButtonList.add(imageButtonOrt12);
        imageButtonList.add(imageButtonOrt13);
        imageButtonList.add(imageButtonOrt14);
        imageButtonList.add(imageButtonOrt15);
        imageButtonList.add(imageButtonOrt16);


        int backImage=(R.drawable.ic_menu_help);



        imageList.add(Draco);
        imageList.add(Dumbledore);
        imageList.add(TomRiddle);
        imageList.add(Ron);
        imageList.add(McGonagall);
        imageList.add(Hermione);
        imageList.add(Harry);
        imageList.add(Severus);

        imageList.addAll(imageList);
        Collections.shuffle(imageList);
        for (int i=0;i<imageButtonList.size();i++){
            System.out.println(i);
            int finalI = i;
            imageButtonList.get(finalI).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    imageButtonList.get(finalI).setEnabled(false);
                    bulunduplay.start();
                    bulunduplay.pause();
                    play.start();
                    if(sayac==1){
                        imageButtonList.get(temp2).setImageResource(backImage);
                        imageButtonList.get(temp).setImageResource(backImage);
                        sayac=0;
                    }
                    imageButtonList.get(finalI).setImageResource((Integer) imageList.get(finalI).getImage());
                    karşılaştırma.add(imageButtonList.get(finalI).getImageMatrix());
                    if(karşılaştırma.size()==1){
                        temp=finalI;
                    }
                    if (karşılaştırma.size()==2){
                        if(karşılaştırma.get(0).equals(karşılaştırma.get(1))){
                            skor=skor+((2* imageList.get(finalI).getPuan()*imageList.get(finalI).getKatsayi())*((double) sec/10));
                            System.out.println("AYNI RESİM SKOR: "+skor+"saniye"+sec);
                            String skortext= String.valueOf(skor);
                            ortaskor.setText(skortext);
                            imageButtonList.get(finalI).setEnabled(false);
                            imageButtonList.get(temp).setEnabled(false);
                            karşılaştırma.clear();
                            play.pause();
                            bulunduplay.start();
                            kazancsayac++;
                            if(kazancsayac==8){
                                bulunduplay.pause();
                                sureplay.pause();

                                Intent ıntent=new Intent(context,kazandinizekran.class);
                                startActivity(ıntent);
                            }
                        }
                        else{
                            imageButtonList.get(finalI).setEnabled(true);
                            imageButtonList.get(temp).setEnabled(true);
                            sayac++;
                            System.out.println("farklı resim");
                            temp2=finalI;
                            karşılaştırma.clear();
                            if(imageList.get(finalI).getClass().equals(imageList.get(temp).getClass())){
                                skor=(skor-(((imageList.get(finalI).getPuan()+imageList.get(temp).getPuan())/imageList.get(finalI).getKatsayi())*((45.0-(double)sec)/10.0)));
                                System.out.println("farklı resim aynı ev SKORRR"+skor+"saniye"+sec);
                                String skortext= String.valueOf(skor);
                               ortaskor.setText(skortext);
                            }else if(!(imageList.get(finalI).getClass().equals(imageList.get(temp).getClass()))){
                                skor=skor-((((imageList.get(finalI).getPuan()+imageList.get(temp).getPuan())/2.0)*imageList.get(finalI).getKatsayi()*imageList.get(temp).getKatsayi())*((45.0-(double)sec)/10.0));
                                System.out.println("farklı resim  farklı ev SKOR"+skor+"saniye"+sec);
                                String skortext= String.valueOf(skor);
                               ortaskor.setText(skortext);
                            }


                        }


                    }}
            });
        }
        sesackapaorta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(sessayac%2==0){
                    play.pause();
                    bulunduplay.pause();
                    sesackapaorta.setImageResource(R.drawable.seskapa);

                }else if(sessayac%2==1){
                    play.start();
                    sesackapaorta.setImageResource(R.drawable.imgg);

                }

                sessayac++;

            }
        });





        countDownTimer = new CountDownTimer(milisec, 1000) {
            @Override
            public void onTick(long l) {
                int min = (int) (l / 1000) / 60;
                sec = (int) (l / 1000) % 60;
                String timerformat = String.format(Locale.getDefault(), "%02d:%02d", min, sec);
                txtTimer.setText(timerformat);
            }

            @Override
            public void onFinish() {
                play.pause();
                sureplay.start();
                if(sureplay.isPlaying()){
                    Toast.makeText(context, "Süre Bitti,Kaybettiniz", Toast.LENGTH_LONG).show();
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    try {
                        this.finalize();
                        Intent intent = new Intent(context,MainActivity.class);
                        startActivity(intent);
                    }
                    catch (Throwable throwable){
                        throwable.printStackTrace();
                    }


                }
                //startActivity(intent);
                for (int i = 0; i <imageButtonList.size() ; i++) {
                    imageButtonList.get(i).setEnabled(false);
                }
            }
        }.start();












    }

}