package com.example.myergedd.fragment.hear;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.myergedd.R;
import com.example.myergedd.base.SimpleFragment;

import com.example.myergedd.fragment.hear.chosen.ChosenFragment;
import com.example.myergedd.fragment.hear.english.EnglishFragment;
import com.example.myergedd.fragment.hear.erge.ErgeFragment;
import com.example.myergedd.fragment.hear.music.MusicFragment;
import com.example.myergedd.fragment.hear.sinology.SinologyFragment;
import com.example.myergedd.fragment.hear.story.StoryFragment;





import java.util.ArrayList;

public class HearFragment extends SimpleFragment {
    private View view;
    private ImageView mChild;
    /**
     * 11岁7个月
     */
    private TextView mChildAge;
    private ImageView mIconSearch;
    private RelativeLayout mTopBar;
    private TabLayout mHearTab;
    private ViewPager mHearVp;
    private ProgressBar mAudioPlayerProgressMini;
    private ImageView mMiniPlayerPlayStop;
    /**
     * 儿歌点点
     */
    private TextView mMiniPlayerSongName;
    /**
     * 00:00/00:00
     */
    private TextView mMiniPlayerPlayTime;
    private ImageView mMiniPlayerPlayPrev;
    private ImageView mMiniPlayerPlayNext;
    private ImageView mMiniPlayerPlayMode;
    private ImageView mMiniPlayerPlayTimer;
    private ImageView mMiniPlayerLrc;
    private LinearLayout mActionContainer;

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_hear;
    }

    public void initView(View view) {
        mChild = (ImageView) view.findViewById(R.id.child);
        mChildAge = (TextView) view.findViewById(R.id.child_age);
        mIconSearch = (ImageView) view.findViewById(R.id.icon_search);
        mTopBar = (RelativeLayout) view.findViewById(R.id.top_bar);
        mHearTab = (TabLayout) view.findViewById(R.id.hear_tab);
        mHearVp = (ViewPager) view.findViewById(R.id.hear_vp);
        mActionContainer = (LinearLayout) view.findViewById(R.id.action_container);

        final ArrayList<Fragment> fs = new ArrayList<>();
        fs.add(new ChosenFragment());
        fs.add(new ErgeFragment());
        fs.add(new StoryFragment());
        fs.add(new EnglishFragment());
        fs.add(new SinologyFragment());
        fs.add(new MusicFragment());
        Log.e("fs", "initView: " + fs.size());
        final ArrayList<String> title = new ArrayList<>();
        title.add("精选");
        title.add("儿歌");
        title.add("故事");
        title.add("英文");
        title.add("国学");
        title.add("纯音乐");
        mHearVp.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return fs.get(i);
            }

            @Override
            public int getCount() {
                return fs.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return title.get(position);
            }
        });
        mHearTab.setupWithViewPager(mHearVp);
    }
}
