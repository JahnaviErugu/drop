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

import java.util.ArrayList;
import androidx.recyclerview.widget.RecyclerView;

public class Postedrecycleviewadapter extends RecyclerView.Adapter<Postedrecycleviewadapter.MyViewHolder> {
    Context context;
    ArrayList<dataclass> datamodel;
    public Postedrecycleviewadapter(Context context,ArrayList<dataclass>datamodel){
        this.context = context;
        this.datamodel = datamodel;
    }
    @NonNull
    @Override
    public Postedrecycleviewadapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.postreq, parent, false);
        return new Postedrecycleviewadapter.MyViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull Postedrecycleviewadapter.MyViewHolder holder, int position) {
            holder.name.setText(datamodel.get(position).getName());
            holder.loc.setText(datamodel.get(position).getAddress());
            holder.time.setText(datamodel.get(position).getTime());
            holder.units.setText(datamodel.get(position).getUnits());
            holder.Bg.setText(datamodel.get(position).getBloodgroup());
            holder.prof.setImageResource(datamodel.get(position).getProfile());
            holder.buttons.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, donation1.class);
                    context.startActivity(intent);
                }
            });
    }

    @Override
    public int getItemCount(){
        return datamodel.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView prof;
        TextView name,loc,time,units,Bg;
        Button buttons;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            prof =  itemView.findViewById(R.id.profilee);
            name =  itemView.findViewById(R.id.namee);
            loc =  itemView.findViewById(R.id.locationn);
            time =  itemView.findViewById(R.id.timee);
            buttons = itemView.findViewById(R.id.buttonss);
            units =  itemView.findViewById(R.id.unitss);
            Bg =  itemView.findViewById(R.id.bloodgroup);
        }
    }
}
