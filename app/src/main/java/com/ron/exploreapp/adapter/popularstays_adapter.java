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

import com.bumptech.glide.Glide;
import com.ron.exploreapp.R;
import com.ron.exploreapp.model_data.popularstays_data;
import com.ron.exploreapp.popularstays_activity;

import java.io.Serializable;
import java.util.List;

public class popularstays_adapter extends RecyclerView.Adapter<popularstays_adapter.popularstays_viewholder> {
    Context context;
    List<popularstays_data> popularstaysDataList;
    public popularstays_adapter(Context context, List<popularstays_data> popularstaysDataList)
    {
        this.context=context;
        this.popularstaysDataList=popularstaysDataList;
    }
    @NonNull
    @Override
    public popularstays_viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.popularstays_layout,parent,false);
        return new popularstays_viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull popularstays_viewholder holder, final int position) {
        Glide.with(context).load(popularstaysDataList.get(position).getImg_outer()).dontTransform().into(holder.img);
        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, popularstays_activity.class);
                Bundle bundle=new Bundle();
                bundle.putSerializable("data", (Serializable) popularstaysDataList);
                intent.putExtras(bundle);
                intent.putExtra("pos",position);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return popularstaysDataList.size();
    }

    public class popularstays_viewholder extends RecyclerView.ViewHolder {
        ImageView img;
        public popularstays_viewholder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.popularstaysimg);
        }
    }
}
