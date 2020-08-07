package com.example.pharmacyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.regex.Pattern;

public class SignUp extends AppCompatActivity {
    private static final Pattern passwordPattern=
            Pattern.compile("^" +
                    "(?=.*[0-9])" +         //at least 1 digit
                   // "(?=.*[a-z])" +         //at least 1 lower case letter
                    "(?=.*[A-Z])" +         //at least 1 upper case letter
                    "(?=.*[a-zA-Z])" +      //any letter
                    //"(?=.*[@#$%^&+=])" +    //at least 1 special character
                    "(?=\\S+$)" +           //no white spaces
                    ".{8,}" +               //at least 4 characters
                    "$");


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

                if (!validateFName()||!validateLName()||!validateEmail()||!validateAddress()||!validatePassword()||!validateCPassword())
                {
                    return;
                }
                else
                {
                    if(getIntent().getExtras()!=null) {
                        Bundle bundle = getIntent().getExtras();
                        final String type = bundle.getString("bool");

                        if (type.equals("user")) {
                            Intent intent = new Intent(SignUp.this, UserRecyclerView.class);
                            startActivity(intent);
                        } else {
                            Intent intent = new Intent(SignUp.this, OwnerRecyclerView.class);
                            startActivity(intent);
                        }
                }
                }
            }
        });//

    }
    public boolean validateFName(){
        if (firstName.getText().toString().isEmpty()) {
            firstName.setError("Field can't be empty");
        return false;
        }
        else if (!firstName.getText().toString().matches("[a-z,A-Z]*")) {
            firstName.setError("Enter only character");
            return false;
        }
        else
            {
            firstName.setError(null);
            return true;
        }
    }
    public boolean validateLName(){
        if (lastName.getText().toString().isEmpty()) {
            lastName.setError("Field can't be empty");
        return false;
        }
        else if (!lastName.getText().toString().matches("[a-z,A-Z]*")) {
            lastName.setError("Enter only character");
            return false;
        }
        else
            {
        lastName.setError(null);
            return true;
        }
    }
    public boolean validatePassword(){
        if (password.getText().toString().isEmpty()) {
            password.setError("Field can't be empty");
        return false;
        }
        else if (!passwordPattern.matcher(password.getText().toString()).matches()) {
            password.setError("Password too weak");
            return false;
        }
        else
            {
        password.setError(null);
            return true;
        }
    }
    public boolean validateCPassword(){
        if (Conpassword.getText().toString().isEmpty()) {
            Conpassword.setError("Field can't be empty");
        return false;
        }
        else if (!password.getText().toString().equals(Conpassword.getText().toString())) {
            Conpassword.setError("Password not the same");
            return false;
        }
        else
            {
        Conpassword.setError(null);
            return true;
        }
    }
    public boolean validateEmail(){
        if (email.getText().toString().isEmpty()) {
         email.setError("Field can't be empty");
        return false;
        }
        else if (!Patterns.EMAIL_ADDRESS.matcher(email.getText().toString()).matches()) {
            email.setError("Enter valid email");
            return false;
        }
        else
            {
        email.setError(null);
            return true;
        }
    }
    public boolean validateAddress(){
        if (address.getText().toString().isEmpty()) {
         address.setError("Field can't be empty");
        return false;
        }

        else
            {
        address.setError(null);
            return true;
        }
    }

    public void onClktxt(View view) {
        startActivity(new Intent(SignUp.this,Login.class));
    }
}