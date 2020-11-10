package com.ron.exploreapp.fragment_popularstays;

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

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link images#newInstance} factory method to
 * create an instance of this fragment.
 */
public class images extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public images() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment images.
     */
    // TODO: Rename and change types and number of parameters
    public static images newInstance(String param1, String param2) {
        images fragment = new images();
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
        final View view=inflater.inflate(R.layout.fragment_images, container, false);
        Bundle bundle=getArguments();
        String place=bundle.getString("name");
        final GridView gridView=view.findViewById(R.id.gridview);

        DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference().child("popularstays").child(place.toLowerCase()).child("grid_images");
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