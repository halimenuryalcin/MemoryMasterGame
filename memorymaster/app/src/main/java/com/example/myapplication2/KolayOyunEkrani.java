package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication2.Houses.Gryffindor;
import com.example.myapplication2.Houses.Houses;
import com.example.myapplication2.Houses.Slytherin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class KolayOyunEkrani extends AppCompatActivity {

//card =memorycard
    List<ImageButton>imageButtonList=new ArrayList<>();
    ImageButton imageButtonKolay1;
    ImageButton imageButtonKolay2;
    ImageButton imageButtonKolay3;
    ImageButton imageButtonKolay4;
    ImageButton buttonseskapakolay;

    CountDownTimer countDownTimer;
    Context context = this;
    TextView txtTimer;
    TextView kolaySkor;

    int temp;
    int temp2;
    int sessayac=2;
    int sayac=0;
    int sec;
    double skor=0;

    MediaPlayer play;
    MediaPlayer bulunduplay;
    MediaPlayer sureplay;
    MediaPlayer kazandinizplay;






    List<Houses>imageList1=new ArrayList<>();
    List<Houses>imageList2=new ArrayList<>();
    List<Houses>imageList3=new ArrayList<>();
    List<Houses>imageList4=new ArrayList<>();
    List<Houses>asilList=new ArrayList<>();
    List<List<Houses>> lists = new ArrayList<>();

    List<Object>karşılaştırma=new ArrayList<>();
    int kazancsayac=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kolay_oyun_ekrani);
        imageButtonKolay1=findViewById(R.id.imageButtonkolay1);
        imageButtonKolay2=findViewById(R.id.imageButtonkolay2);
        imageButtonKolay3=findViewById(R.id.imageButtonkolay3);
        imageButtonKolay4=findViewById(R.id.imageButtonkolay4);
        buttonseskapakolay=findViewById(R.id.buttonseskapakolay);
//gtyindor
    Gryffindor Harry=new Gryffindor(R.drawable.harryimage,"Harry",10);
    Gryffindor Dumbledore=new Gryffindor(R.drawable.dumbledoreimage,"Dumbledore",20);
    Gryffindor Ron=new Gryffindor(R.drawable.ronimage,"Ron",8);
    Gryffindor Hermione=new Gryffindor(R.drawable.hermioneimage,"Hermione",10);
    Gryffindor McGonagall=new Gryffindor(R.drawable.mcgonagallimage,"McGonagall",13);

    Slytherin Severus=new Slytherin(R.drawable.severusimage,"Severus",18);
    Slytherin TomRiddle=new Slytherin(R.drawable.tomriddleimage,"Tom Riddle",20);
    Slytherin Draco=new Slytherin(R.drawable.dracoimage,"Draco",5);
  Slytherin LuciusMalfoy=new Slytherin(R.drawable.luciusimage,"Lucius",12);




       kolaySkor=findViewById(R.id.textViewKolaySkor);









        play=MediaPlayer.create(this,R.raw.anamuzik);
        play.start();
        bulunduplay=MediaPlayer.create(this,R.raw.bulundu);
        kazandinizplay=MediaPlayer.create(this,R.raw.kazandiniz);
        int backsoundimage=(R.drawable.seskapa);

        int backImage=(R.drawable.ic_menu_help);
        Intent intent = getIntent();
        int milisec = intent.getIntExtra("milisec",0);
       txtTimer=findViewById(R.id.textViewsurekolay);
        sureplay=MediaPlayer.create(this,R.raw.surebitince);

        imageButtonList.add(imageButtonKolay1);
        imageButtonList.add(imageButtonKolay2);
        imageButtonList.add(imageButtonKolay3);
        imageButtonList.add(imageButtonKolay4);
        imageList1.add(Harry);
        imageList1.add(Dumbledore);


        imageList2.add(Hermione);
        imageList2.add(Ron);

        imageList3.add(TomRiddle);
        imageList3.add(Draco);

        imageList4.add(LuciusMalfoy);
        imageList4.add(Severus);

       //Büyük listeyi doldurmak
        lists.add(imageList1);
        lists.add(imageList2);
        lists.add(imageList3);
        lists.add(imageList4);


        Random random=new Random();
        int randomNumber=random.nextInt(lists.size());
        asilList=lists.get(randomNumber);//kullanılcak listeyi tanımlamak
        asilList.addAll(asilList);
        Collections.shuffle(asilList);
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
                    imageButtonList.get(finalI).setImageResource((Integer) asilList.get(finalI).getImage());
                    karşılaştırma.add(imageButtonList.get(finalI).getImageMatrix());
                    if(karşılaştırma.size()==1){
                        temp=finalI;
                    }
                    if (karşılaştırma.size()==2){
                        if(karşılaştırma.get(0).equals(karşılaştırma.get(1))){
                           skor=skor+((2* asilList.get(finalI).getPuan()*asilList.get(finalI).getKatsayi())*((double) sec/10));
                            System.out.println("AYNI RESİM SKOR: "+skor+"saniye"+sec);
                            String skortext= String.valueOf(skor);
                            kolaySkor.setText(skortext);
                            imageButtonList.get(finalI).setEnabled(false);
                            imageButtonList.get(temp).setEnabled(false);
                            karşılaştırma.clear();
                            play.pause();
                            bulunduplay.start();
                            kazancsayac++;
                            if(kazancsayac==2){
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
                            temp2=finalI;
                            karşılaştırma.clear();
                            if(asilList.get(finalI).getClass().equals(asilList.get(temp).getClass())){
                                skor=(skor-(((asilList.get(finalI).getPuan()+asilList.get(temp).getPuan())/asilList.get(finalI).getKatsayi())*((45.0-(double)sec)/10.0)));
                                System.out.println("farklı resim aynı ev SKORRR"+skor+"saniye"+sec);
                                String skortext= String.valueOf(skor);
                                kolaySkor.setText(skortext);
                            }else if(!(asilList.get(finalI).getClass().equals(asilList.get(temp).getClass()))){
                                skor=skor-((((asilList.get(finalI).getPuan()+asilList.get(temp).getPuan())/2.0)*asilList.get(finalI).getKatsayi()*asilList.get(temp).getKatsayi())*((45.0-(double)sec)/10.0));
                                System.out.println("farklı resim  farklı ev SKOR"+skor+"saniye"+sec);
                                String skortext= String.valueOf(skor);
                                kolaySkor.setText(skortext);
                            }


                        }


                }}
            });
        }

      buttonseskapakolay.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              if(sessayac%2==0){
                  play.pause();
                  bulunduplay.pause();
                  buttonseskapakolay.setImageResource(R.drawable.seskapa);

              }else if(sessayac%2==1){
                  play.start();
                  buttonseskapakolay.setImageResource(R.drawable.imgg);

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