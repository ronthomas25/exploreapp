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
import com.ron.exploreapp.model_data.hotels_data;
import com.ron.exploreapp.model_data.hotels_data;
import com.ron.exploreapp.hotels_activity;

import java.io.Serializable;
import java.util.List;

public class hotels_adapter extends RecyclerView.Adapter<hotels_adapter.hotels_viewholder> {
    Context context;
    List<hotels_data> hotelsDataList;
    public hotels_adapter(Context context, List<hotels_data> hotelsDataList)
    {
        this.context=context;
        this.hotelsDataList=hotelsDataList;
    }
    @NonNull
    @Override
    public hotels_viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.hotels_layout,parent,false);
        return new hotels_viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull hotels_viewholder holder, final int position) {
        Glide.with(context).load(hotelsDataList.get(position).getImg_outer()).dontTransform().into(holder.img);
        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, hotels_activity.class);
                Bundle bundle=new Bundle();
                bundle.putSerializable("data", (Serializable) hotelsDataList);
                intent.putExtras(bundle);
                intent.putExtra("pos",position);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return hotelsDataList.size();
    }

    public class hotels_viewholder extends RecyclerView.ViewHolder {
        ImageView img;
        public hotels_viewholder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.hotelsimg);
        }
    }
}
