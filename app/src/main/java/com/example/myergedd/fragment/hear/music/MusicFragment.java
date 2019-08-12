package com.example.myergedd.fragment.hear.music;

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

import java.util.List;

public class MusicFragment extends BaseFragment<Music.MusicView,IPresenter<Music.MusicView>>implements Music.MusicView {

    private RecyclerView res;
    private MusicAdapter musicAdapter;

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
