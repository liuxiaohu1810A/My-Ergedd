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
import com.example.myergedd.bean.EnglishBean;
import com.example.myergedd.bean.MusicBean;

import java.util.ArrayList;
import java.util.List;

public class MusicAdapter extends RecyclerView.Adapter<MusicAdapter.ViewHolder> {
    private final FragmentActivity activity;
    private ArrayList<MusicBean> musicBeans=new ArrayList<>();

    public MusicAdapter(FragmentActivity activity) {

        this.activity = activity;
    }

    public void setMusicBeans(List<MusicBean> beans) {

        musicBeans.addAll(beans);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(activity, R.layout.item_listen_common, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

            viewHolder.name.setText(musicBeans.get(i).getName());
            viewHolder.desc.setText(musicBeans.get(i).getDescription());
            viewHolder.count.setText(musicBeans.get(i).getCount()+"首");
            Glide.with(activity).load(musicBeans.get(i).getSquare_image_url()).into(viewHolder.img);
    }

    @Override
    public int getItemCount() {
        return musicBeans.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView img;
        private final TextView name;
        private final TextView desc;
        private final TextView count;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.listen_common_img);
            name = itemView.findViewById(R.id.item_watch_list_name);
            desc = itemView.findViewById(R.id.item_watch_list_desc);
            count = itemView.findViewById(R.id.item_watch_list_count);
        }
    }
}
