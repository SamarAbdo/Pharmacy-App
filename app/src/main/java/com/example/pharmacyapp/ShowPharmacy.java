package com.example.pharmacyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.lang.reflect.ParameterizedType;

import static com.example.pharmacyapp.UserRecyclerView.HEAD;

public class ShowPharmacy extends AppCompatActivity {
ImageView imageView;
TextView pharmacyName,pharmacyPhone,pharmacyAddress,pharmacyAccount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_show_pharmacy);
        imageView=findViewById(R.id.pharmacyImage);
        pharmacyName=findViewById(R.id.pharmacyName);
        pharmacyPhone=findViewById(R.id.pharmacyPhone);
        pharmacyAddress=findViewById(R.id.pharmacyAddress);
        pharmacyAccount=findViewById(R.id.pharmacyAccount);

        Picasso.get().load(R.drawable.ph);

           Head head = getIntent().getExtras().getParcelable(HEAD);//getParcelableExtra(HEAD);

           pharmacyName.setText(head.getPharmacyName());
           pharmacyPhone.setText(head.getPharmacyNum());
           imageView.setImageResource(head.getPharmacyImg());
         //  pharmacyAddress.setText(head.getPharmacyAddress());
         //  pharmacyAccount.setText(head.getPharmacyAccount());


    }
}
