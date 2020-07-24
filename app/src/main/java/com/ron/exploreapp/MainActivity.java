package com.ron.exploreapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    RecyclerView rest_recyclerview,mostsearched_recyclerview ;
    int most_searched[]={R.drawable.kochi,R.drawable.alp,R.drawable.kumarakom,R.drawable.kovalam,R.drawable.varkala};
    int rest_images[]= {R.drawable.paragonlogo,R.drawable.thakkaram};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rest_recyclerview=findViewById(R.id.restrecycler);
        rest_adapter rest_adapter=new rest_adapter(this,rest_images);
        rest_recyclerview.setAdapter(rest_adapter);
        rest_recyclerview.setLayoutManager(new LinearLayoutManager(this,rest_recyclerview.HORIZONTAL,false));

        mostsearched_recyclerview=findViewById(R.id.most_searched_recycler);
        mostsearched_adapter mostsearched_adapter=new mostsearched_adapter(this,most_searched);
        mostsearched_recyclerview.setAdapter(mostsearched_adapter);
        mostsearched_recyclerview.setLayoutManager(new LinearLayoutManager(this,mostsearched_recyclerview.HORIZONTAL,false));



    }
}