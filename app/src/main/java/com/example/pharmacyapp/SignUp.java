package com.example.pharmacyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SignUp extends AppCompatActivity {
    EditText username,password,Conpassword,email,address;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        username=findViewById(R.id.userSign);
        password=findViewById(R.id.pass);
        Conpassword=findViewById(R.id.passCon);
        address=findViewById(R.id.addressSign);
        email=findViewById(R.id.mail);
        
    }

    public void onClktxt(View view) {
        startActivity(new Intent(SignUp.this,Login.class));
    }
}