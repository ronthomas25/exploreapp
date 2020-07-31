package com.ron.exploreapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.ron.exploreapp.adapter.mostsearched_adapter;
import com.ron.exploreapp.adapter.rest_adapter;
import com.ron.exploreapp.model_data.mostsearched_data;
import com.ron.exploreapp.model_data.restaurent_data;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView rest_recyclerview,mostsearched_recyclerview ;
    int[] kochi_img={R.drawable.kochi, R.drawable.kochi2};
    int alp_img[]={R.drawable.alp,R.drawable.alp2};
    int kumarakom_img[]={R.drawable.kumarakom,R.drawable.kumarakom2};
    int kovalam_img[]={R.drawable.kovalam,R.drawable.kovalam2};
    int varkala_img[]={R.drawable.varkala,R.drawable.varkala2};

      public void onClickMunnar(View view){
        Intent i = new Intent(MainActivity.this,munnaractivity.class);
        startActivity(i);
        setContentView(R.layout.activity_munnar);
    }

    public void onClickWayanad(View view){
        Intent i = new Intent(getApplicationContext(),wayanadactivity.class);
        startActivity(i);
        setContentView(R.layout.activity_wayanad);
    }

    public void onClickVagamon(View view){
        Intent i = new Intent(getApplicationContext(),vagamonactivity.class);
        startActivity(i);
        setContentView(R.layout.activity_vagamon);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<mostsearched_data> mostsearchedDataList=new ArrayList<>();
        mostsearchedDataList.add(new mostsearched_data(kochi_img,"Kochi",getString(R.string.kochi_desc)));
        mostsearchedDataList.add(new mostsearched_data(alp_img,"Alappuzha",getString(R.string.alp_desc)));
        mostsearchedDataList.add(new mostsearched_data(kumarakom_img,"Kumarakom",getString(R.string.kumarakom_desc)));
        mostsearchedDataList.add(new mostsearched_data(kovalam_img,"Kovalam",getString(R.string.kovalam_desc)));
        mostsearchedDataList.add(new mostsearched_data(varkala_img,"Varkala",getString(R.string.varkala_desc)));
        mostsearched_recycler(mostsearchedDataList);

        List<restaurent_data> restaurentDataList=new ArrayList<>();
        restaurentDataList.add(new restaurent_data(R.drawable.paragonlogo,"Paragon"));
        restaurentDataList.add(new restaurent_data(R.drawable.thakkaram,"Thakkaram"));
        restaurentDataList.add(new restaurent_data(R.drawable.koco,"Ko.co"));
        restaurentDataList.add(new restaurent_data(R.drawable.chayakkada1,"Aadhaminte Chayakada"));
        restaurent_recycler(restaurentDataList);

      }
    private void mostsearched_recycler(List<mostsearched_data> mostsearchedDataList)
    {
        mostsearched_recyclerview=findViewById(R.id.most_searched_recycler);
        mostsearched_adapter mostsearched_adapter=new mostsearched_adapter(this,mostsearchedDataList);
        mostsearched_recyclerview.setAdapter(mostsearched_adapter);
        mostsearched_recyclerview.setLayoutManager(new LinearLayoutManager(this,mostsearched_recyclerview.HORIZONTAL,false));
    }

   private void restaurent_recycler(List<restaurent_data> restaurentDataList)
   {
       rest_recyclerview=findViewById(R.id.restrecycler);
       rest_adapter rest_adapter=new rest_adapter(this,restaurentDataList);
       rest_recyclerview.setAdapter(rest_adapter);
       rest_recyclerview.setLayoutManager(new LinearLayoutManager(this,rest_recyclerview.HORIZONTAL,false));
   }

}