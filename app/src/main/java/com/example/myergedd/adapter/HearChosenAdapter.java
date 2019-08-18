package com.example.myergedd.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myergedd.R;
import com.example.myergedd.app.ApiServier;
import com.example.myergedd.base.BaseObserver;
import com.example.myergedd.base.BaseResponse;
import com.example.myergedd.bean.ChosenBean;
import com.example.myergedd.bean.ChosenBeanBan;
import com.example.myergedd.http.HttpManager;
import com.example.myergedd.utils.RxJavaUtils;

import java.util.ArrayList;
import java.util.List;

public class HearChosenAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final FragmentActivity activity;
    private ArrayList<ChosenBean> chosen = new ArrayList<>();
    String[] image = {"http://img5g22.ergedd.com/audio_playlist/4999061041_1493868643040.jpg",
            "http://img5g22.ergedd.com/audio_playlist/66562931040_1493868622457.jpg"
            , "http://img5g22.ergedd.com/audio_playlist/13711963478_1493868665752.jpg"
    };
    private ArrayList<ChosenBeanBan> chosenBeanBans=new ArrayList<>();
    private ChosenBeanAdapter chosenTwo;

    public HearChosenAdapter(FragmentActivity activity) {

        this.activity = activity;
    }

    public void setChosen(List<ChosenBean> beans) {

        chosen.addAll(beans);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (i==0){
            View view = View.inflate(activity, R.layout.item_watch_choiceness_top, null);
            return new ViewHolderBan(view);
        }else if (i==1){
            View view = View.inflate(activity, R.layout.item_chosen_two, null);
            return new ViewHolderTwo(view);
        }else{
            View view = View.inflate(activity, R.layout.item_choiceness_tree, null);
            return new ViewHolder(view);
        }
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        int type = getItemViewType(i);
        if (type==0){
            ViewHolderBan holder = (ViewHolderBan) viewHolder;
            Glide.with(activity).load(image[0]).into(holder.imgpig);
            Glide.with(activity).load(image[1]).into(holder.imghou);
            Glide.with(activity).load(image[2]).into(holder.imgdog);
        }else if (type==1){
            ViewHolderTwo holder2 = (ViewHolderTwo) viewHolder;
            holder2.rlv.setLayoutManager(new GridLayoutManager(activity,3));
            chosenTwo = new ChosenBeanAdapter(activity);
            holder2.rlv.setAdapter(chosenTwo);


            HttpManager.getInstance().getServer(ApiServier.class).getChosenBanData()
                    .compose(RxJavaUtils.<BaseResponse<List<ChosenBeanBan>>>rxScheduleThread())
                    .compose(RxJavaUtils.<List<ChosenBeanBan>>changeResult())
                    .subscribe(new BaseObserver<List<ChosenBeanBan>>() {
                        @Override
                        public void onSuccessful(List<ChosenBeanBan> data) {
                            chosenTwo.setChosenBean(data);
                        }

                        private static final String TAG = "HearChosenAdapter";
                        @Override
                        public void onFailed(String error) {
                            Log.d(TAG, "onFailed: "+error);
                        }
                    });
        }else{
            ViewHolder holder3 = (ViewHolder) viewHolder;
            if (image.length>0){
                i=i-2;
            }
            ChosenBean chosenBean = chosen.get(i);
            holder3.title.setText(chosenBean.getName());
            Glide.with(activity).load(chosenBean.getImage()).into(holder3.tu);
            List<ChosenBean.PlaylistsBean> playlists = chosenBean.getPlaylists();
            holder3.name.setText(playlists.get(0).getCount() + "");
            holder3.desc.setText(playlists.get(0).getName());
            Glide.with(activity).load(playlists.get(0).getSquare_image_url()).into(holder3.img);

            holder3.nameer.setText(playlists.get(1).getCount() + "");
            holder3.descer.setText(playlists.get(1).getName());
            Glide.with(activity).load(playlists.get(1).getSquare_image_url()).into(holder3.imger);

            holder3.namesan.setText(playlists.get(2).getCount() + "");
            holder3.descsan.setText(playlists.get(2).getName());
            Glide.with(activity).load(playlists.get(2).getSquare_image_url()).into(holder3.imgsan);
        }


    }

    @Override
    public int getItemCount() {
        if (image.length>0){
            return chosen.size()+2;
        }else{
            return chosenBeanBans.size();
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position==0){
            return 0;
        }else if (position==1 ){
            return 1;
        }else{
            return 2;
        }
    }
    //精选布局一
    public class ViewHolderBan extends RecyclerView.ViewHolder {

        private final ImageView imgdog;

        private final ImageView imgpig;

        private final ImageView imghou;

        public ViewHolderBan(@NonNull View itemView) {
            super(itemView);
            imgpig = itemView.findViewById(R.id.watch_top_pig);
            imghou = itemView.findViewById(R.id.watch_top_chicken);
            imgdog = itemView.findViewById(R.id.watch_top_dog);
        }
    }
    //精选布局二
    public class ViewHolderTwo extends RecyclerView.ViewHolder {
        private final RecyclerView rlv;
        public ViewHolderTwo(@NonNull View itemView) {
            super(itemView);
            rlv = itemView.findViewById(R.id.rlv_chosen);

        }

    }
    //精选布局三
    public class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView tu;
        private final TextView title;

        private final ImageView img;
        private final TextView desc;
        private final TextView name;

        private final ImageView imger;
        private final TextView descer;
        private final TextView nameer;

        private final ImageView imgsan;
        private final TextView descsan;
        private final TextView namesan;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tu = itemView.findViewById(R.id.icon);
            title = itemView.findViewById(R.id.title);
            img = itemView.findViewById(R.id.item_chosen_img);
            name = itemView.findViewById(R.id.item_chosen_count);
            desc = itemView.findViewById(R.id.item_chosen_type);
            imger = itemView.findViewById(R.id.item_chosen_img_er);
            nameer = itemView.findViewById(R.id.item_chosen_count_er);
            descer = itemView.findViewById(R.id.item_chosen_type_er);
            imgsan = itemView.findViewById(R.id.item_chosen_img_san);
            namesan = itemView.findViewById(R.id.item_chosen_count_san);
            descsan = itemView.findViewById(R.id.item_chosen_type_san);
        }
    }
}
