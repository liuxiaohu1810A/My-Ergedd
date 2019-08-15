package com.example.myergedd.fragment.hear.music;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.myergedd.R;
import com.example.myergedd.adapter.MusicAdapter;
import com.example.myergedd.base.BaseFragment;
import com.example.myergedd.base.SimpleFragment;
import com.example.myergedd.bean.MusicBean;
import com.example.myergedd.fragment.hear.music.contract.Music;
import com.example.myergedd.fragment.hear.music.presenter.IPresenter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.List;

public class MusicFragment extends BaseFragment<Music.MusicView,IPresenter<Music.MusicView>>implements Music.MusicView {

    private RecyclerView res;
    private MusicAdapter musicAdapter;
    private SmartRefreshLayout mSmart;
    int page=0;

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_english;
    }

    @Override
    protected void initView(View view) {
        res = view.findViewById(R.id.englishRes);
        res.setLayoutManager(new LinearLayoutManager(getActivity()));
        musicAdapter = new MusicAdapter(getActivity());
        res.setAdapter(musicAdapter);
        mSmart = (SmartRefreshLayout) view.findViewById(R.id.smart);
        mSmart.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                page++;
                initData();
                mSmart.finishLoadMore();
            }

            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                page=0;
                initData();
                mSmart.finishRefresh();
            }
        });
    }

    @Override
    protected void initData() {
        mPresenter.setMusicData();
    }

    @Override
    protected IPresenter<Music.MusicView> initPresenter() {
        return new IPresenter<>();
    }

    @Override
    public void onSuccess(List<MusicBean> musicBeanList) {
        musicAdapter.setMusicBeans(musicBeanList);
    }

    @Override
    public void onFailed(String error) {

    }
}
