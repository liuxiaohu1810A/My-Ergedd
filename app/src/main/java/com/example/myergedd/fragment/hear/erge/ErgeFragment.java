package com.example.myergedd.fragment.hear.erge;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.example.myergedd.R;
import com.example.myergedd.adapter.Listen_ErgeAdapter;
import com.example.myergedd.base.BaseFragment;
import com.example.myergedd.fragment.hear.erge.bean.Listen_ErgeBean;
import com.example.myergedd.fragment.hear.erge.contract.Erge;
import com.example.myergedd.fragment.hear.erge.presenter.IPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Unbinder;

public class ErgeFragment extends BaseFragment<Erge.ErgeView, IPresenter<Erge.ErgeView>> implements Erge.ErgeView {


    private ArrayList<Listen_ErgeBean> list;
    private Listen_ErgeAdapter adapter;
    private static final String TAG = "ErgeFragment";
    private RecyclerView englishRes;

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_english;
    }

    @Override
    protected void initView(View view) {
        englishRes = view.findViewById(R.id.englishRes);

        englishRes.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new Listen_ErgeAdapter(getContext());
        englishRes.setAdapter(adapter);

    }

    @Override
    protected void initData() {
        mPresenter.getListenErgeData();
    }

    @Override
    protected IPresenter<Erge.ErgeView> initPresenter() {
        return new IPresenter<>();
    }

    @Override
    public void OnSuccess(List<Listen_ErgeBean> listen_ergeBeans) {
        adapter.setList(listen_ergeBeans);
    }

    @Override
    public void OnFailed(String error) {
        Log.i(TAG, "OnFailed: " + error);
    }
}
