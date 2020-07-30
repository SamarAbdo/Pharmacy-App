package com.example.pharmacyapp;

import android.content.Context;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MViewHolder> {

List<Head> list;
Context context;

    public UserAdapter(List<Head> list, Context context) {
        this.list = list;
        this.context = context;
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
        return list.size();
    }

    class MViewHolder extends RecyclerView.ViewHolder {
         TextView PharmacyName, PharmacyAddress, PharmacyNum, PharmacyImg;

        public MViewHolder(@NonNull View itemView) {
            super(itemView);
            PharmacyAddress = itemView.findViewById(R.id.pharmacyAddress);

        }

        public void bind(int position) {
            Head head=list.get(position);
        }
    }
}