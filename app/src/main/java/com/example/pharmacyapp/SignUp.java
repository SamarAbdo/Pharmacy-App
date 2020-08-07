package com.example.pharmacyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignUp extends AppCompatActivity {
    EditText firstName,lastName,password,Conpassword,email,address;
    Button signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        firstName=findViewById(R.id.fname);
        lastName=findViewById(R.id.lname);
        password=findViewById(R.id.pass);
        Conpassword=findViewById(R.id.passCon);
        address=findViewById(R.id.addressSign);
        email=findViewById(R.id.mail);
        signup=findViewById(R.id.signbtn);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!nameOk(firstName.getText().toString()))firstName.setError("First Name not Valid");
                if(!nameOk(lastName.getText().toString()))lastName.setError("Last Name not Valid");
                if (!mailOk(email.getText().toString()))email.setError("Not Valid");
                if (address.getText().toString().isEmpty())address.setError("Not Valid");
                if (!passOk(password.getText().toString()))password.setError("Not Valid");
                if (password.getText().toString()!=Conpassword.getText().toString())Conpassword.setError("Not the same password");

            }
        });

    }
    public boolean nameOk(String s){
        if (s.isEmpty())return false;
        for (int i=0;i<s.length();i++)
            if (s.charAt(i)<='A'||s.charAt(i)>='z')return false;
        return true;
    }
    public boolean passOk(String p){
        if (p.length()<8)return false;
        int f=0,l=0;
        for (int i=0;i<p.length();i++){
            if(p.charAt(i)>='A'&&p.charAt(i)<='z')f=1;
            if (p.charAt(i)>='0'&&p.charAt(i)<='9')l=1;
        }
        if (f==1&&l==1)return true;
        return false;
    }
    public boolean mailOk(String m){
        if(m.isEmpty())return false;
        int a=0,b=0,c=0,d=0,e=0;
        for (int i=0;i<m.length();i++){
            if (m.charAt(i)>='A'&&m.charAt(i)<='z'&&b==0)a=1;
            else if (m.charAt(i)=='@'&&a==1&&b==0)b=1;
            else if (m.charAt(i)>='A'&&m.charAt(i)<='z'&&b==1&&d==0)c=1;
            else if (m.charAt(i)=='.'&&c==1&&d==0)d=1;
            else if (m.charAt(i)>='A'&&m.charAt(i)<='z'&&d==1)e=1;
            else return false;
        }
        if (e==1)return true;
        return false;
    }

    public void onClktxt(View view) {
        startActivity(new Intent(SignUp.this,Login.class));
    }
}