package com.example.pharmacyapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.ImageView;

import java.util.ArrayList;

public class UserRecyclerView extends AppCompatActivity implements RecycleViewOnItemclick{
private  RecyclerView recyclerView;
private  RecyclerView.Adapter mAdapter;
private  RecyclerView.LayoutManager layoutManager;
ArrayList<Head> arrayList;
public static final String HEAD="HEAD";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_recycler_view);
        arrayList=new ArrayList<>();
        arrayList.add(new Head("El-Shefa"," 02 42184628",R.drawable.elshefa,"Account","Address"));
        arrayList.add(new Head("El-Shefa"," 02 42184628",R.drawable.elshefa,"Account","Address"));
        arrayList.add(new Head("Dr.Abdelrhman","02 42191617",R.drawable.dr,"Account","Address"));
        arrayList.add(new Head("Dr.Abdelrhman","02 42191617",R.drawable.dr,"Account","Address"));
        arrayList.add(new Head("Maher"," 02 42188434",R.drawable.maher,"Account","Address"));
        arrayList.add(new Head("Ashry","01025768430",R.drawable.maher,"Account","Address"));


       recyclerView=findViewById(R.id.RecyclerView);
       recyclerView.setHasFixedSize(true);
       //layoutManager
       layoutManager=new LinearLayoutManager(this);
       recyclerView.setLayoutManager(layoutManager);
       //adapter
       mAdapter=new UserAdapter(arrayList,this,this);
recyclerView.setAdapter(mAdapter);
    }

    @Override
    public void OnItemClick(int position) {
        Intent intent=new Intent(UserRecyclerView.this,ShowPharmacy.class);
      Bundle bundle=new Bundle();
      bundle.putParcelable(HEAD,arrayList.get(position));
      intent.putExtras(bundle);
      startActivity(intent);


    }

   // @Override
//    public void OnLongItemClick(int position) {
//
//    }
}