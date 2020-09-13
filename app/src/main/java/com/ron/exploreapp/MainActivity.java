package com.ron.exploreapp;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.interfaces.ItemClickListener;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.ron.exploreapp.adapter.mostsearched_adapter;
import com.ron.exploreapp.adapter.rest_adapter;
import com.ron.exploreapp.model_data.most_srcd_firebasedata;
import com.ron.exploreapp.model_data.mostsearched_data;
import com.ron.exploreapp.model_data.popular_restaurent_data;
import com.ron.exploreapp.model_data.rest_firebasedata;
import com.ron.exploreapp.model_data.top_picks_data;
import com.ron.exploreapp.model_data.toppicks_firebase_data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity{

    RecyclerView rest_recyclerview, mostsearched_recyclerview;
    ImageView loc_search;
    DatabaseReference databaseReference;


    List<String> image_list;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loc_search=findViewById(R.id.loc_search);
        loc_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        databaseReference=FirebaseDatabase.getInstance().getReference().child("toppicks");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                List<top_picks_data> topPicksDataList=new ArrayList<>();
                List<SlideModel> slideModels=new ArrayList<>();
                ImageSlider imageSlider=findViewById(R.id.slider);
                for (DataSnapshot data:snapshot.getChildren()){
                    toppicks_firebase_data modeldata=data.getValue(toppicks_firebase_data.class);
                    topPicksDataList.add(new top_picks_data(modeldata.getDesc(),modeldata.getImage(),modeldata.getImage_inner(),modeldata.getLat(),modeldata.getLon(),
                                                            modeldata.getPlace(),modeldata.getRating(),modeldata.getState()));
                    slideModels.add(new SlideModel(modeldata.getImage()));

                }
                imageSlider.setImageList(slideModels,true);
                slideronclick(topPicksDataList,imageSlider);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });




        databaseReference=FirebaseDatabase.getInstance().getReference().child("mostsearchedplace");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                List<mostsearched_data> mostsearchedDataList=new ArrayList<>();
                for(DataSnapshot data: snapshot.getChildren()){
                    most_srcd_firebasedata modeldata=data.getValue(most_srcd_firebasedata.class);
                    mostsearchedDataList.add(new mostsearched_data(modeldata.getDesc(),modeldata.getImg_inner(),modeldata.getImg_outer(),modeldata.getLat(),
                                             modeldata.getLon(),modeldata.getPlace(),modeldata.getRating(),modeldata.getState()));
                }
                mostsearched_recycler(mostsearchedDataList);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });


        databaseReference=FirebaseDatabase.getInstance().getReference().child("restaurent");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                List<popular_restaurent_data> restaurentDataList=new ArrayList<>();
                for(DataSnapshot data:snapshot.getChildren()){
                    rest_firebasedata rest_modeldata=data.getValue(rest_firebasedata.class);
                    restaurentDataList.add(new popular_restaurent_data(rest_modeldata.getDesc(),rest_modeldata.getImage(),rest_modeldata.getImageInner(),rest_modeldata.getLat(),rest_modeldata.getLon(),rest_modeldata.getPlace(),rest_modeldata.getRating(),rest_modeldata.getState()));
                }
                restaurent_recycler(restaurentDataList);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


      }

    @Override
    int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    int getBottomNavigationMenuItemId() {
        return R.id.action_main;
    }

    private void mostsearched_recycler(List<mostsearched_data> mostsearchedDataList)
    {
        mostsearched_recyclerview=findViewById(R.id.most_searched_recycler);
        mostsearched_adapter mostsearched_adapter=new mostsearched_adapter(this,mostsearchedDataList);
        mostsearched_recyclerview.setAdapter(mostsearched_adapter);
        mostsearched_recyclerview.setLayoutManager(new LinearLayoutManager(this,mostsearched_recyclerview.HORIZONTAL,false));
    }

   private void restaurent_recycler(List<popular_restaurent_data> restaurentDataList)
   {
       rest_recyclerview=findViewById(R.id.restrecycler);
       rest_adapter rest_adapter=new rest_adapter(this,restaurentDataList);
       rest_recyclerview.setAdapter(rest_adapter);
       rest_recyclerview.setLayoutManager(new LinearLayoutManager(this,rest_recyclerview.HORIZONTAL,false));
   }

   private void slideronclick(final List<top_picks_data> topPicksDataList, ImageSlider imageslider)
   {
       final Intent intent=new Intent(this, toppicks_activity.class);
       imageslider.setItemClickListener(new ItemClickListener() {
           @Override
           public void onItemSelected(int i) {
               if (i == 0) {
                   Bundle bundle = new Bundle();
                   bundle.putSerializable("data", (Serializable) topPicksDataList);
                   intent.putExtra("position", 0);
                   intent.putExtras(bundle);
                   startActivity(intent);
               }
               if(i==1){
                   Bundle bundle = new Bundle();
                   bundle.putSerializable("data", (Serializable) topPicksDataList);
                   intent.putExtra("position", 1);
                   intent.putExtras(bundle);
                   startActivity(intent);
               }
               if(i==2){
                   Bundle bundle = new Bundle();
                   bundle.putSerializable("data", (Serializable) topPicksDataList);
                   intent.putExtra("position", 2);
                   intent.putExtras(bundle);
                   startActivity(intent);
               }
           }
       });
       ImageView imageView = (ImageView) findViewById(R.id.loc_search);
       imageView.bringToFront();
       imageView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent1 = new Intent(MainActivity.this, search_loc.class);
               startActivity(intent1);
           }
       });


   }


}