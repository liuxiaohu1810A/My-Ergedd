package com.example.myergedd.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myergedd.R;
import com.example.myergedd.bean.RecommendBean;

import java.util.ArrayList;
import java.util.List;

public class VideoRecommendAdapter extends RecyclerView.Adapter<VideoRecommendAdapter.ViewHolder> {

    private List<RecommendBean> itemBeans = new ArrayList<>();

    private Context context;

    public VideoRecommendAdapter(Context context) {
        this.context = context;
    }

    public void setItemBeans(List<RecommendBean> itemBeans) {
        this.itemBeans = itemBeans;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.item__cache_video_recommend, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.cache_recomment_title.setText(itemBeans.get(i).getName());
        Glide.with(context).load(itemBeans.get(i).getImage()).into(viewHolder.cache_recomment_img);
    }

    @Override
    public int getItemCount() {
        return itemBeans.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView cache_recomment_img;
        private TextView cache_recomment_title;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cache_recomment_img = itemView.findViewById(R.id.cache_recomment_img);
            cache_recomment_title = itemView.findViewById(R.id.cache_recomment_title);
        }
    }
}
