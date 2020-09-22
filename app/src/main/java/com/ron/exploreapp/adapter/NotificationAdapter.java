package com.ron.exploreapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.denzcoskun.imageslider.ImageSlider;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.ron.exploreapp.model_data.Notification;
import com.ron.exploreapp.R;


public class NotificationAdapter extends FirestoreRecyclerAdapter<Notification,NotificationAdapter.NotificationHolder> {

    Context context;

    public NotificationAdapter(@NonNull FirestoreRecyclerOptions<Notification> options,Context context) {
        super(options);
        this.context=context;
    }

    @Override
    protected void onBindViewHolder(@NonNull NotificationHolder holder, int position, @NonNull Notification model) {
      //  holder.textViewTitle.setText(model.getTitle());
        Glide.with(context).load(model.getImage()).into(holder.notification_img);
        holder.textViewDescription.setText(model.getDescription());
        holder.textViewPriority.setText(String.valueOf(model.getPriority()));
    }

    @NonNull
    @Override
    public NotificationHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.notification_item,parent, false);
        return new NotificationHolder(v);
    }

    class NotificationHolder extends RecyclerView.ViewHolder {

        TextView textViewTitle;
        TextView textViewDescription;
        TextView textViewPriority;
        ImageView notification_img;

        public NotificationHolder(@NonNull View itemView) {
            super(itemView);
          //  textViewTitle = itemView.findViewById(R.id.text_view_title);
            textViewDescription = itemView.findViewById(R.id.text_view_description);
            textViewPriority = itemView.findViewById(R.id.text_view_priority);
            notification_img=itemView.findViewById(R.id.notification_img);
        }
    }
}
