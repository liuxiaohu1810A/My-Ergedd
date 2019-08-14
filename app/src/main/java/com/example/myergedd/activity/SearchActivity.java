package com.example.myergedd.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.myergedd.R;
import com.example.myergedd.activity.searchsee.SearchSee;
import com.example.myergedd.activity.searchsee.SearchSeePresenter;
import com.example.myergedd.adapter.SearchSeeAdapter;
import com.example.myergedd.adapter.SearchSeeHotAdapter;
import com.example.myergedd.base.BaseActivity;
import com.example.myergedd.bean.SearchSeeAlbumsBean;
import com.example.myergedd.bean.SearchSeeHotBean;
import com.example.myergedd.bean.SearchSeeVideosBean;
import com.example.myergedd.utils.ToastUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SearchActivity extends BaseActivity<SearchSee.SearchSeeView, SearchSeePresenter<SearchSee.SearchSeeView>> implements SearchSee.SearchSeeView {
    @BindView(R.id.search_icon)
    ImageView mSearchIcon;
    @BindView(R.id.search_song_name)
    EditText mSearchSongName;
    @BindView(R.id.search_clean_all)
    ImageView mSearchCleanAll;
    @BindView(R.id.btn_action)
    TextView mBtnAction;
    @BindView(R.id.search_recently_hot_title)
    TextView mSearchRecentlyHotTitle;
    @BindView(R.id.search_recently_no_title)
    TextView mSearchRecentlyNoTitle;
    @BindView(R.id.search_try_recently_other_title)
    TextView mSearchTryRecentlyOtherTitle;
    @BindView(R.id.search_hot_title)
    TextView mSearchHotTitle;
    @BindView(R.id.search_songs_rlv)
    RecyclerView mRlv;
    @BindView(R.id.search_songs_hot_rlv)
    RecyclerView mSearchSongsHotRlv;
    @BindView(R.id.search_hot_ll)
    LinearLayout mSearchHotLl;
    private SearchSeeAdapter mAdapter;
    private SearchSeeHotAdapter mAdapterHot;

    @Override
    protected int getLayoutID() {
        return R.layout.activity_search;
    }

    @Override
    protected void initView() {
        mSearchSongsHotRlv.setLayoutManager(new GridLayoutManager(this, 2, LinearLayoutManager.VERTICAL, false));
        mAdapterHot = new SearchSeeHotAdapter(this);
        mSearchHotLl.setVisibility(View.VISIBLE);
        mSearchSongsHotRlv.setAdapter(mAdapterHot);
        mRlv.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new SearchSeeAdapter(this);
        mRlv.setVisibility(View.GONE);
        mRlv.setAdapter(mAdapter);
    }

    @Override
    protected void initData() {
        requestRemoteKeywords();
        initLocalHistoryKeyword();
    }

    private void initLocalHistoryKeyword() {

    }

    private void requestRemoteKeywords() {
        mPresenter.setDataHotSearch();
    }

    @Override
    protected void initListener() {
        mSearchSongName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (TextUtils.isEmpty(s.toString())) {
                    mBtnAction.setText("取消");
                    mBtnAction.setTextColor(getResources().getColor(R.color.FONT_DARK));
                } else {
                    mBtnAction.setText("搜索");
                    mBtnAction.setTextColor(getResources().getColor(R.color.main_color));
                }
            }
        });
        mAdapter.setOnClickListener(new SearchSeeAdapter.onClickListener() {
            @Override
            public void onClick(View v, int position) {
                Intent intent = new Intent(SearchActivity.this, CommonSeeActivity.class);
                SearchSeeAlbumsBean bean = mAdapter.mAlbumsList.get(position);
                intent.putExtra("id", bean.getId());
                intent.putExtra("title", bean.getName());
                startActivity(intent);
            }
        });
    }

    private void hideKeyBoard() {
        mSearchHotLl.setVisibility(View.GONE);
        InputMethodManager imm = (InputMethodManager) this.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(mSearchSongName.getWindowToken(), 0);
    }

    @OnClick({R.id.search_icon, R.id.search_song_name, R.id.search_clean_all, R.id.btn_action, R.id.search_recently_hot_title, R.id.search_recently_no_title, R.id.search_try_recently_other_title, R.id.search_songs_hot_rlv, R.id.search_songs_rlv})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.search_icon:
                break;
            case R.id.search_song_name:
                break;
            case R.id.search_clean_all:
                mSearchSongName.setText("");
                mRlv.setVisibility(View.GONE);
                mAdapter.mAlbumsList.clear();
                mAdapter.mVideosList.clear();
                mAdapter.notifyDataSetChanged();
                showKeyBoard();
                break;
            case R.id.btn_action:
                if ("取消".equals(mBtnAction.getText())) {
                    finish();
                } else {
//                    TrackUtil.trackEvent(pv, "input.keyword.submit", mSearchName.getText().toString().trim(), 1);
                    /*if (mListAdapter != null)
                        mListAdapter.clear();
                    isReachEnd = false;
                    requestSongsByKeyword();*/
                    requestSongsByKeyword();
                    hideKeyBoard();
                }
                break;
            case R.id.search_recently_hot_title:
                break;
            case R.id.search_recently_no_title:
                break;
            case R.id.search_try_recently_other_title:
                break;
            case R.id.search_songs_hot_rlv:
                break;
            case R.id.search_songs_rlv:
                break;
        }
    }

    private void showKeyBoard() {
        mSearchHotLl.setVisibility(View.VISIBLE);
        mSearchSongName.requestFocus();
        mSearchSongName.setFocusable(true);
        InputMethodManager imm = (InputMethodManager) this.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(mSearchSongName, 0);
    }

    private void requestSongsByKeyword() {
        String keyword = mSearchSongName.getText().toString();
        if (keyword.equals("console")) {
            return;
        }
        if (keyword.contains("%")) {
            ToastUtils.ShowToast("请勿输入特殊字符");
            return;
        }
        ToastUtils.ShowToast(keyword);

        if (!TextUtils.isEmpty(keyword)) {
            checkAndSaveKeywords(keyword);
            requestVideosByKeyword(keyword);
        }
    }

    private void requestVideosByKeyword(String keyword) {
        mPresenter.setDataAlbumsSearch(keyword);
        mPresenter.setDataVideoSearch(keyword);
        mRlv.setVisibility(View.VISIBLE);
        mBtnAction.setText("取消");
        mBtnAction.setTextColor(getResources().getColor(R.color.FONT_DARK));
    }

    private void checkAndSaveKeywords(String keyword) {

    }

    @Override
    protected SearchSeePresenter<SearchSee.SearchSeeView> initPresenter() {
        return new SearchSeePresenter<>();
    }

    @Override
    public void onAlbumsSuccessful(List<SearchSeeAlbumsBean> searchSeeBeans) {
        if (searchSeeBeans != null) {
            if (searchSeeBeans.size() > 0) {
                mAdapter.setDataAlbumsSearchSee(searchSeeBeans);
            }
        }
    }

    @Override
    public void onVideoSuccessful(List<SearchSeeVideosBean> searchSeeBeans) {
        if (searchSeeBeans != null) {
            if (searchSeeBeans.size() > 0) {
                mAdapter.setDataVideoSearchSee(searchSeeBeans);
            }
        }
    }

    @Override
    public void onHotSuceessful(SearchSeeHotBean seeHotBean) {
        if (seeHotBean != null) {
            if (seeHotBean.getKeywords().size() > 0) {
                mAdapterHot.setDataHotSearchSee(seeHotBean);
            }
        }
    }

    @Override
    public void onFailed(String error) {
        if (error != null) {
            ToastUtils.ShowToast(error);
        }
    }
}
