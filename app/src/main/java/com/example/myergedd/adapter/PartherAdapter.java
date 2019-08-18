package com.example.myergedd.adapter;

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
import com.example.myergedd.bean.PartnerBean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class PartherAdapter extends RecyclerView.Adapter {
    public List<PartnerBean.DataBean> mList = new ArrayList<>();
    private Context mContext;

    public PartherAdapter(Context context) {
        mContext = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_watch_partner, null));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
//        Collections.reverse(mList);
        PartnerBean.DataBean bean = mList.get(i);
        MyViewHolder holder = (MyViewHolder) viewHolder;
        Glide.with(mContext).load(bean.getImage_url()).into(holder.mIv);
        if (i == 0) {
            holder.mTv.setText("宝狄与好友");
        }else if (i==1){
            holder.mTv.setText("哈利");
        }else if (i==2){
            holder.mTv.setText("网趣宝贝");
        }else if (i==3){
            holder.mTv.setText("Little Fox");
        }else if (i==4){
            holder.mTv.setText("方块熊");
        }else if (i==5){
            holder.mTv.setText("熊孩子");
        }else if (i==6){
            holder.mTv.setText("恰克大冒险");
        }else if (i==7){
            holder.mTv.setText("千千简笔画");
        }else if (i==8){
            holder.mTv.setText("蓝迪");
        }else if (i==9){
            holder.mTv.setText("变形金刚");
        }else if (i==10){
            holder.mTv.setText("兔小贝");
        }else if (i==11){
            holder.mTv.setText("宝宝巴士");
        }else if (i==12){
            holder.mTv.setText("海底小纵队");
        }else if (i==13){
            holder.mTv.setText("巴塔木儿歌");
        }else if (i==14){
            holder.mTv.setText("小马宝莉");
        }else if (i==15){
            holder.mTv.setText("萌鸡小队");
        }else if (i==16){
            holder.mTv.setText("超级飞侠");
        }else if (i==17){
            holder.mTv.setText("汪汪队立大功");
        }else {
            holder.mTv.setText("小猪佩奇");
        }
    }

    public void setDataParther(PartnerBean bean) {
        mList.addAll(bean.getData());
        notifyDataSetChanged();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private ImageView mIv;
        private TextView mTv;

        public MyViewHolder(View itemView) {
            super(itemView);
            mIv = itemView.findViewById(R.id.iv_parther);
            mTv = itemView.findViewById(R.id.tv_parther);
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}
