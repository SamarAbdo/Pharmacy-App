package com.example.pharmacyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import static java.lang.Thread.sleep;

public class launcher extends AppCompatActivity {
TextView textView;
ImageView imageView;
Animation animation,animation2;
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
        textView=findViewById(R.id.textView);
        imageView=findViewById(R.id.imageView);
         animation=AnimationUtils.loadAnimation(this,R.anim.anim_for_launcher);
         animation2= AnimationUtils.loadAnimation(this,R.anim.for_image);
         textView.setAnimation(animation);
         imageView.setAnimation(animation2);

    Thread thread = new Thread(

    ) {
            public void run() {
                try {
                    sleep(3500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        };
        thread.start();
    }
    }
