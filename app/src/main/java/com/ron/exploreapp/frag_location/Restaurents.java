package com.ron.exploreapp.frag_location;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.ron.exploreapp.R;
import com.ron.exploreapp.model_data.rest_firebasedata;


public class Restaurents extends Fragment {

    FirebaseRecyclerAdapter<rest_firebasedata,viewholder> firebaseRecyclerAdapter;
    FirebaseRecyclerOptions<rest_firebasedata> options;
    RecyclerView recyclerView;
    String name;
    DatabaseReference databaseReference;


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public Restaurents() {
    }

    public static Restaurents newInstance(String param1, String param2) {
        Restaurents fragment = new Restaurents();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
       View view= inflater.inflate(R.layout.fragment_restaurents, container, false);

        recyclerView=view.findViewById(R.id.loc_rest_recycler);
        Bundle bundle=getArguments();
        name=bundle.getString("placename");
        databaseReference= FirebaseDatabase.getInstance().getReference().child("location").child(name).child("restaurents");
        rest_recycler();

       return view;
    }

    void rest_recycler()
    {
      options=new FirebaseRecyclerOptions.Builder<rest_firebasedata>().setQuery(databaseReference,rest_firebasedata.class).build();
      firebaseRecyclerAdapter=new FirebaseRecyclerAdapter<rest_firebasedata,viewholder>(options) {
          @Override
          protected void onBindViewHolder(@NonNull viewholder holder, int position, @NonNull rest_firebasedata model) {
              Glide.with(getContext()).load(model.getImage()).into(holder.image);
              holder.place.setText(model.getPlace());
              Toast.makeText(getContext(),model.getPlace(),Toast.LENGTH_LONG). show();
          }

          @NonNull

          @Override
          public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
              View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.search_recyclerlayout,parent,false);
              return new viewholder(view);
          }
      };
      recyclerView.setAdapter(firebaseRecyclerAdapter);
     // firebaseRecyclerAdapter.startListening();
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

    @Override
    public void onStart() {
        super.onStart();
        firebaseRecyclerAdapter.startListening();
    }
}