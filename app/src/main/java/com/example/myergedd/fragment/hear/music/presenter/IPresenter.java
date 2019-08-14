package com.example.myergedd.fragment.hear.music.presenter;

import com.example.myergedd.base.BaseCallBack;
import com.example.myergedd.base.BasePresenter;
import com.example.myergedd.bean.EnglishBean;
import com.example.myergedd.bean.MusicBean;
import com.example.myergedd.fragment.hear.music.contract.Music;
import com.example.myergedd.fragment.hear.music.model.IModel;

import java.util.List;

public class IPresenter<V extends Music.MusicView> extends BasePresenter<V> implements Music.MusicPresenter {
    private Music.MusicModel model = new IModel();

    @Override
    public void setMusicData() {
        if (mView != null) {
            model.getMusic(new BaseCallBack<List<MusicBean>>() {
                @Override
                public void onSuccessful(List<MusicBean> musicBeanList) {
                    mView.onSuccess(musicBeanList);
                }

                @Override
                public void onFiled(String filed) {
                    if (filed != null) {
                        mView.onFailed(filed);
                    }

                }
            });
        }
    }
}
