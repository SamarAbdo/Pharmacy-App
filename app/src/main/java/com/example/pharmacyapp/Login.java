package com.example.pharmacyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    Button loginBtn;
    TextView signUpTxt;
    EditText username,password;

   String string="";
    // type "1" for User -- "2" for Owner
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginBtn=findViewById(R.id.loginbtn);
        signUpTxt=findViewById(R.id.signuptxt);
        username=findViewById(R.id.userLog);
        password=findViewById(R.id.passLog);


        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((username.getText().toString().isEmpty()) || (password.getText().toString().isEmpty())) {
                    if (username.getText().toString().isEmpty()) username.setError("Not Valid");
                    if (password.getText().toString().isEmpty()) password.setError("Not Valid");
                }
                else {
                    if(getIntent().getExtras()!=null) {
                        Bundle bundle = getIntent().getExtras();
                        final String type = bundle.getString("bool");

                        if (type.equals("user")) {
                            Intent intent = new Intent(Login.this, UserRecyclerView.class);
                            startActivity(intent);
                        } else {
                            Intent intent = new Intent(Login.this, OwnerRecyclerView.class);
                            startActivity(intent);
                        }
                    }
                }
            }
        });
    }

    public void onClicktxt(View view) {
        Intent intent=new Intent(this,SignUp.class);
        string=getIntent().getExtras().getString("bool");
        intent.putExtra("bool",string);
       // Toast.makeText(Login.this,string,Toast.LENGTH_SHORT).show();
        startActivity(intent);
    }
}