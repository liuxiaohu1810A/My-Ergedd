package com.example.myergedd.fragment.chosen;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myergedd.R;
import com.example.myergedd.bean.ChosenThree;
import com.example.myergedd.bean.ChosenTwoBean;

import java.util.ArrayList;
import java.util.List;

public class ChosenAdapter extends RecyclerView.Adapter {
    private static final int ONE = 1;
    private static final int TWO = 2;
    private static final int THREE = 3;
    List<ChosenTwoBean> mTwoBeans = new ArrayList<>();
    List<ChosenThree> mThrees = new ArrayList<>();
    String[] image = {"http://img5g22.ergedd.com/audio_playlist/66562931040_1493868622457.jpg",
            "http://img5g22.ergedd.com/video/24560_1558709189080.jpg"
            , "http://img5g22.ergedd.com/video/16552_1508849834248.jpg"
    };
    private Context mContext;


    public ChosenAdapter(Context context) {
        mContext = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        if (i == ONE) {
            return new MyImageViewHolder(inflater.inflate(R.layout.item_watch_choiceness_top, null));
        } else if (i == TWO) {
            return new MyTwoViewHolder(inflater.inflate(R.layout.item_watch_choiceness_center, null));
        } else {
            return new MyThreeViewHolder(inflater.inflate(R.layout.item_watch_choiceness_buttom, null));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        int type = getItemViewType(i);
        if (type == ONE) {
            MyImageViewHolder holder = (MyImageViewHolder) viewHolder;
            Glide.with(mContext).load(image[0]).into(holder.mWatch_top_pig);
            Glide.with(mContext).load(image[1]).into(holder.mWatch_top_chicken);
            Glide.with(mContext).load(image[2]).into(holder.mWatch_top_dog);
        } else if (type == TWO) {
            MyTwoViewHolder holder = (MyTwoViewHolder) viewHolder;
            Glide.with(mContext).load(mTwoBeans.get(0).getIcon_url()).into(holder.mListen_center_img);
            holder.mTv_title.setText(mTwoBeans.get(0).getName());
            Glide.with(mContext).load(mTwoBeans.get(1).getIcon_url()).into(holder.mListen_center_img_two);
            holder.mTv_title_two.setText(mTwoBeans.get(1).getName());
            Glide.with(mContext).load(mTwoBeans.get(2).getIcon_url()).into(holder.mListen_center_img_three);
            holder.mTv_title_three.setText(mTwoBeans.get(2).getName());
            Glide.with(mContext).load(mTwoBeans.get(3).getIcon_url()).into(holder.mListen_center_img_four);
            holder.mTv_title_four.setText(mTwoBeans.get(3).getName());
            Glide.with(mContext).load(mTwoBeans.get(4).getIcon_url()).into(holder.mListen_center_img_five);
            holder.mTv_title_five.setText(mTwoBeans.get(4).getName());
            Glide.with(mContext).load(mTwoBeans.get(5).getIcon_url()).into(holder.mListen_center_img_six);
            holder.mTv_title_six.setText(mTwoBeans.get(5).getName());
            Glide.with(mContext).load(mTwoBeans.get(6).getIcon_url()).into(holder.mListen_center_img_seven);
            holder.mTv_title_seven.setText(mTwoBeans.get(6).getName());
            Glide.with(mContext).load(mTwoBeans.get(7).getIcon_url()).into(holder.mListen_center_img_eight);
            holder.mTv_title_eight.setText(mTwoBeans.get(7).getName());
        } else {
            if (image.length > 0) {
                i = i - 1;
            }
            if (mTwoBeans.size() > 0) {
                i = i - 1;
            }
            MyThreeViewHolder holder = (MyThreeViewHolder) viewHolder;
            ChosenThree chosenThree = mThrees.get(i);
            Glide.with(mContext).load(chosenThree.getItem().getImage()).into(holder.mListen_buttom_img);
            holder.mListen_buttom_title.setText(chosenThree.getItem().getName());
        }
    }

    @Override
    public int getItemCount() {
        if (image.length > 0) {
            return mTwoBeans.size() + 1;
        } else if (mTwoBeans.size() > 0) {
            return mThrees.size() + 1;
        } else {
            return mThrees.size();
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (image.length > 0 && position == 0) {
            return ONE;
        } else if (position == 1 && image.length > 0 && mTwoBeans.size() > 0) {
            return TWO;
        } else {
            return THREE;
        }
    }

    public void setDataTwo(List<ChosenTwoBean> twoBeans) {
        mTwoBeans.addAll(twoBeans);
        notifyDataSetChanged();
    }

    public void setDataThree(List<ChosenThree> threes) {
        mThrees.addAll(threes);
        notifyDataSetChanged();
    }

    class MyImageViewHolder extends RecyclerView.ViewHolder {

        private ImageView mWatch_top_pig, mWatch_top_chicken, mWatch_top_dog;

        public MyImageViewHolder(View itemView) {
            super(itemView);
            mWatch_top_pig = itemView.findViewById(R.id.watch_top_pig);
            mWatch_top_chicken = itemView.findViewById(R.id.watch_top_chicken);
            mWatch_top_dog = itemView.findViewById(R.id.watch_top_dog);
        }
    }

    class MyTwoViewHolder extends RecyclerView.ViewHolder {

        private ImageView mListen_center_img, mListen_center_img_two,
                mListen_center_img_three, mListen_center_img_four,
                mListen_center_img_five, mListen_center_img_six, mListen_center_img_seven, mListen_center_img_eight;
        private TextView mTv_title, mTv_title_two, mTv_title_three, mTv_title_four,
                mTv_title_five, mTv_title_six, mTv_title_seven, mTv_title_eight;


        public MyTwoViewHolder(View itemView) {
            super(itemView);
            mListen_center_img = itemView.findViewById(R.id.listen_center_img);
            mTv_title = itemView.findViewById(R.id.tv_title);
            mListen_center_img_two = itemView.findViewById(R.id.listen_center_img_two);
            mTv_title_two = itemView.findViewById(R.id.tv_title_two);
            mListen_center_img_three = itemView.findViewById(R.id.listen_center_img_three);
            mTv_title_three = itemView.findViewById(R.id.tv_title_three);
            mListen_center_img_four = itemView.findViewById(R.id.listen_center_img_four);
            mTv_title_four = itemView.findViewById(R.id.tv_title_four);
            mListen_center_img_five = itemView.findViewById(R.id.listen_center_img_five);
            mTv_title_five = itemView.findViewById(R.id.tv_title_five);
            mListen_center_img_six = itemView.findViewById(R.id.listen_center_img_six);
            mTv_title_six = itemView.findViewById(R.id.tv_title_six);
            mListen_center_img_seven = itemView.findViewById(R.id.listen_center_img_seven);
            mTv_title_seven = itemView.findViewById(R.id.tv_title_seven);
            mListen_center_img_eight = itemView.findViewById(R.id.listen_center_img_eight);
            mTv_title_eight = itemView.findViewById(R.id.tv_title_eight);
        }
    }

    class MyThreeViewHolder extends RecyclerView.ViewHolder {

        private final ImageView mListen_buttom_img, mListen_center_img;
        private final TextView mListen_buttom_title;

        public MyThreeViewHolder(View itemView) {
            super(itemView);
            mListen_buttom_img = itemView.findViewById(R.id.listen_buttom_img);
            mListen_buttom_title = itemView.findViewById(R.id.listen_buttom_title);
            mListen_center_img = itemView.findViewById(R.id.listen_center_img);
        }
    }
}
