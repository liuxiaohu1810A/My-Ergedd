package com.example.myergedd.fragment.cache;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.myergedd.R;
import com.example.myergedd.adapter.Table_Vp_Adapter;
import com.example.myergedd.base.SimpleFragment;
import com.example.myergedd.fragment.cache.album.Video_albumFragment;
import com.example.myergedd.fragment.cache.frequency.Frequency_Fragment;
import com.example.myergedd.fragment.cache.video.Video_Fragment;

import java.util.ArrayList;

public class CacheFragment extends SimpleFragment implements View.OnClickListener {


    private View view;
    /**
     * 清理缓存
     */
    private TextView mCacheClean;
    private RelativeLayout mTopBar;
    private TabLayout mCacheTable;
    private ViewPager mCacheVp;
    /**
     * 关注微信好礼
     */
    private TextView mCacheGift;
    private ArrayList<Fragment> fragments;
    private ArrayList<String> title;
    private Table_Vp_Adapter table_vp_adapter;
    private ImageView mSetting;

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_cache;
    }

    public void initView(View view) {
        mSetting = (ImageView) view.findViewById(R.id.setting);
        mSetting.setOnClickListener(this);
        mCacheClean = (TextView) view.findViewById(R.id.cache_clean);
        mTopBar = (RelativeLayout) view.findViewById(R.id.top_bar);
        mCacheTable = (TabLayout) view.findViewById(R.id.cache_Table);
        mCacheVp = (ViewPager) view.findViewById(R.id.cache_vp);
        mCacheGift = (TextView) view.findViewById(R.id.cache_gift);

        fragments = new ArrayList<>();
        fragments.add(new Video_albumFragment());
        fragments.add(new Video_Fragment());
        fragments.add(new Frequency_Fragment());
        title = new ArrayList<>();
        title.add("视频专辑");
        title.add("视频");
        title.add("音频");
        mCacheTable.setupWithViewPager(mCacheVp);
        table_vp_adapter = new Table_Vp_Adapter(getChildFragmentManager(), fragments, title);
        mCacheVp.setAdapter(table_vp_adapter);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.setting:
                
                break;
        }
    }
}
