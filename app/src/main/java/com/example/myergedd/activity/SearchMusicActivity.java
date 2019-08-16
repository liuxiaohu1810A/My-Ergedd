package com.example.myergedd.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.myergedd.R;
import com.example.myergedd.activity.searchhear.SearchHearMusicPresenter;
import com.example.myergedd.activity.searchhear.SearchMusicHear;
import com.example.myergedd.adapter.SearchHearMusicAdapter;
import com.example.myergedd.base.BaseActivity;
import com.example.myergedd.bean.SearchHearHotBean;
import com.example.myergedd.bean.SearchHearMusicBean;
import com.example.myergedd.utils.ClickUtils;
import com.example.myergedd.utils.ToastUtils;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SearchMusicActivity extends BaseActivity<SearchMusicHear.SearchMusicHearView, SearchHearMusicPresenter<SearchMusicHear.SearchMusicHearView>> implements SearchMusicHear.SearchMusicHearView {
    @BindView(R.id.search_music_back)
    ImageView mSearchMusicBack;
    @BindView(R.id.search_edit_frame_music)
    EditText mSearchEditFrameMusic;
    @BindView(R.id.search_remove_all)
    ImageView mSearchRemoveAll;
    @BindView(R.id.search_rl_music)
    RelativeLayout mSearchRlMusic;
    @BindView(R.id.search_songs_rlv_music)
    RecyclerView mSearchSongsRlvMusic;
    @BindView(R.id.search_determine_music)
    TextView mSearchDetermineMusic;
    @BindView(R.id.local_history_record)
    TagFlowLayout mLocalHistoryRecord;
    @BindView(R.id.search_histotry)
    LinearLayout mSearchHistotry;
    @BindView(R.id.search_refresh_other)
    TextView mSearchRefreshOther;
    @BindView(R.id.search_refresh_song)
    ImageView mSearchRefreshSong;
    @BindView(R.id.hot_search_text)
    RelativeLayout mHotSearchText;
    @BindView(R.id.hot_history_record)
    TagFlowLayout mHotHistoryRecord;
    @BindView(R.id.search_hot_search)
    LinearLayout mSearchHotSearch;
    private SearchHearMusicAdapter mAdapter;
    private int offset = 0;
    private RotateAnimation mRotateAnimation;

    @Override
    protected int getLayoutID() {
        return R.layout.activity_music_search;
    }

    @Override
    protected void initView() {
        mSearchSongsRlvMusic.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new SearchHearMusicAdapter(this);
        mSearchSongsRlvMusic.setVisibility(View.GONE);
        mSearchSongsRlvMusic.setAdapter(mAdapter);
    }

    @Override
    protected void initData() {
        mRotateAnimation = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        mRotateAnimation.setDuration(1000);
        mRotateAnimation.setInterpolator(new LinearInterpolator());
        mRotateAnimation.setRepeatCount(Integer.MAX_VALUE);
        mPresenter.setSearchHot(offset);
    }

    private void requestRemoteKeywords() {
        offset += 15;
        mPresenter.setSearchHot(offset);
    }

    @Override
    protected void initListener() {
    }

    @OnClick({R.id.search_music_back, R.id.search_remove_all, R.id.search_determine_music, R.id.search_refresh_song, R.id.search_refresh_other})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.search_music_back:
                finish();
                break;
            case R.id.search_remove_all:
                mSearchEditFrameMusic.setText("");
                mAdapter.mList.clear();
                mAdapter.notifyDataSetChanged();
                showKeyBoard();
                break;
            case R.id.search_determine_music:
                if (ClickUtils.isFastDoubleClick()) {//防止二次点击
                    requestSongsByKeyword();
                }
                break;
            case R.id.search_refresh_song:
                mSearchRefreshSong.clearAnimation();
                mSearchRefreshSong.startAnimation(mRotateAnimation);
                requestRemoteKeywords();
                break;
            case R.id.search_refresh_other:
                mSearchRefreshSong.clearAnimation();
                mSearchRefreshSong.startAnimation(mRotateAnimation);
                requestRemoteKeywords();
                break;
        }
    }

    private void showKeyBoard() {
        mSearchHistotry.setVisibility(View.VISIBLE);
        mSearchHotSearch.setVisibility(View.VISIBLE);
        InputMethodManager imm = (InputMethodManager) this.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(mSearchEditFrameMusic, 0);
    }

    private void requestSongsByKeyword() {
        hideKeyBoard();
        String keyword = mSearchEditFrameMusic.getText().toString();
        if (keyword.equals("console")) {
            return;
        }
        if (keyword.contains("%")) {
            ToastUtils.ShowToast("请勿输入特殊字符");
            return;
        }
        if (!TextUtils.isEmpty(keyword)) {
            requestMusicByKeyword(keyword);
        }
    }

    private void requestMusicByKeyword(String keywork) {
        mSearchSongsRlvMusic.setVisibility(View.VISIBLE);
        mPresenter.setSearchMusic(keywork);
    }

    private void hideKeyBoard() {
        mSearchHistotry.setVisibility(View.GONE);
        mSearchHotSearch.setVisibility(View.GONE);
        mSearchSongsRlvMusic.setVisibility(View.GONE);
        InputMethodManager imm = (InputMethodManager) this.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(mSearchEditFrameMusic.getWindowToken(), 0);
    }

    @Override
    public void onSearchMusicSuccessful(SearchHearMusicBean hearMusicBean) {
        if (hearMusicBean != null) {
            if (hearMusicBean.getAudios().size() > 0) {
                mAdapter.setDataHearList(hearMusicBean);
            }
        }
    }

    @Override
    public void onSearchHotSuccessful(final SearchHearHotBean hearHotBean) {
        mSearchRefreshSong.clearAnimation();
        if (hearHotBean != null) {
            if (hearHotBean.getKeywords().size() > 0) {
                mHotHistoryRecord.setAdapter(new TagAdapter(hearHotBean.getKeywords()) {
                    @Override
                    public int getCount() {
                        return hearHotBean.getKeywords().size();
                    }

                    @Override
                    public View getView(FlowLayout parent, final int position, Object o) {
                        TextView inflate = (TextView) LayoutInflater.from(SearchMusicActivity.this).inflate(R.layout.flow_item_navigation, parent, false);
                        if (hearHotBean == null && hearHotBean.getKeywords() == null) {
                            return null;
                        }
                        inflate.setText(hearHotBean.getKeywords().get(position));
                        inflate.setBackgroundResource(R.drawable.title_style_one);
                        inflate.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                mSearchEditFrameMusic.setText(hearHotBean.getKeywords().get(position));
                                requestSongsByKeyword();
                            }
                        });
                        return inflate;
                    }
                });
            }
        }
    }

    @Override
    public void onSearchMusicFiled(String error) {
        if (error != null) {
            ToastUtils.ShowToast(error);
        }
    }

    @Override
    protected SearchHearMusicPresenter<SearchMusicHear.SearchMusicHearView> initPresenter() {
        return new SearchHearMusicPresenter<>();
    }
}
