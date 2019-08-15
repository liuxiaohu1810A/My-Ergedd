package com.example.myergedd.fragment.hear.music.contract;

import com.example.myergedd.base.BaseCallBack;

import com.example.myergedd.bean.MusicBean;

import java.util.List;

public interface Music {
    public interface MusicView {
        void onSuccess(List<MusicBean> musicBeanList);

        void onFailed(String error);
    }

    public interface MusicModel {
        void getMusic(BaseCallBack<List<MusicBean>> musicCallBack);
    }

    public interface MusicPresenter {
        void setMusicData();
    }
}
