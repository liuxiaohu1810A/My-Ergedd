package com.example.myergedd.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.myergedd.R;
import com.example.myergedd.activity.SettingActivity;
import com.example.myergedd.base.SimpleFragment;

public class CacheFragment extends SimpleFragment {
    private View view;
    private ImageView mSetting;
    /**
     * 清理缓存
     */
    private TextView mCacheClean;
    private RelativeLayout mTopBar;
    private ViewPager mCacheVp;
    /**
     * 关注微信好礼
     */
    private TextView mCacheGift;

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_cache;
    }

    public void initView(View view) {
        mSetting = (ImageView) view.findViewById(R.id.setting);
        mCacheClean = (TextView) view.findViewById(R.id.cache_clean);
        mTopBar = (RelativeLayout) view.findViewById(R.id.top_bar);
        mCacheVp = (ViewPager) view.findViewById(R.id.cache_vp);
        mCacheGift = (TextView) view.findViewById(R.id.cache_gift);

        mSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SettingActivity.class);
                startActivity(intent);
            }
        });
    }
}
