package com.ron.exploreapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

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

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends BaseActivity{

    RecyclerView rest_recyclerview, mostsearched_recyclerview;
   int munnar_img[] = {R.drawable.munnar, R.drawable.munnarinner};
    int wayanad_img[] = {R.drawable.wayanad, R.drawable.wayanadinner};
    int vagamon_img[] = {R.drawable.vagamon, R.drawable.vagamoninner};
    /* int kochi_img[] = {R.drawable.kochi, R.drawable.kochi2};
   int alp_img[] = {R.drawable.alp, R.drawable.alp2};
   int kumarakom_img[] = {R.drawable.kumarakom, R.drawable.kumarakom2};
   int kovalam_img[] = {R.drawable.kovalam, R.drawable.kovalam2};
   int varkala_img[] = {R.drawable.varkala, R.drawable.varkala2};
   int paragon_img[] = {R.drawable.paragonlogo, R.drawable.paragonlogo};
   int thakkaram_img[] = {R.drawable.thakkaram, R.drawable.thakkaram};
   int koco_img[] = {R.drawable.koco, R.drawable.koco};
   int chayakkada_img[] = {R.drawable.chayakkada1, R.drawable.chayakkada1};*/
    ImageView loc_search;
    DatabaseReference databaseReference;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loc_search=findViewById(R.id.loc_search);
        loc_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });




        List<SlideModel> slideModels=new ArrayList<>();
        ImageSlider imageSlider=findViewById(R.id.slider);
        slideModels.add(new SlideModel(R.drawable.munnar));
        slideModels.add(new SlideModel(R.drawable.wayanad));
        slideModels.add(new SlideModel(R.drawable.vagamon));
        imageSlider.setImageList(slideModels,true);

        List<top_picks_data> topPicksDataList=new ArrayList<>();
        topPicksDataList.add(new top_picks_data(munnar_img,"Munnar",getString(R.string.munnar_desc),4.8,10.1697,77.0640,"kerala,India"));
        topPicksDataList.add(new top_picks_data(wayanad_img,"Wayanad",getString(R.string.wayanad_desc),4.5,11.2954,76.120,"kerala,India"));
        topPicksDataList.add(new top_picks_data(vagamon_img,"Vagamon",getString(R.string.vagamon_desc),4.4,9.4050,76.520,"kerala,India"));
        slideronclick(topPicksDataList,imageSlider);

   /*     List<mostsearched_data> mostsearchedDataList=new ArrayList<>();
        mostsearchedDataList.add(new mostsearched_data(kochi_img,"Kochi",getString(R.string.kochi_desc),4.0, 9.9312,76.2673,"kerala,India"));
        mostsearchedDataList.add(new mostsearched_data(alp_img,"Alappuzha",getString(R.string.alp_desc),4.3,9.9312,76.2673,"kerala,India"));
        mostsearchedDataList.add(new mostsearched_data(kumarakom_img,"kumarakom",getString(R.string.kumarakom_desc),4.5,9.9312,76.2673,"kerala,India"));
        mostsearchedDataList.add(new mostsearched_data(kovalam_img,"Kovalam",getString(R.string.kovalam_desc),4.3,9.9312,76.2673,"kerala,India"));
        mostsearchedDataList.add(new mostsearched_data(varkala_img,"Varkala",getString(R.string.varkala_desc),4.3,9.9312,76.2673,"kerala,India"));
        mostsearched_recycler(mostsearchedDataList);*/
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
                    restaurentDataList.add(new popular_restaurent_data(rest_modeldata.getImage(),rest_modeldata.getImageInner(),rest_modeldata.getPlace(),rest_modeldata.getDesc(),rest_modeldata.getRating(),rest_modeldata.getLat(),rest_modeldata.getLon(),rest_modeldata.getState()));
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