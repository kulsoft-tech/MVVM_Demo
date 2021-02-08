package com.example.mmvmdemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mmvmdemo.R;
import com.example.mmvmdemo.model.MyPlaces;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class PlacesAdapter extends RecyclerView.Adapter<PlacesAdapter.MyPlacesViewHolder> {

    List<MyPlaces> mPlaces = new ArrayList<>();
    Context mCtx;


    public PlacesAdapter(Context mCtx, List<MyPlaces> mPlaces) {
        this.mCtx = mCtx;
        this.mPlaces = mPlaces;
    }


    @NonNull
    @Override
    public MyPlacesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mCtx).inflate(R.layout.adapter_places,parent, false);
        MyPlacesViewHolder myPlacesViewHolder = new MyPlacesViewHolder(v);
        return myPlacesViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyPlacesViewHolder holder, int position) {
        MyPlaces myPlace = mPlaces.get(position);
        holder.txtName.setText(myPlace.getName());
    }

    @Override
    public int getItemCount() {
        return mPlaces.size();
    }

    public class MyPlacesViewHolder extends RecyclerView.ViewHolder{

        ImageView img;
        TextView txtName;


        public MyPlacesViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            txtName = itemView.findViewById(R.id.txtName);
        }
    }
}
