package com.example.pharmacyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button own,use;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        own =findViewById(R.id.owner);
        use =findViewById(R.id.user);
        own.setOnClickListener(this);
        use.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId()==R.id.user){
            // Toast.makeText(MainActivity.this,"User",Toast.LENGTH_LONG).show();
            Intent in=new Intent(MainActivity.this,Login.class);
            in.putExtra("bool","user");
            startActivity(in);
            finish();
        }else if (view.getId()==R.id.owner){
          //  Toast.makeText(MainActivity.this,"Owner",Toast.LENGTH_LONG).show();
            Intent in=new Intent(MainActivity.this,Login.class);
            in.putExtra("bool","owner");
            startActivity(in);
            finish();
        }
    }
}