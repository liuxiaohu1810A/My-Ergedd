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
import com.example.myergedd.fragment.hear.erge.bean.Listen_ErgeBean;

import java.util.ArrayList;
import java.util.List;

public class Listen_ErgeAdapter extends RecyclerView.Adapter<Listen_ErgeAdapter.ViewHolder> {

    private List<Listen_ErgeBean> ergeBeans=new ArrayList<>();
    private Context context;

    public Listen_ErgeAdapter(Context context) {
        this.context = context;
    }

    public void setList(List<Listen_ErgeBean> list) {
        ergeBeans = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.item_listen_common, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        viewHolder.item_watch_list_count.setText(ergeBeans.get(i).getCount()+"首");
        viewHolder.item_watch_list_desc.setText(ergeBeans.get(i).getDescription());
        viewHolder.item_watch_list_name.setText(ergeBeans.get(i).getName());
        Glide.with(context).load(ergeBeans.get(i).getSquare_image_url()).into(viewHolder.listen_common_img);
    }

    @Override
    public int getItemCount() {
        return ergeBeans.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView listen_common_img;
        private TextView item_watch_list_name;
        private TextView item_watch_list_desc;
        private TextView item_watch_list_count;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            listen_common_img = itemView.findViewById(R.id.listen_common_img);
            item_watch_list_name = itemView.findViewById(R.id.item_watch_list_name);
            item_watch_list_desc = itemView.findViewById(R.id.item_watch_list_desc);
            item_watch_list_count = itemView.findViewById(R.id.item_watch_list_count);
        }
    }
}
