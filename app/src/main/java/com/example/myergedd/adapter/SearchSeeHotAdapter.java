package com.example.myergedd.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myergedd.R;
import com.example.myergedd.bean.SearchSeeHotBean;

import java.util.ArrayList;
import java.util.List;

public class SearchSeeHotAdapter extends RecyclerView.Adapter {
    private Context mContext;
    public List<String> mList = new ArrayList<>();

    public SearchSeeHotAdapter(Context context) {
        mContext = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_watch_search_hot_title, null));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        MyViewHolder holder = (MyViewHolder) viewHolder;
        String name = mList.get(i);
        Log.e("lzs", "onBindViewHolder: " + mList.size());
        if (i == 0) {
            holder.mIv.setImageResource(R.mipmap.icon_keyword_fire1);
        } else if (i == 1) {
            holder.mIv.setImageResource(R.mipmap.icon_keyword_fire2);
        } else if (i == 2) {
            holder.mIv.setImageResource(R.mipmap.icon_keyword_fire3);
        } else {
            holder.mDigital.setText(i + 1 + "");
            holder.mIv.setVisibility(View.GONE);
        }
        holder.mTv.setText(name);
    }

    public void setDataHotSearchSee(SearchSeeHotBean seeHotBean) {
        mList.addAll(seeHotBean.getKeywords());
        notifyDataSetChanged();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private ImageView mIv;
        private TextView mTv;
        private TextView mDigital;

        public MyViewHolder(View itemView) {
            super(itemView);
            mIv = itemView.findViewById(R.id.iv_search_hot);
            mTv = itemView.findViewById(R.id.tv_search_hot);
            mDigital = itemView.findViewById(R.id.tv_search_hot_digital);
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

}
