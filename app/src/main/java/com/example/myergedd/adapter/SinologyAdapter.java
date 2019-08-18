package com.example.myergedd.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myergedd.R;
import com.example.myergedd.bean.MusicBean;
import com.example.myergedd.bean.SinologyBean;

import java.util.ArrayList;
import java.util.List;

import retrofit2.http.HEAD;

public class SinologyAdapter extends RecyclerView.Adapter<SinologyAdapter.ViewHolder> {

    private List<SinologyBean> sinologyBeans = new ArrayList<>();
    private Context context;

    public SinologyAdapter(Context context) {
        this.context = context;
    }

    public void setSinologyBeans(List<SinologyBean> sinologyBeans) {
        this.sinologyBeans = sinologyBeans;
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

            viewHolder.name.setText(sinologyBeans.get(i).getName());
            viewHolder.desc.setText(sinologyBeans.get(i).getDescription());
            viewHolder.count.setText(sinologyBeans.get(i).getCount()+"首");
            Glide.with(context).load(sinologyBeans.get(i).getSquare_image_url()).into(viewHolder.img);
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onclci.onclcik(sinologyBeans.get(i));
                }
            });
    }

    @Override
    public int getItemCount() {
        return sinologyBeans.size();
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

    private OnClick onclci;

    public void setOnclci(OnClick onclci) {
        this.onclci = onclci;
    }

    public interface OnClick {
        void onclcik(SinologyBean sinologyBean);
    }
}
