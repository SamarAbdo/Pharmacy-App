package com.example.pharmacyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddPharmacy extends AppCompatActivity {
    EditText namePharmacy,numPharmacy,addressPharmacy,facbookAcc;
    Button addbtn;
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
    }
}