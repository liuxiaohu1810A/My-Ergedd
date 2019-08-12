package com.example.myergedd.fragment.see.chosen.early;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.myergedd.R;
import com.example.myergedd.adapter.EarlyAdapter;
import com.example.myergedd.base.BaseFragment;
import com.example.myergedd.bean.EarlyBean;
import com.example.myergedd.fragment.see.chosen.early.contract.Early;
import com.example.myergedd.fragment.see.chosen.early.presenter.IPresenter;

import java.util.List;

public class EarlyFragment extends BaseFragment<Early.EarlyView,IPresenter<Early.EarlyView>> implements Early.EarlyView {

    private RecyclerView res;
    private EarlyAdapter earlyAdapter;

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_early;
    }

    @Override
    protected IPresenter<Early.EarlyView> initPresenter() {
        return new IPresenter<>();
    }

    @Override
    protected void initView(View view) {
        res = view.findViewById(R.id.earlyRes);
        res.setLayoutManager(new LinearLayoutManager(getActivity()));
        earlyAdapter = new EarlyAdapter(getActivity());
        res.setAdapter(earlyAdapter);
    }

    @Override
    protected void initData() {
        mPresenter.setEarlyData();
    }

    @Override
    public void onSuccess(List<EarlyBean> earlyBeanList) {
        earlyAdapter.setEarlyBeans(earlyBeanList);
    }

    @Override
    public void onFailed(String error) {

    }
}
