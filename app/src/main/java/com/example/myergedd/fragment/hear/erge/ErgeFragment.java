package com.example.myergedd.fragment.hear.erge;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myergedd.R;

import com.example.myergedd.base.BaseFragment;
import com.example.myergedd.fragment.hear.erge.bean.Listen_ErgeBean;
import com.example.myergedd.fragment.hear.erge.contract.Erge;
import com.example.myergedd.fragment.hear.erge.presenter.IPresenter;


import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class ErgeFragment extends BaseFragment<Erge.ErgeView,IPresenter<Erge.ErgeView>> implements Erge.ErgeView {

    @BindView(R.id.englishRes)
    RecyclerView mEnglishRes;
    private View view;
    private Unbinder unbinder;

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_english;
    }


    @Override
    protected IPresenter<Erge.ErgeView> initPresenter() {

        return null;
    }

    @Override
    public void OnSuccess(List<Listen_ErgeBean> listen_ergeBeans) {

    }

    @Override
    public void OnFailed(String error) {

    }
}
