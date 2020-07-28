package com.example.pharmacyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Login extends AppCompatActivity {
Button LoginBtn;
TextView SignUpTxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        LoginBtn=findViewById(R.id.loginbtn);
        SignUpTxt=findViewById(R.id.signuptxt);

    }

    public void onClicktxt(View view) {
        Intent intent=new Intent(this,SignUp.class);
        startActivity(intent);

    }
}