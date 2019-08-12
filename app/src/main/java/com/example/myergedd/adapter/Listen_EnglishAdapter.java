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

import java.util.ArrayList;
import java.util.List;

public class Listen_EnglishAdapter extends RecyclerView.Adapter<Listen_EnglishAdapter.ViewHolder> {

    private List<Listen_EnglishBean> listen_englishBeans=new ArrayList<>();
    private Context context;

    public Listen_EnglishAdapter(Context context) {
        this.context = context;
    }

    public void setList(List<Listen_EnglishBean> list) {
        listen_englishBeans = list;
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

        viewHolder.item_watch_list_name.setText(listen_englishBeans.get(i).getName());
        viewHolder.item_watch_list_desc.setText(listen_englishBeans.get(i).getDescription());
        viewHolder.item_watch_list_count.setText(listen_englishBeans.get(i).getCount()+"首");
        Glide.with(context).load(listen_englishBeans.get(i).getSquare_image_url()).into(viewHolder.listen_common_img);

    }

    @Override
    public int getItemCount() {
        return listen_englishBeans.size();
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
