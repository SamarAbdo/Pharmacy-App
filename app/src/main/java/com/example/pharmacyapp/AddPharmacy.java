package com.example.pharmacyapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.media.Image;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class AddPharmacy extends AppCompatActivity {
    EditText namePharmacy,numPharmacy,addressPharmacy,facbookAcc;
    Button addbtn,uploadbtn;
    ImageView userImg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_pharmacy);
        namePharmacy=findViewById(R.id.addPharmacyName);
        numPharmacy=findViewById(R.id.addPhone);
        addressPharmacy=findViewById(R.id.addPharmacyAddress);
        facbookAcc=findViewById(R.id.facebookAcc);
        addbtn=findViewById(R.id.addPharma);
        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(namePharmacy.getText().toString().isEmpty())namePharmacy.setError("Not Valid");
                if(numPharmacy.getText().toString().isEmpty())numPharmacy.setError("Not Valid");
                if(addressPharmacy.getText().toString().isEmpty())addressPharmacy.setError("Not Valid");
            }
        });
        uploadbtn=findViewById(R.id.uploadImage);
        userImg=findViewById(R.id.userImage);
        uploadbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(in,0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bitmap bitmap= (Bitmap) data.getExtras().get("data");
        userImg.setImageBitmap(bitmap);
    }
}