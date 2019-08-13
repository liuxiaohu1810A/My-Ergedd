package com.example.myergedd.fragment;

import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.myergedd.R;
import com.example.myergedd.base.SimpleFragment;
import com.example.myergedd.fragment.see.cartoon.CartoonFragment;
import com.example.myergedd.fragment.see.chosen.ChosenFragment;
import com.example.myergedd.fragment.see.early.EarlyFragment;
import com.example.myergedd.fragment.see.english.EnglishFragment;
import com.example.myergedd.fragment.see.erge.ErgeFragment;
import com.example.myergedd.fragment.see.partner.PartnerFragment;
import com.example.myergedd.fragment.see.story.StoryFragment;
import com.example.myergedd.fragment.see.synthesize.SynthesizeFragment;

import java.util.ArrayList;

public class SeeFragment extends SimpleFragment {
    private View view;
    private ImageView mChild;
    /**
     * 11岁7个月
     */
    private TextView mChildAge;
    private ImageView mIconSearch;
    private RelativeLayout mTopBar;
    private TabLayout mSeeTab;
    private ViewPager mSeeVp;

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_see;
    }

    @Override
    protected void initView(View view) {
        mChild = (ImageView) view.findViewById(R.id.child);
        mChildAge = (TextView) view.findViewById(R.id.child_age);
        mIconSearch = (ImageView) view.findViewById(R.id.icon_search);
        mTopBar = (RelativeLayout) view.findViewById(R.id.top_bar);
        mSeeTab = (TabLayout) view.findViewById(R.id.see_tab);
        mSeeVp = (ViewPager) view.findViewById(R.id.see_vp);
        final ArrayList<Fragment> fs = new ArrayList<>();
        fs.add(new ChosenFragment());
        fs.add(new CartoonFragment());
        fs.add(new ErgeFragment());
        fs.add(new StoryFragment());
        fs.add(new EarlyFragment());
        fs.add(new SynthesizeFragment());
        fs.add(new EnglishFragment());
        fs.add(new PartnerFragment());
        Log.e("fs", "initView: " + fs.size());
        final ArrayList<String> title = new ArrayList<>();
        title.add("精选");
        title.add("动画");
        title.add("儿歌");
        title.add("故事");
        title.add("早教");
        title.add("综合");
        title.add("英文");
        title.add("伙伴");
        mSeeVp.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
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
        mSeeTab.setupWithViewPager(mSeeVp);
    }
}
