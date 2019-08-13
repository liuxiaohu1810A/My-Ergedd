package com.example.myergedd.adapter;

import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myergedd.R;
import com.example.myergedd.bean.EarlyBean;
import com.example.myergedd.bean.EnglishBean;

import java.util.ArrayList;
import java.util.List;

public class EnglishAdapter extends RecyclerView.Adapter<EnglishAdapter.ViewHolder> {
    private final FragmentActivity activity;
    public ArrayList<EnglishBean> englishBeans = new ArrayList<>();
    private onClickListener mListener;

    public EnglishAdapter(FragmentActivity activity) {

        this.activity = activity;
    }

    public void setEnglishBeans(List<EnglishBean> beans) {

        englishBeans.addAll(beans);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(activity, R.layout.item_watch_common, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {

        viewHolder.name.setText(englishBeans.get(i).getName());
        viewHolder.desc.setText(englishBeans.get(i).getDescription());
        viewHolder.ji.setText("共" + englishBeans.get(i).getVideo_count() + "集");
        Glide.with(activity).load(englishBeans.get(i).getImage_url()).into(viewHolder.img);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.onClick(v, i);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return englishBeans.size();
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

    public interface onClickListener {
        void onClick(View v, int position);
    }


    public void setOnClickListener(onClickListener listener) {
        mListener = listener;
    }
}
