package com.example.myapplication2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

     Button KAYDOLbutton;
     Button SİFREMİUNUTTUMbutton;
    Context context = this;
    EditText KullaniciAdi;
    EditText Sifre;

    private EditText editmail,editsifre;
    private String txtmail,txtsifre;
    private FirebaseAuth mauth;
    private FirebaseUser muser;


  @SuppressLint("MissingInflatedId")
  @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giris_ekrani);
        mauth=FirebaseAuth.getInstance();
        muser=mauth.getCurrentUser();
        KAYDOLbutton=findViewById(R.id.kaydolbutton);
        SİFREMİUNUTTUMbutton=findViewById(R.id.sifremiunuttumbutton);
        KullaniciAdi=findViewById(R.id.kullaniciAdiTexfield);
        editmail=findViewById(R.id.editgirismail);
        editsifre=findViewById(R.id.kullaniciSifreTextfield);
         SİFREMİUNUTTUMbutton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
          Intent ıntent=new Intent(context,SifreDegistirmeEkrani.class);
           startActivity(ıntent);
      }
  });


  KAYDOLbutton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
          Intent ıntent=new Intent(context,Kayitol.class);
          startActivity(ıntent);
      }
  });
  }

    public void giris(View view){
        txtmail=editmail.getText().toString();
        txtsifre=editsifre.getText().toString();
        if(!TextUtils.isEmpty(txtmail)&&!TextUtils.isEmpty(txtsifre) )
        {
            mauth.signInWithEmailAndPassword(txtmail,txtsifre)
                    .addOnSuccessListener(this, new OnSuccessListener<AuthResult>() {
                        @Override
                        public void onSuccess(AuthResult authResult) {
                            muser=mauth.getCurrentUser();
                            Intent intent=new Intent(MainActivity.this,TekOyuncu_CokOyuncuSecimi.class);
                            startActivity(intent);

                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
        }else
            Toast.makeText(this, "eksik bilgi!", Toast.LENGTH_SHORT).show();

    }




}