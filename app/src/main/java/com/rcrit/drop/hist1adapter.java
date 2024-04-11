package com.rcrit.drop;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class hist1adapter extends RecyclerView.Adapter<hist1adapter.MyViewHolder>{
    Context context;
    ArrayList<hist1model> hist1models;
    public hist1adapter(Context context,ArrayList<hist1model>datamodel){
        this.context = context;
        this.hist1models = hist1models;
    }
    @NonNull
    @Override
    public hist1adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.histrecycle, parent, false);
        return new hist1adapter.MyViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull hist1adapter.MyViewHolder holder, int position) {
        holder.name.setText(hist1models.get(position).getName());
        holder.loc.setText(hist1models.get(position).getAddress());
        holder.time.setText(hist1models.get(position).getTime());
        holder.units.setText(hist1models.get(position).getUnits());
        holder.Bg.setText(hist1models.get(position).getBloodgroup());
        holder.prof.setImageResource(hist1models.get(position).getProfile());

    }

    @Override
    public int getItemCount(){
        return hist1models.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView prof;
        TextView name,loc,time,units,Bg;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            prof =  itemView.findViewById(R.id.profileee);
            name =  itemView.findViewById(R.id.nameee);
            loc =  itemView.findViewById(R.id.address);
            time =  itemView.findViewById(R.id.timeee);
            units =  itemView.findViewById(R.id.unitt);
            Bg =  itemView.findViewById(R.id.Bloodgroup);
        }
    }
}

