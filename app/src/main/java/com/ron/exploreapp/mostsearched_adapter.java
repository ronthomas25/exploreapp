package com.ron.exploreapp;

import android.content.Context;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class mostsearched_adapter extends RecyclerView.Adapter<mostsearched_adapter.mostsearched_viewholder> {
    Context context;
    int image[];
    public mostsearched_adapter(Context context,int image[])
    {
        this.context=context;
        this.image=image;
    }
    @NonNull
    @Override
    public mostsearched_viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.mostsearched_layout,parent,false);
        return new mostsearched_viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull mostsearched_viewholder holder, int position) {
        holder.img.setImageResource(image[position]);
    }

    @Override
    public int getItemCount() {
        return image.length;
    }

    public class mostsearched_viewholder extends RecyclerView.ViewHolder {
        ImageView img;
        public mostsearched_viewholder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.mostsearchedimg);
        }
    }
}
