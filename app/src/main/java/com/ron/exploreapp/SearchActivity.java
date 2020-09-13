package com.ron.exploreapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.ron.exploreapp.model_data.rest_firebasedata;
import com.ron.exploreapp.model_data.search_rest_data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends BaseActivity {

     EditText searcher;
     ImageView search;
     RecyclerView recyclerView;
     DatabaseReference databaseReference;
     FirebaseRecyclerOptions<rest_firebasedata> options;
     FirebaseRecyclerAdapter<rest_firebasedata,viewholder> firebaseRecyclerAdapter;

    @Override
    int getLayoutId() {
        return R.layout.activity_search;
    }

    @Override
    int getBottomNavigationMenuItemId() {
        return R.id.action_search;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        searcher =findViewById(R.id.searchbar);
        recyclerView=findViewById(R.id.recyclerview);
        databaseReference= FirebaseDatabase.getInstance().getReference().child("searchrestaurants");
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        firebase_search("");
        searcher.addTextChangedListener(new TextWatcher() {
           @Override
           public void beforeTextChanged(CharSequence s, int start, int count, int after) {

           }

           @Override
           public void onTextChanged(CharSequence s, int start, int before, int count) {

           }

           @Override
           public void afterTextChanged(Editable s) {

               if(s.toString()!=null){
                   firebase_search(s.toString());
               }
               else{
                   firebase_search("");
               }
           }
       });

    }

    private void firebase_search(String s){
      Query query=databaseReference.orderByChild("place").startAt(s.toUpperCase()).endAt(s.toLowerCase()+"\uf8ff");
      options=new FirebaseRecyclerOptions.Builder<rest_firebasedata>().setQuery(query,rest_firebasedata.class).build();
      firebaseRecyclerAdapter=new FirebaseRecyclerAdapter<rest_firebasedata,viewholder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull viewholder holder, int position, @NonNull final rest_firebasedata model) {
                Glide.with(getApplicationContext()).load(model.getImage()).into(holder.image);
                holder.place.setText(model.getPlace());
                holder.place.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                     Intent i=new Intent(SearchActivity.this,rest_search_activity.class);
                     List<search_rest_data> searchRestData=new ArrayList<>();
                     searchRestData.add(new search_rest_data(model.getDesc(),model.getImage(),model.getImageInner(),model.getLat(),model.getLon(),
                                                 model.getPlace(),model.getRating(),model.getState()));
                     Bundle bundle=new Bundle();
                     bundle.putSerializable("data", (Serializable) searchRestData);
                     i.putExtras(bundle);
                    /* i.putExtra("desc",model.getDesc());
                     i.putExtra("place",model.getPlace());
                     i.putExtra("image",model.getImage());
                     i.putExtra("lat",model.getLat());
                     i.putExtra("lon",model.getLon());
                     i.putExtra("rating",model.getRating());
                     i.putExtra("state",model.getState());*/
                     startActivity(i);
                    }
                });

            }

            @NonNull
            @Override
            public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.search_recyclerlayout,parent,false);
                return new viewholder(view);
            }
        };
       recyclerView.setAdapter(firebaseRecyclerAdapter);
       firebaseRecyclerAdapter.startListening();
    }

    public static class viewholder extends RecyclerView.ViewHolder{

        public ImageView image;
        public TextView place;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.dp_image);
            place=itemView.findViewById(R.id.name);
        }
    }
}