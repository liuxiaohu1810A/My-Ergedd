package com.example.myergedd.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
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
        View view = View.inflate(context, R.layout.item_watch_common, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        for (int j = 0; j <bean.size() ; j++) {
            SongBean songBean = bean.get(j);
            viewHolder.name.setText(songBean.getName());
            viewHolder.desc.setText(songBean.getDescription());
            viewHolder.js.setText("共"+songBean.getVideo_count()+"集");
            Glide.with(context).load(songBean.getImage_url()).into(viewHolder.image);
        }


    }

    @Override
    public int getItemCount() {
        return bean.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView image;
        private final TextView name;
        private final TextView desc;
        private final TextView js;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.iv_image);
            name = itemView.findViewById(R.id.item_watch_list_name);
            desc = itemView.findViewById(R.id.item_watch_list_desc);
            js = itemView.findViewById(R.id.js);
        }
    }
}
