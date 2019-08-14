package com.example.myergedd.activity.detailshear;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myergedd.R;
import com.example.myergedd.activity.DetailsActivity;
import com.example.myergedd.activity.commonsee.CommonSeeBean;

import java.util.ArrayList;
import java.util.List;

public class DetailsHearAdapter extends RecyclerView.Adapter<DetailsHearAdapter.ViewHolder> {
    public List<DetailsHearBean.AudiosBean> list = new ArrayList<>();
    private Context mContext;
    public DetailsHearAdapter(Context context) {
        mContext = context;
    }
    public void setDetailsData(DetailsHearBean detailsDatas) {
        list.addAll(detailsDatas.getAudios());
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_watch_choiceness_center_no, null));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.item.setText((int) list.get(i).getDuration());
        viewHolder.title.setText(list.get(i).getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView title;
        private final TextView item;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.listen_two_title);
            item = itemView.findViewById(R.id.listen_two_time);
        }
    }
}
