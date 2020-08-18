package com.ron.exploreapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ron.exploreapp.R;
import com.ron.exploreapp.model_data.restaurent_data;
import com.ron.exploreapp.rest_activity;

import java.io.Serializable;
import java.util.List;

public class rest_adapter extends RecyclerView.Adapter<rest_adapter.rest_viewholder> {
    Context context;
    List<restaurent_data> restaurentDataList;
    public rest_adapter(Context context, List<restaurent_data> restaurentDataList)
    {
        this.context=context;
        this.restaurentDataList=restaurentDataList;
    }

    @NonNull
    @Override
    public rest_viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.rest_layout,parent,false);
        return new rest_viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull rest_viewholder holder, final int position) {
        holder.rest_image.setImageResource(restaurentDataList.get(position).getImg(0));
        holder.rest_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, rest_activity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("data", (Serializable) restaurentDataList);
                intent.putExtras(bundle);
                intent.putExtra("pos", position);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return restaurentDataList.size();
    }

    public class rest_viewholder extends RecyclerView.ViewHolder{
        ImageView rest_image;
        public rest_viewholder(@NonNull View itemView) {
            super(itemView);
            rest_image=itemView.findViewById(R.id.restimg);
        }
    }
}
