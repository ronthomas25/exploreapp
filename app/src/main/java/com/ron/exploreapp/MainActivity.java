package com.ron.exploreapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.interfaces.ItemClickListener;
import com.denzcoskun.imageslider.models.SlideModel;
import com.ron.exploreapp.adapter.mostsearched_adapter;
import com.ron.exploreapp.adapter.rest_adapter;
import com.ron.exploreapp.model_data.mostsearched_data;
import com.ron.exploreapp.model_data.restaurent_data;
import com.ron.exploreapp.model_data.top_picks_data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity{
    RecyclerView rest_recyclerview, mostsearched_recyclerview;
    int munnar_img[] = {R.drawable.munnar, R.drawable.munnarinner};
    int wayanad_img[] = {R.drawable.wayanad, R.drawable.wayanadinner};
    int vagamon_img[] = {R.drawable.vagamon, R.drawable.vagamoninner};
    int kochi_img[] = {R.drawable.kochi, R.drawable.kochi2};
    int alp_img[] = {R.drawable.alp, R.drawable.alp2};
    int kumarakom_img[] = {R.drawable.kumarakom, R.drawable.kumarakom2};
    int kovalam_img[] = {R.drawable.kovalam, R.drawable.kovalam2};
    int varkala_img[] = {R.drawable.varkala, R.drawable.varkala2};
    int paragon_img[] = {R.drawable.paragonlogo, R.drawable.paragonlogo};
    int thakkaram_img[] = {R.drawable.thakkaram, R.drawable.thakkaram};
    int koco_img[] = {R.drawable.koco, R.drawable.koco};
    int chayakkada_img[] = {R.drawable.chayakkada1, R.drawable.chayakkada1};





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



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

        List<mostsearched_data> mostsearchedDataList=new ArrayList<>();
        mostsearchedDataList.add(new mostsearched_data(kochi_img,"Kochi",getString(R.string.kochi_desc),4.0, 9.9312,76.2673,"kerala,India"));
        mostsearchedDataList.add(new mostsearched_data(alp_img,"Alappuzha",getString(R.string.alp_desc),4.3,9.9312,76.2673,"kerala,India"));
        mostsearchedDataList.add(new mostsearched_data(kumarakom_img,"kumarakom",getString(R.string.kumarakom_desc),4.5,9.9312,76.2673,"kerala,India"));
        mostsearchedDataList.add(new mostsearched_data(kovalam_img,"Kovalam",getString(R.string.kovalam_desc),4.3,9.9312,76.2673,"kerala,India"));
        mostsearchedDataList.add(new mostsearched_data(varkala_img,"Varkala",getString(R.string.varkala_desc),4.3,9.9312,76.2673,"kerala,India"));
        mostsearched_recycler(mostsearchedDataList);

        List<restaurent_data> restaurentDataList=new ArrayList<>();
        restaurentDataList.add(new restaurent_data(paragon_img,"Paragon","Adorned",4,9.9312,76.2673,"Kerala,India"));
        restaurentDataList.add(new restaurent_data(thakkaram_img,"Thakkaram","Adorned",4,9.9312,76.2673,"Kerala,India"));
        restaurentDataList.add(new restaurent_data(koco_img,"Ko.co","Adorned",4,9.9312,76.2673,"Kerala,India"));
        restaurentDataList.add(new restaurent_data(chayakkada_img,"Aadhaminte Chayakada","Adorned",4,9.9312,76.2673,"Kerala,India"));
        restaurent_recycler(restaurentDataList);

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

   private void restaurent_recycler(List<restaurent_data> restaurentDataList)
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


   }


}