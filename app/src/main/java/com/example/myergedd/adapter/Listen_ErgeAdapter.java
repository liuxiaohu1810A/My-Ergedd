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

import retrofit2.http.HEAD;

public class Listen_ErgeAdapter extends RecyclerView.Adapter<Listen_ErgeAdapter.ViewHolder> {

    private List<Listen_ErgeBean> Listen_ErgeBean = new ArrayList<>();
    private Context context;

    public Listen_ErgeAdapter(Context context) {
        this.context = context;
    }

    public void setListen_ergeAdapters(List<Listen_ErgeBean> Listen_ErgeBean) {
        this.Listen_ErgeBean = Listen_ErgeBean;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.item_listen_common, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
            viewHolder.item_watch_list_name.setText(Listen_ErgeBean.get(i).getName());
            viewHolder.item_watch_list_desc.setText(Listen_ErgeBean.get(i).getDescription());
            viewHolder.item_watch_list_count.setText(Listen_ErgeBean.get(i).getCount()+"");
            Glide.with(context).load(Listen_ErgeBean.get(i).getSquare_image_url()).into(viewHolder.listen_common_img);
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onclick.onclcick(Listen_ErgeBean.get(i));
                }
            });
    }

    @Override
    public int getItemCount() {
        return Listen_ErgeBean.size();
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

    private OnClick onclick;

    public void setOnclick(OnClick onclick) {
        this.onclick = onclick;
    }

    public interface OnClick{
        void onclcick(Listen_ErgeBean listen_ergeBean);
    }
}