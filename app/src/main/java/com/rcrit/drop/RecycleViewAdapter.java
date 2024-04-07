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

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.MyViewHolder> {
    Context context;
    ArrayList<requestmodel> requestmodels;
    public RecycleViewAdapter(Context context, ArrayList<requestmodel> requestmodels){
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
        if (requestmodels != null && position < requestmodels.size()) {
            holder.name.setText(requestmodels.get(position).getName());
            holder.loc.setText(requestmodels.get(position).getTime());
            holder.location.setText(requestmodels.get(position).getAddress());
            holder.units.setText(requestmodels.get(position).getUnits());
            holder.bg.setText(requestmodels.get(position).getBloodgroup());
            holder.prof.setImageResource(requestmodels.get(position).getProfile());
            holder.mDonateButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, donation1.class);
                    context.startActivity(intent);
                }
            });
        }
    }

    @Override
    public int getItemCount(){
        return requestmodels.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView prof;
        TextView name,loc,location,units,bg;
        Button mDonateButton;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            prof =  itemView.findViewById(R.id.prof);
            name =  itemView.findViewById(R.id.name);
            loc =  itemView.findViewById(R.id.loc);
            location =  itemView.findViewById(R.id.location);
            mDonateButton = itemView.findViewById(R.id.buttons);
            units =  itemView.findViewById(R.id.units);
            bg =  itemView.findViewById(R.id.bg);
        }
    }
}
