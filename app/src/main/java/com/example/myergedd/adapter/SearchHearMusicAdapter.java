package com.example.myergedd.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myergedd.R;
import com.example.myergedd.activity.SearchMusicActivity;
import com.example.myergedd.bean.SearchHearMusicBean;
import com.example.myergedd.utils.TimerUtils;

import java.util.ArrayList;
import java.util.List;

public class SearchHearMusicAdapter extends RecyclerView.Adapter {
    public List<SearchHearMusicBean.AudiosBean> mList = new ArrayList<>();
    private Context mContext;

    public SearchHearMusicAdapter(Context context) {
        mContext = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_listen_two_buttom, null));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        SearchHearMusicBean.AudiosBean audiosBean = mList.get(i);
        MyViewHolder holder = (MyViewHolder) viewHolder;
        holder.mTitle.setText(audiosBean.getName());
        holder.mTime.setText(TimerUtils.getTime((long) audiosBean.getDuration()));
    }

    public void setDataHearList(SearchHearMusicBean hearMusicBean) {
        mList.addAll(hearMusicBean.getAudios());
        notifyDataSetChanged();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView mTitle, mTime;

        public MyViewHolder(View itemView) {
            super(itemView);
            mTitle = itemView.findViewById(R.id.listen_two_title);
            mTime = itemView.findViewById(R.id.listen_two_time);
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}
