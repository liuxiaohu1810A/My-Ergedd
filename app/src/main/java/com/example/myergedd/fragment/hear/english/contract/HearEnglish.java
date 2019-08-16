package com.example.myergedd.fragment.hear.english.contract;

import com.example.myergedd.base.BaseCallBack;
import com.example.myergedd.bean.MusicBean;
import com.example.myergedd.fragment.hear.english.bean.HearEnglishBean;

import java.util.List;

public interface HearEnglish {
    public interface HearEnglishView {
        void onSuccess(List<HearEnglishBean> hearEnglishBeanList);

        void onFailed(String error);
    }

    public interface HearEnglishModel {
        void getHearEnglish(BaseCallBack<List<HearEnglishBean>> hearEnglishCallBack);
    }

    public interface HearEnglishPresenter {
        void setHearEnglishData();
    }
}
