package com.example.myapplication2;
import static android.service.controls.ControlsProviderService.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class SifreDegistirmeEkrani extends AppCompatActivity {
    private EditText editguncelsifre,editmail,editeskisifre;
    private String txtguncelsifre,txtmail,txteskisifre;
    private FirebaseAuth mAuth;
    private FirebaseUser muser;
    private DatabaseReference reference;
    private HashMap<String,Object> mdata;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sifre_degistirme_ekrani);
        editguncelsifre=(EditText) findViewById(R.id.yenişifre);
        editmail=(EditText)findViewById(R.id.sifremail);
        editeskisifre=(EditText)findViewById(R.id.editsifreeski);
        mAuth=FirebaseAuth.getInstance();
        muser=mAuth.getCurrentUser();

    }

    public void veriyiguncelle(HashMap<String, Object>hashMap,String uid)
    {

        reference=FirebaseDatabase.getInstance().getReference("Users").child(uid);
        reference.updateChildren(hashMap).addOnCompleteListener(this,new OnCompleteListener<Void>() {

            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful())
                    Toast.makeText(SifreDegistirmeEkrani.this, "Şifre güncellendi.", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(this, new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(SifreDegistirmeEkrani.this, "veri güncellerken hata oldu.", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void sifreguncelle(HashMap<String, Object>hashMap,String uid)
    {
       // AuthCredential credential= EmailAuthProvider.getCredential(hashMap.)
    }
    public void sifredegistir(View v)
    {
        txtguncelsifre=editguncelsifre.getText().toString();
        txtmail=editmail.getText().toString();
        txteskisifre=editeskisifre.getText().toString();
        if(!TextUtils.isEmpty(txtguncelsifre))
        {
            mdata=new HashMap<>();
            mdata.put("userPassword",txtguncelsifre);
            mdata.put("userMail",txtmail);
            assert muser!=null;
            veriyiguncelle(mdata,muser.getUid());



            AuthCredential credential = EmailAuthProvider.getCredential(txtmail,txteskisifre);

            muser.reauthenticate(credential).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if(task.isSuccessful()){
                        muser.updatePassword(txtguncelsifre).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if(!task.isSuccessful()){
                                    Toast.makeText(SifreDegistirmeEkrani.this,"Something went wrong. Please try again later", Toast.LENGTH_SHORT).show();

                                }else {
                                    Toast.makeText(SifreDegistirmeEkrani.this,"Password Successfully Modified", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    }else {
                        Toast.makeText(SifreDegistirmeEkrani.this,"Authentication Failed", Toast.LENGTH_SHORT).show();

                    }
                }
            });
        }

    }
    public void anasayfa(View view)
    {
        Intent intent =new Intent(SifreDegistirmeEkrani.this, MainActivity.class);
        startActivity(intent);
    }
}