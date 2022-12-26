package com.example.myapplication2;

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
import com.example.myapplication2.Houses.Hufflepuff;
import com.example.myapplication2.Houses.Ravenclaw;
import com.example.myapplication2.Houses.Slytherin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class ZorOyunEkrani extends AppCompatActivity {

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
    ImageButton imageButtonOrt17;
    ImageButton imageButtonOrt18;
    ImageButton imageButtonOrt19;
    ImageButton imageButtonOrt20;
    ImageButton imageButtonOrt21;
    ImageButton imageButtonOrt22;
    ImageButton imageButtonOrt23;
    ImageButton imageButtonOrt24;
    ImageButton imageButtonOrt25;
    ImageButton imageButtonOrt26;
    ImageButton imageButtonOrt27;
    ImageButton imageButtonOrt28;
    ImageButton imageButtonOrt29;
    ImageButton imageButtonOrt30;
    ImageButton imageButtonOrt31;
    ImageButton imageButtonOrt32;
    ImageButton imageButtonOrt33;
    ImageButton imageButtonOrt34;
    ImageButton imageButtonOrt35;
    ImageButton imageButtonOrt36;
    CountDownTimer countDownTimer;
    Context context = this;
    TextView txtTimer;
    MediaPlayer play;
    MediaPlayer bulunduplay;
    MediaPlayer sureplay;
    ImageButton sesackapazor;
    int sessayac=2;
    TextView skorzortext;


    List<Houses>imageList=new ArrayList<>();

    List<Object>karşılaştırma=new ArrayList<>();
    int temp;
    int temp2;
    int sayac=0;
    double skor=0;
    int sec;
    int kazancsayac=0;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zor_oyun_ekrani);
        imageButtonOrt1=findViewById(R.id.imageButtonzor1);
        imageButtonOrt2=findViewById(R.id.imageButtonzor2);
        imageButtonOrt3=findViewById(R.id.imageButtonzor3);
        imageButtonOrt4=findViewById(R.id.imageButtonzor4);
        imageButtonOrt5=findViewById(R.id.imageButtonzor5);
        imageButtonOrt6=findViewById(R.id.imageButtonzor6);
        imageButtonOrt7=findViewById(R.id.imageButtonzor7);
        imageButtonOrt8=findViewById(R.id.imageButtonzor8);
        imageButtonOrt9=findViewById(R.id.imageButtonzor9);
        imageButtonOrt10=findViewById(R.id.imageButtonzor10);
        imageButtonOrt11=findViewById(R.id.imageButtonzor11);
        imageButtonOrt12=findViewById(R.id.imageButtonzor12);
        imageButtonOrt13=findViewById(R.id.imageButtonzor13);
        imageButtonOrt14=findViewById(R.id.imageButtonzor14);
        imageButtonOrt15=findViewById(R.id.imageButtonzor15);
        imageButtonOrt16=findViewById(R.id.imageButtonzor16);
        imageButtonOrt17=findViewById(R.id.imageButtonzor17);
        imageButtonOrt18=findViewById(R.id.imageButtonzor18);
        imageButtonOrt19=findViewById(R.id.imageButtonzor19);
        imageButtonOrt20=findViewById(R.id.imageButtonzor20);
        imageButtonOrt21=findViewById(R.id.imageButtonzor21);
        imageButtonOrt22=findViewById(R.id.imageButtonzor22);
        imageButtonOrt23=findViewById(R.id.imageButtonzor23);
        imageButtonOrt24=findViewById(R.id.imageButtonzor24);
        imageButtonOrt25=findViewById(R.id.imageButtonzor25);
        imageButtonOrt26=findViewById(R.id.imageButtonzor26);
        imageButtonOrt27=findViewById(R.id.imageButtonzor27);
        imageButtonOrt28=findViewById(R.id.imageButtonzor28);
        imageButtonOrt29=findViewById(R.id.imageButtonzor29);
        imageButtonOrt30=findViewById(R.id.imageButtonzor30);
        imageButtonOrt31=findViewById(R.id.imageButtonzor31);
        imageButtonOrt32=findViewById(R.id.imageButtonzor32);
        imageButtonOrt33=findViewById(R.id.imageButtonzor33);
        imageButtonOrt34=findViewById(R.id.imageButtonzor34);
        imageButtonOrt35=findViewById(R.id.imageButtonzor35);
        imageButtonOrt36=findViewById(R.id.imageButtonzor36);
        play=MediaPlayer.create(this,R.raw.anamuzik);
        play.start();
        bulunduplay=MediaPlayer.create(this,R.raw.bulundu);
        sesackapazor=findViewById(R.id.sesackapazor);
        skorzortext=findViewById(R.id.textViewskorzor);



        Gryffindor Harry=new Gryffindor(R.drawable.harryimage,"Harry",10);
        Gryffindor Dumbledore=new Gryffindor(R.drawable.dumbledoreimage,"Dumbledore",20);
        Gryffindor Ron=new Gryffindor(R.drawable.ronimage,"Ron",8);
        Gryffindor Hermione=new Gryffindor(R.drawable.hermioneimage,"Hermione",10);
        Gryffindor McGonagall=new Gryffindor(R.drawable.mcgonagallimage,"McGonagall",13);

        Slytherin LuciusMalfoy=new Slytherin(R.drawable.luciusimage,"Lucius",12);
        Slytherin Severus=new Slytherin(R.drawable.severusimage,"Severus",18);
        Slytherin TomRiddle=new Slytherin(R.drawable.tomriddleimage,"Tom Riddle",20);
        Slytherin Draco=new Slytherin(R.drawable.dracoimage,"Draco",5);

        Ravenclaw Rovena=new Ravenclaw(R.drawable.rovenaimage,"Rovena",20);
        Ravenclaw Luna=new Ravenclaw(R.drawable.lunaimage,"Luna",9);
        Ravenclaw Chocahng=new Ravenclaw(R.drawable.choimage,"Chocang",11);
        Ravenclaw Filius=new Ravenclaw(R.drawable.filiusimage,"Filius",10);
        Ravenclaw Gilderoy=new Ravenclaw(R.drawable.gilderyimage,"Gilderoy",13);


        Hufflepuff Helga=new Hufflepuff(R.drawable.helgaimage,"Helga",20);
        Hufflepuff Cedric=new Hufflepuff(R.drawable.cedricimage,"Cedric",18);
        Hufflepuff Pomona=new Hufflepuff(R.drawable.pomomaimage,"Pomona",10);
        Hufflepuff Fatfriar=new Hufflepuff(R.drawable.fatfriarimage,"FatFriar",12);



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
        imageButtonList.add(imageButtonOrt17);
        imageButtonList.add(imageButtonOrt18);
        imageButtonList.add(imageButtonOrt19);
        imageButtonList.add(imageButtonOrt20);
        imageButtonList.add(imageButtonOrt21);
        imageButtonList.add(imageButtonOrt22);
        imageButtonList.add(imageButtonOrt23);
        imageButtonList.add(imageButtonOrt24);
        imageButtonList.add(imageButtonOrt25);
        imageButtonList.add(imageButtonOrt26);
        imageButtonList.add(imageButtonOrt27);
        imageButtonList.add(imageButtonOrt28);
        imageButtonList.add(imageButtonOrt29);
        imageButtonList.add(imageButtonOrt30);
        imageButtonList.add(imageButtonOrt31);
        imageButtonList.add(imageButtonOrt32);
        imageButtonList.add(imageButtonOrt33);
        imageButtonList.add(imageButtonOrt34);
        imageButtonList.add(imageButtonOrt35);
        imageButtonList.add(imageButtonOrt36);
        Intent intent = getIntent();
        int milisec = intent.getIntExtra("milisec",0);
        txtTimer=findViewById(R.id.textViewzorsure);
        sureplay=MediaPlayer.create(this,R.raw.surebitince);





        int backImage=(R.drawable.ic_menu_help);
        imageList.add(Draco);
        imageList.add(Dumbledore);
        imageList.add(TomRiddle);
        imageList.add(Ron);
        imageList.add(McGonagall);
        imageList.add(Hermione);
        imageList.add(Harry);
        imageList.add(Severus);
        imageList.add(LuciusMalfoy);
        imageList.add(Rovena);
        imageList.add(Luna);
        imageList.add(Helga);
        imageList.add(Cedric);
        imageList.add(Gilderoy);
        imageList.add(Chocahng);
        imageList.add(Filius);
        imageList.add(Pomona);
        imageList.add(Fatfriar);
        imageList.addAll(imageList);
        Collections.shuffle(imageList);

        for (int i=0;i<imageButtonList.size();i++){
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
                          skorzortext.setText(skortext);
                            imageButtonList.get(finalI).setEnabled(false);
                            imageButtonList.get(temp).setEnabled(false);
                            karşılaştırma.clear();
                            play.pause();
                            bulunduplay.start();
                            kazancsayac++;
                            if(kazancsayac==18){
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
                                skorzortext.setText(skortext);
                            }else if(!(imageList.get(finalI).getClass().equals(imageList.get(temp).getClass()))){
                                skor=skor-((((imageList.get(finalI).getPuan()+imageList.get(temp).getPuan())/2.0)*imageList.get(finalI).getKatsayi()*imageList.get(temp).getKatsayi())*((45.0-(double)sec)/10.0));
                                System.out.println("farklı resim  farklı ev SKOR"+skor+"saniye"+sec);
                                String skortext= String.valueOf(skor);
                                skorzortext.setText(skortext);
                            }


                        }


                    }}
            });
        }
        sesackapazor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(sessayac%2==0){
                    play.pause();
                    bulunduplay.pause();
                   sesackapazor.setImageResource(R.drawable.seskapa);

                }else if(sessayac%2==1){
                    play.start();
                    sesackapazor.setImageResource(R.drawable.imgg);

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