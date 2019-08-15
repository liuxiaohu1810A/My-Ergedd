package com.example.myergedd.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myergedd.R;

import java.util.List;

public class SearchSeeRecentAdapte extends RecyclerView.Adapter {
    private Context mContext;
    private List<String> mList;
    private onClickListener mListener;

    public SearchSeeRecentAdapte(Context context) {
        mContext = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_watch_search_recent_title, null));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        MyViewHolder holder = (MyViewHolder) viewHolder;
        String title = mList.get(i);
        holder.mTv.setText(title);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.onClick(v,i);
                }
            }
        });
    }

    public void setDataRecentSee(List<String> list) {
        mList = list;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private ImageView mIv;
        private TextView mTv;

        public MyViewHolder(View itemView) {
            super(itemView);
            mIv = itemView.findViewById(R.id.iv_search_recent);
            mTv = itemView.findViewById(R.id.tv_search_recent);
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public interface onClickListener {
        void onClick(View v, int position);
    }

    public void setOnClickListener(onClickListener listener) {
        mListener = listener;
    }
}
