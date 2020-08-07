package com.example.pharmacyapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.Image;
import android.net.Uri;
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
    int REQUEST_CAMERA=1,SELECT_FILE=0;
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
                final CharSequence[] items={"Camera","Gallery","Cancel"};
                AlertDialog.Builder builder=new AlertDialog.Builder(AddPharmacy.this);
                builder.setTitle("Add Image");
                builder.setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if(items[i].equals("Camera")){
                            Intent in=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                            startActivityForResult(in,REQUEST_CAMERA);
                        }else if (items[i].equals("Gallery")){
                            Intent in=new Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                            in.setType("image/*");
                            startActivityForResult(in.createChooser(in,"Select File"),SELECT_FILE);
                        }else if (items[i].equals("Cancel")){
                            dialogInterface.dismiss();
                        }
                    }

                });builder.show();



            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode== Activity.RESULT_OK){
            if (requestCode==REQUEST_CAMERA){
                Bitmap bitmap= (Bitmap) data.getExtras().get("data");
                userImg.setImageBitmap(bitmap);
            }else if (requestCode==SELECT_FILE){
                Uri selectImg=data.getData();
                userImg.setImageURI(selectImg);
            }
        }

    }
}