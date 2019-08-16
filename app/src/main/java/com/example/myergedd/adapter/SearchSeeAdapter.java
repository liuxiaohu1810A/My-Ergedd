package com.example.myergedd.adapter;

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
import com.example.myergedd.bean.SearchSeeAlbumsBean;
import com.example.myergedd.bean.SearchSeeVideosBean;

import java.util.ArrayList;
import java.util.List;

public class SearchSeeAdapter extends RecyclerView.Adapter {
    public List<SearchSeeAlbumsBean> mAlbumsList = new ArrayList<>();
    public List<SearchSeeVideosBean> mVideosList = new ArrayList<>();
    private Context mContext;
    private onClickListener mListener;
    private static final int TYPE_TITLE = 1;
    private static final int TYPE_ALBUM = 2;
    private static final int TYPE_VIDEO = 3;

    public SearchSeeAdapter(Context context) {
        mContext = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        switch (i) {
            case TYPE_TITLE:
                return new MyTitleViewHolder(inflater.inflate(R.layout.item_watch_search_title, null));
            case TYPE_ALBUM:
                return new MyAlbumsViewHolder(inflater.inflate(R.layout.item_watch_common, null));
            case TYPE_VIDEO:
                return new MyVideoViewHolder(inflater.inflate(R.layout.item_watch_choiceness_buttom, null));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        int type = getItemViewType(i);
        switch (type) {
            case TYPE_TITLE:
                if (mAlbumsList.size() > 0 && i == 0) {
                    ((MyTitleViewHolder) viewHolder).mTitle.setText("专辑");
                } else {
                    ((MyTitleViewHolder) viewHolder).mTitle.setText("视频");
                }
                break;
            case TYPE_ALBUM:
                final int albumIndex = i - 1;
                MyAlbumsViewHolder holder = (MyAlbumsViewHolder) viewHolder;
                holder.name.setText(mAlbumsList.get(albumIndex).getName());
                holder.desc.setText(mAlbumsList.get(albumIndex).getDescription());
                holder.ji.setText("共" + mAlbumsList.get(albumIndex).getVideo_count() + "集");
                Glide.with(mContext).load(mAlbumsList.get(albumIndex).getImage_url()).into(holder.img);
                viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (mListener != null) {
                            mListener.onClick(v, albumIndex);
                        }
                    }
                });
                break;
            case TYPE_VIDEO:
                int videoIndex = i - mAlbumsList.size() - (mAlbumsList.size() == 0 ? 0 : 1) - 1;
                SearchSeeVideosBean bean = mVideosList.get(videoIndex);
                MyVideoViewHolder holder1 = (MyVideoViewHolder) viewHolder;
                Glide.with(mContext).load(bean.getImage()).into(holder1.mListen_buttom_img);
                holder1.mListen_buttom_title.setText(bean.getName());
                break;
        }
    }

    public void setDataAlbumsSearchSee(List<SearchSeeAlbumsBean> searchSeeBeans) {
        if (searchSeeBeans != null) {
            if (searchSeeBeans.size() > 0) {
                mAlbumsList.addAll(searchSeeBeans);
                notifyDataSetChanged();
            }
        }
    }

    public void setDataVideoSearchSee(List<SearchSeeVideosBean> searchSeeBeans) {
        if (searchSeeBeans != null) {
            if (searchSeeBeans.size() > 0) {
                mVideosList.addAll(searchSeeBeans);
                notifyDataSetChanged();
            }
        }
    }

    class MyAlbumsViewHolder extends RecyclerView.ViewHolder {
        private final ImageView img;
        private final TextView name;
        private final TextView desc;
        private final TextView ji;

        public MyAlbumsViewHolder(View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.cartoon_img);
            name = itemView.findViewById(R.id.item_watch_list_name);
            desc = itemView.findViewById(R.id.item_watch_list_desc);
            ji = itemView.findViewById(R.id.cartoom_ji);
        }
    }

    class MyTitleViewHolder extends RecyclerView.ViewHolder {

        private TextView mTitle;

        public MyTitleViewHolder(View itemView) {
            super(itemView);
            mTitle = itemView.findViewById(R.id.search_see_title);
        }
    }

    class MyVideoViewHolder extends RecyclerView.ViewHolder {
        private ImageView mListen_buttom_img, mListen_center_img;
        private TextView mListen_buttom_title;

        public MyVideoViewHolder(View itemView) {
            super(itemView);
            mListen_buttom_img = itemView.findViewById(R.id.listen_buttom_img);
            mListen_buttom_title = itemView.findViewById(R.id.listen_buttom_title);
            mListen_center_img = itemView.findViewById(R.id.listen_center_img);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_TITLE;
        } else if (position > 0 && position <= mAlbumsList.size()) {
            return TYPE_ALBUM;
        } else if (position == mAlbumsList.size() + (mAlbumsList.size() == 0 ? 0 : 1))
            return TYPE_TITLE;
        else
            return TYPE_VIDEO;
    }

    @Override
    public int getItemCount() {
        return mAlbumsList.size() + mVideosList.size() + (mAlbumsList.size() == 0 ? 0 : 1) + (mVideosList.size() == 0 ? 0 : 1);
    }

    public interface onClickListener {
        void onClick(View v, int position);
    }


    public void setOnClickListener(onClickListener listener) {
        mListener = listener;
    }
}
