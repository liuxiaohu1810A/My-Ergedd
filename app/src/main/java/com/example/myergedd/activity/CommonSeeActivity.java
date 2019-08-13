package com.example.myergedd.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.myergedd.R;
import com.example.myergedd.activity.commonsee.CommonSee;
import com.example.myergedd.activity.commonsee.CommonSeeAdapter;
import com.example.myergedd.activity.commonsee.CommonSeeBean;
import com.example.myergedd.activity.commonsee.CommonSeePresenter;
import com.example.myergedd.base.BaseActivity;
import com.example.myergedd.utils.ToastUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class CommonSeeActivity extends BaseActivity<CommonSee.CommonSeeView, CommonSeePresenter<CommonSee.CommonSeeView>> implements CommonSee.CommonSeeView {
    @BindView(R.id.icon_back_common)
    ImageView mIconBackCommon;
    @BindView(R.id.tv_title_common)
    TextView mTvTitleCommon;
    @BindView(R.id.icon_share)
    ImageView mIconShare;
    @BindView(R.id.icon_album)
    ImageView mIconAlbum;
    @BindView(R.id.top_bar)
    RelativeLayout mTopBar;
    private int mId;
    @BindView(R.id.common_rlv)
    RecyclerView mRlv;
    private CommonSeeAdapter mAdapter;

    @Override
    protected int getLayoutID() {
        return R.layout.activity_see_common;
    }

    @Override
    protected void initView() {
        Intent intent = getIntent();
        if (intent == null) {
            return;
        }
        String title = intent.getStringExtra("title");
        mId = intent.getIntExtra("id", -1);
        ToastUtils.ShowToast(mId + "");
        mTvTitleCommon.setText(title);
        mRlv.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new CommonSeeAdapter(this);
        mRlv.setAdapter(mAdapter);
    }

    @Override
    protected void initData() {
        mPresenter.setCommonData(mId);
    }

    @OnClick({R.id.icon_back_common, R.id.icon_share, R.id.icon_album})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.icon_back_common:
                finish();
                break;
            case R.id.icon_share:
                ToastUtils.ShowToast("分享");
                break;
            case R.id.icon_album:
                ToastUtils.ShowToast("聊天");
                break;
        }
    }

    @Override
    protected CommonSeePresenter<CommonSee.CommonSeeView> initPresenter() {
        return new CommonSeePresenter<>();
    }

    @Override
    public void onSuccessful(List<CommonSeeBean> commonSeeBeans) {
        if (commonSeeBeans != null) {
            if (commonSeeBeans.size() > 0) {
                mAdapter.setCommonData(commonSeeBeans);
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
