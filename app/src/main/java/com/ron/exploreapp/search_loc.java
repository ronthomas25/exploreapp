package com.ron.exploreapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.ron.exploreapp.model_data.loc_search_firebasedata;
import com.ron.exploreapp.model_data.location_data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class search_loc extends AppCompatActivity {

    EditText searcher;
    ImageView search;
    RecyclerView recyclerView;
    DatabaseReference databaseReference;
    FirebaseRecyclerOptions<loc_search_firebasedata> options;
    FirebaseRecyclerAdapter<loc_search_firebasedata,viewholder> firebaseRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loc_search);

        searcher =findViewById(R.id.searchbar);

        recyclerView=findViewById(R.id.recyclerview);
        databaseReference= FirebaseDatabase.getInstance().getReference().child("location");
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

    private void firebase_search(String s) {
        Query query=databaseReference.orderByChild("place").startAt(s.toUpperCase()).endAt(s.toLowerCase()+"\uf8ff");
        options=new FirebaseRecyclerOptions.Builder<loc_search_firebasedata>().setQuery(query, loc_search_firebasedata.class).build();
        firebaseRecyclerAdapter= new FirebaseRecyclerAdapter<loc_search_firebasedata,viewholder>(options) {

            @Override
            protected void onBindViewHolder(@NonNull viewholder holder, final int position, @NonNull final loc_search_firebasedata model) {
               Glide.with(getApplicationContext()).load(model.getImg()).into(holder.image);
                holder.place.setText(model.getPlace());
                holder.place.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i=new Intent(search_loc.this,loc_search_activity.class);
                        List<location_data> locationDataList=new ArrayList<>();
                        locationDataList.add(new location_data(model.getImg(),model.getLat(),model.getLon(),
                                                model.getPlace(),model.getState()));
                        Bundle bundle=new Bundle();
                        bundle.putSerializable("data", (Serializable) locationDataList);
                        i.putExtras(bundle);
                        i.putExtra("pos",position);
                        startActivity(i);
                    }
                });

            }

            @NonNull
            @Override
            public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.search_recyclerlayout,parent,false);
                return new viewholder(view);
            }
        };
        recyclerView.setAdapter(firebaseRecyclerAdapter);
        firebaseRecyclerAdapter.startListening();
    }

    public class viewholder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView place;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.dp_image);
            place=itemView.findViewById(R.id.name);
        }
    }
}
