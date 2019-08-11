package com.example.myergedd.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myergedd.R;
import com.example.myergedd.bean.SongBean;


import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private Context context;
    private List<SongBean> bean=new ArrayList<>();

    public MyAdapter(Context context) {
        this.context = context;
    }
    public void TextData( List<SongBean> list){
        bean.addAll(list);
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
       // View view = View.inflate(context, R.layout.knowledge_item, null);
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        for (int j = 0; j <bean.size() ; j++) {
            bean.get(j);
        }


    }

    @Override
    public int getItemCount() {
        return bean.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

        }
    }
}
