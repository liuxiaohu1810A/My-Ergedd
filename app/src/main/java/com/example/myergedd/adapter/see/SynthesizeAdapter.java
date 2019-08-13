package com.example.myergedd.adapter.see;

import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myergedd.R;
import com.example.myergedd.bean.see.SynthesizeBean;

import java.util.ArrayList;
import java.util.List;

public class SynthesizeAdapter extends RecyclerView.Adapter<SynthesizeAdapter.ViewHolder> {
    private final FragmentActivity activity;
    private ArrayList<SynthesizeBean> synthesizeBeans=new ArrayList<>();

    public SynthesizeAdapter(FragmentActivity activity) {

        this.activity = activity;
    }

    public void setSynthesizeBeans(List<SynthesizeBean> beans) {

        synthesizeBeans.addAll(beans);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(activity, R.layout.item_watch_common, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

            viewHolder.name.setText(synthesizeBeans.get(i).getName());
            viewHolder.desc.setText(synthesizeBeans.get(i).getDescription());
            viewHolder.ji.setText("共"+synthesizeBeans.get(i).getVideo_count()+"集");
            Glide.with(activity).load(synthesizeBeans.get(i).getImage_url()).into(viewHolder.img);
    }

    @Override
    public int getItemCount() {
        return synthesizeBeans.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView img;
        private final TextView name;
        private final TextView desc;
        private final TextView ji;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.cartoon_img);
            name = itemView.findViewById(R.id.item_watch_list_name);
            desc = itemView.findViewById(R.id.item_watch_list_desc);
            ji = itemView.findViewById(R.id.cartoom_ji);
        }
    }
}
