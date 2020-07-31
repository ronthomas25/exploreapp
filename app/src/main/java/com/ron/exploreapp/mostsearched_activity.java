package com.ron.exploreapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ron.exploreapp.model_data.mostsearched_data;

import java.util.List;

public class mostsearched_activity extends AppCompatActivity {
    TextView place,desc;
    int pos;
    ImageView img,backbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostsearched_activity);
        place=findViewById(R.id.placename);
        desc=findViewById(R.id.placedesc);
        img=findViewById(R.id.placeimg);
        backbtn=findViewById(R.id.back_button);

        Bundle bundle= getIntent().getExtras();
        List<mostsearched_data> mostsearchedData=(List<mostsearched_data>)bundle.getSerializable("data");

        pos=getIntent().getIntExtra("pos",0);
        place.setText(mostsearchedData.get(pos).getPlacename());
        desc.setText(mostsearchedData.get(pos).getDesc());
        img.setImageResource(mostsearchedData.get(pos).getImg(1));

        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mostsearched_activity.this,MainActivity.class);
                startActivity(i);
            }
        });




    }
}