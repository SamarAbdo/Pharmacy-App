package com.example.pharmacyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends AppCompatActivity {
    Button loginBtn;
    TextView signUpTxt;
    EditText username,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginBtn=findViewById(R.id.loginbtn);
        signUpTxt=findViewById(R.id.signuptxt);
        username=findViewById(R.id.userLog);
        password=findViewById(R.id.passLog);
        String type =getIntent().getExtras().getString("bool");
        // type "1" for User -- "2" for Owner

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (username.getText().toString().isEmpty())username.setError("Not Valid");
                if (password.getText().toString().isEmpty())password.setError("Not Valid");
            }
        });
    }

    public void onClicktxt(View view) {
        Intent intent=new Intent(this,SignUp.class);
        startActivity(intent);
    }
}