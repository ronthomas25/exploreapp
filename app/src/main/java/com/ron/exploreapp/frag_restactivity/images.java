package com.ron.exploreapp.frag_restactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.ron.exploreapp.R;
import com.ron.exploreapp.adapter.gridview_adapter;
import com.ron.exploreapp.gridview_image_activity;

import java.util.ArrayList;
import java.util.List;

public class images extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;

    public images() {

    }


    public static com.ron.exploreapp.frag_restactivity.images newInstance(String param1, String param2) {
        com.ron.exploreapp.frag_restactivity.images fragment = new com.ron.exploreapp.frag_restactivity.images();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
      View view= inflater.inflate(R.layout.fragment_images, container, false);
        Bundle bundle=getArguments();
        String place=bundle.getString("place");
        final GridView gridView=view.findViewById(R.id.gridview);

        DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference().child("restaurent").child(place.toLowerCase()).child("grid_images");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                final List<String> imagelist=new ArrayList<>();
                for(DataSnapshot data:snapshot.getChildren()){
                    imagelist.add(data.getValue(String.class));
                }
                gridview_adapter adapter=new gridview_adapter(getContext(),imagelist);
                gridView.setAdapter(adapter);
                gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent=new Intent(getContext(), gridview_image_activity.class);
                        intent.putExtra("image",imagelist.get(position));
                        startActivity(intent);
                    }
                });
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }

        });


        return view;
    }
}
