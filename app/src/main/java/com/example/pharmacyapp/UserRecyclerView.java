package com.example.pharmacyapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import java.util.ArrayList;

public class UserRecyclerView extends AppCompatActivity {
private  RecyclerView recyclerView;
private  RecyclerView.Adapter mAdapter;
private  RecyclerView.LayoutManager layoutManager;
ArrayList<Head> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_recycler_view);
        arrayList=new ArrayList<>();
        arrayList.add(new Head("El-Shefa"," 02 42184628",R.drawable.elshefa));
        arrayList.add(new Head("Dr.Abdelrhman","02 42191617",R.drawable.dr));
        arrayList.add(new Head("Maher"," 02 42188434",R.drawable.maher));
        arrayList.add(new Head("Ashry","01025768430",R.drawable.ph));


       recyclerView=findViewById(R.id.RecyclerView);
       recyclerView.setHasFixedSize(true);
       //layoutManager
       layoutManager=new LinearLayoutManager(this);
       recyclerView.setLayoutManager(layoutManager);
       //adapter
       mAdapter=new UserAdapter(arrayList,this);
recyclerView.setAdapter(mAdapter);
    }
}