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
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.MyViewHolder> {
    Context context;
    ArrayList<requestmodel> requestmodels;

    public RecycleViewAdapter(Context context, ArrayList<requestmodel> requestmodels){ // corrected parameter order
        this.context = context;
        this.requestmodels = requestmodels;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.request, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

            // Bind data to views
            holder.name.setText(requestmodels.get(position).getName());
            holder.loc.setText(requestmodels.get(position).getAddress());
            holder.location.setText(requestmodels.get(position).getTime());
            holder.units.setText(requestmodels.get(position).getUnits());
            holder.Bg.setText(requestmodels.get(position).getBloodgroup());
            holder.prof.setImageResource(requestmodels.get(position).getProfile());
            holder.donate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(holder.itemView.getContext(), donation1.class);
                    holder.itemView.getContext().startActivity(intent);
                }
            });



    }




    @Override
    public int getItemCount(){
        return requestmodels.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView prof;
        TextView name,loc,location,units,Bg;
        Button donate;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            prof =  itemView.findViewById(R.id.prof);
            name =  itemView.findViewById(R.id.name);
            loc =  itemView.findViewById(R.id.loc);
            location =  itemView.findViewById(R.id.location);
            units =  itemView.findViewById(R.id.units);
            Bg =  itemView.findViewById(R.id.Bg);
            donate = itemView.findViewById(R.id.buttons);

        }
    }


}
