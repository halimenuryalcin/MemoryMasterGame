package com.example.myapplication2;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;


public class Kayitol extends AppCompatActivity {
    private EditText editmail,editsifre,editisim;
    private String txtmail,txtsifre,txtisim;
    private FirebaseAuth mauth;
    private DatabaseReference mReference;
    private HashMap<String,Object> mData;
    private FirebaseUser muser;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kayitol);
        editisim=(EditText) findViewById(R.id.editTextKayitAd);
        editmail=(EditText) findViewById(R.id.editTextKayitmail);
        editsifre=(EditText) findViewById(R.id.editTextKayitsifre);
        mauth=FirebaseAuth.getInstance();
        mReference= FirebaseDatabase.getInstance().getReference();
    }
    public void kayitol(View view){
       txtisim=editisim.getText().toString();
       txtmail=editmail.getText().toString();
       txtsifre=editsifre.getText().toString();
       if(!TextUtils.isEmpty(txtmail)&&!TextUtils.isEmpty(txtsifre)&&!TextUtils.isEmpty(txtisim)){
           mauth.createUserWithEmailAndPassword(txtmail,txtsifre)
                   .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                       @Override
                       public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {   muser=mauth.getCurrentUser();
                            mData=new HashMap<>();
                            mData.put("userName",txtisim);
                            mData.put("userId",muser.getUid());
                            mData.put("userMail",txtmail);
                            mData.put("userPassword",txtsifre);
                            mReference.child("Users").child(muser.getUid()).setValue(mData)
                                    .addOnCompleteListener(Kayitol.this, new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            if(task.isSuccessful())
                                                Toast.makeText(Kayitol.this, "Kayit Basarili.", Toast.LENGTH_SHORT).show();
                                            else
                                                Toast.makeText(Kayitol.this, "Son anda hata olustu.", Toast.LENGTH_SHORT).show();

                                        }
                                    });
                        }
                       }
                   });
       }
       else
           Toast.makeText(this, "Bos yerleri doldurunuz.", Toast.LENGTH_SHORT).show();
    }
    public void anasayfa(View view)
    {
        Intent intent =new Intent(Kayitol.this,MainActivity.class);
        startActivity(intent);
    }

}