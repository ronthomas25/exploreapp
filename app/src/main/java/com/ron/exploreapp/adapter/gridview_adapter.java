package com.ron.exploreapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.ron.exploreapp.R;

import java.util.List;

public class gridview_adapter extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater;
    private List<String> image_list;

    public gridview_adapter(Context context, List<String> image_list)
    {
        this.context=context;
        this.image_list=image_list;
    }

    @Override
    public int getCount() {
        return image_list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater==null){
            inflater= (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

        }
        if(convertView==null){
            convertView=inflater.inflate(R.layout.gridview_layout,null);


        }
        ImageView img=convertView.findViewById(R.id.imageview);
      //  img.setImageResource(images[position]);
        Glide.with(context).load(image_list.get(position)).into(img);
        return convertView;
    }
}
