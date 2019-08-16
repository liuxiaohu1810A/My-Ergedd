package com.example.myergedd.fragment.hear;

import android.content.Intent;
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
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.myergedd.R;
import com.example.myergedd.activity.LrcActivity;
import com.example.myergedd.activity.SearchMusicActivity;
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
    private ImageView child;
    /**
     * 11岁7个月
     */
    private TextView childAge;
    private ImageView iconSearch;
    private RelativeLayout topBar;
    private TabLayout hearTab;
    private ViewPager hearVp;
    private ImageView listenPlayerStopImg;
    /**
     * 儿歌点点
     */
    private TextView listenPlayerSongName;
    /**
     * 00:00/00:00
     */
    private TextView listenPlayerPlayTime;
    private ImageView listenPlayerPlayPrev;
    private ImageView listenPlayerPlayNext;
    private ImageView listenPlayerPlayMode;
    private ImageView listenPlayerPlayTimer;
    private ImageView listenPlayerLrc;
    private LinearLayout actionContainer;

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_hear;
    }

    public void initView(View view) {

        child = (ImageView) view.findViewById(R.id.child);
        childAge = (TextView) view.findViewById(R.id.child_age);
        iconSearch = (ImageView) view.findViewById(R.id.icon_search);
        topBar = (RelativeLayout) view.findViewById(R.id.top_bar);
        hearTab = (TabLayout) view.findViewById(R.id.hear_tab);
        hearVp = (ViewPager) view.findViewById(R.id.hear_vp);
        listenPlayerStopImg = (ImageView) view.findViewById(R.id.listen_player_stop_img);
        listenPlayerSongName = (TextView) view.findViewById(R.id.listen_player_song_name);
        listenPlayerPlayTime = (TextView) view.findViewById(R.id.listen_player_play_time);
        listenPlayerPlayPrev = (ImageView) view.findViewById(R.id.listen_player_play_prev);
        listenPlayerPlayNext = (ImageView) view.findViewById(R.id.listen_player_play_next);
        listenPlayerPlayMode = (ImageView) view.findViewById(R.id.listen_player_play_mode);
        listenPlayerPlayTimer = (ImageView) view.findViewById(R.id.listen_player_play_timer);
        listenPlayerLrc = (ImageView) view.findViewById(R.id.listen_player_lrc);
        actionContainer = (LinearLayout) view.findViewById(R.id.action_container);

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
        hearVp.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
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
        hearTab.setupWithViewPager(hearVp);
    }

    @Override
    protected void initListener() {
        listenPlayerLrc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), LrcActivity.class));
            }
        });
        iconSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), SearchMusicActivity.class));
            }
        });
    }
}
