package com.ron.exploreapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class rest_adapter extends RecyclerView.Adapter<rest_adapter.rest_viewholder> {
    Context context;
    int images[];
    public rest_adapter(Context context,int images[])
    {
        this.context=context;
        this.images=images;
    }

    @NonNull
    @Override
    public rest_viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.rest_layout,parent,false);
        return new rest_viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull rest_viewholder holder, int position) {
        holder.rest_image.setImageResource(images[position]);

    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public class rest_viewholder extends RecyclerView.ViewHolder{
        ImageView rest_image;
        public rest_viewholder(@NonNull View itemView) {
            super(itemView);
            rest_image=itemView.findViewById(R.id.restimg);
        }
    }
}
