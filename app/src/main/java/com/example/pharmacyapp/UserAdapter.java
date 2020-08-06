package com.example.pharmacyapp;

import android.content.Context;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.squareup.picasso.Picasso;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MViewHolder> {

List<Head> arrayList;
Context context;
public ImageView imageView;
public TextView name;
public TextView phone;
public RecycleViewOnItemclick recycleViewOnItemclick;

    public UserAdapter(List<Head> arrayList, Context context ,RecycleViewOnItemclick recycleViewOnItemclick) {
        this.arrayList = arrayList;
        this.context = context;

        this.recycleViewOnItemclick = recycleViewOnItemclick;
    }

    @NonNull
    @Override
    public MViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.row,parent,false);
        return new MViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MViewHolder holder, int position) {
    holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class MViewHolder extends RecyclerView.ViewHolder {

        public MViewHolder(@NonNull View itemView) {
            super(itemView);

imageView=itemView.findViewById(R.id.pharmacyImage);
name=itemView.findViewById(R.id.pharmacyName);
phone=itemView.findViewById(R.id.pharmacyPhone);
itemView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        recycleViewOnItemclick.OnItemClick(getAdapterPosition());
    }
});

//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    recycleViewOnItemclick.OnLongItemClick(getAdapterPosition());
//                }
//            });
        }

        public void bind(int position) {
            Head head=arrayList.get(position);
            name.setText(head.getPharmacyName());
         phone.setText(head.getPharmacyNum());
         //TODO: Use Picasso to load images (prevent Memory leak)
            Picasso.get().load(head.getPharmacyImg()).into(imageView);
         //imageView.setImageResource(head.getPharmacyImg());
        }
    }
    public interface onNoteListener{
void onNoteclick(int position);

    }
}