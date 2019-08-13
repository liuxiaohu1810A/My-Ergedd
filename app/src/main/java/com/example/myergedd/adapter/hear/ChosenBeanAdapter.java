package com.example.myergedd.adapter.hear;

import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myergedd.R;
import com.example.myergedd.bean.hear.ChosenBean;
import com.example.myergedd.bean.hear.ChosenBeanBan;

import java.util.ArrayList;
import java.util.List;

public class ChosenBeanAdapter extends RecyclerView.Adapter<ChosenBeanAdapter.ViewHolder>{
    private final FragmentActivity activity;
    private ArrayList<ChosenBeanBan> earlyBeans=new ArrayList<>();

    public ChosenBeanAdapter(FragmentActivity activity) {
        this.activity = activity;

    }
    public void setChosenBean(List<ChosenBeanBan> beans) {

        earlyBeans.addAll(beans);
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(activity, R.layout.item_listen_choiceness_center, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
       /* //防止隐藏item出现空白
        public void setVisibility(boolean isVisible, View viewHolder.itemView) {
            RecyclerView.LayoutParams param = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
            if (isVisible) {
                param.height = RelativeLayout.LayoutParams.WRAP_CONTENT;// 这里注意使用自己布局的根布局类型
                param.width = RelativeLayout.LayoutParams.MATCH_PARENT;// 这里注意使用自己布局的根布局类型
                viewHolder.itemView.setVisibility(android.view.View.VISIBLE);
            } else {
                param.height = 0;
                param.width = 0;
                viewHolder.itemView.setVisibility(View.GONE);
            }
            viewHolder.itemView.setLayoutParams(param);
        }
        if (i==6 || i==7){
            *//*viewHolder.name.setVisibility(View.GONE);
            viewHolder.desc.setVisibility(View.GONE);
            viewHolder.img.setVisibility(View.GONE);*//*
        }else{
            viewHolder.name.setText(earlyBeans.get(i).getCount()+"");
            viewHolder.desc.setText(earlyBeans.get(i).getName());
            Glide.with(activity).load(earlyBeans.get(i).getSquare_image_url()).into(viewHolder.img);
        }*/
        viewHolder.name.setText(earlyBeans.get(i).getCount()+"");
        viewHolder.desc.setText(earlyBeans.get(i).getName());
        Glide.with(activity).load(earlyBeans.get(i).getSquare_image_url()).into(viewHolder.img);
    }

    @Override
    public int getItemCount() {
        return earlyBeans.size()-2;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView img;

        private final TextView desc;

        private final TextView name;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.item_chosen_img);
            name = itemView.findViewById(R.id.item_chosen_count);
            desc = itemView.findViewById(R.id.item_chosen_type);
        }

    }
}
