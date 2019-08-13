package com.example.myergedd.activity.commonsee;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myergedd.R;
import com.example.myergedd.activity.CommonSeeActivity;

import java.util.ArrayList;
import java.util.List;

public class CommonSeeAdapter extends RecyclerView.Adapter {
    List<CommonSeeBean> mList = new ArrayList<>();
    private Context mContext;

    public CommonSeeAdapter(Context context) {
        mContext = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_watch_choiceness_center_no, null));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        MyViewHolder holder = (MyViewHolder) viewHolder;
        CommonSeeBean bean = mList.get(i);
        Glide.with(mContext).load(bean.getImage()).into(holder.mListen_buttom_img);
        holder.mListen_buttom_title.setText(bean.getName());
    }

    public void setCommonData(List<CommonSeeBean> commonSeeBeans) {
        mList.addAll(commonSeeBeans);
        notifyDataSetChanged();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private ImageView mListen_buttom_img;
        private TextView mListen_buttom_title;
        private ImageView mListen_center_img;

        public MyViewHolder(View itemView) {
            super(itemView);
            mListen_buttom_img = itemView.findViewById(R.id.listen_buttom_img);
            mListen_buttom_title = itemView.findViewById(R.id.listen_buttom_title);
            mListen_center_img = itemView.findViewById(R.id.listen_center_img);
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}
