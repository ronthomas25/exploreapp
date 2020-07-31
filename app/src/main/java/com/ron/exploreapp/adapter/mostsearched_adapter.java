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
import com.ron.exploreapp.model_data.mostsearched_data;
import com.ron.exploreapp.mostsearched_activity;

import java.io.Serializable;
import java.util.List;

public class mostsearched_adapter extends RecyclerView.Adapter<mostsearched_adapter.mostsearched_viewholder> {
    Context context;
    List<mostsearched_data> mostsearchedDataList;
    public mostsearched_adapter(Context context, List<mostsearched_data> mostsearchedDataList)
    {
        this.context=context;
        this.mostsearchedDataList=mostsearchedDataList;
    }
    @NonNull
    @Override
    public mostsearched_viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.mostsearched_layout,parent,false);
        return new mostsearched_viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull mostsearched_viewholder holder, final int position) {
        holder.img.setImageResource(mostsearchedDataList.get(position).getImg(0));
        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, mostsearched_activity.class);
                Bundle bundle=new Bundle();
                bundle.putSerializable("data", (Serializable) mostsearchedDataList);
                intent.putExtras(bundle);
                intent.putExtra("pos",position);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mostsearchedDataList.size();
    }

    public class mostsearched_viewholder extends RecyclerView.ViewHolder {
        ImageView img;
        public mostsearched_viewholder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.mostsearchedimg);
        }
    }
}
