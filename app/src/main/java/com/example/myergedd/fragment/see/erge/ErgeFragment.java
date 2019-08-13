package com.example.myergedd.fragment.see.chosen.erge;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.myergedd.R;
import com.example.myergedd.adapter.ErgeAdapter;
import com.example.myergedd.base.BaseFragment;
import com.example.myergedd.base.SimpleFragment;
import com.example.myergedd.bean.ErgeBean;
import com.example.myergedd.fragment.see.chosen.erge.contract.Erge;
import com.example.myergedd.fragment.see.chosen.erge.presenter.IPresenter;

import java.util.List;

public class ErgeFragment extends BaseFragment<Erge.ErgeView,IPresenter<Erge.ErgeView>>implements Erge.ErgeView {

    private RecyclerView res;
    private ErgeAdapter ergeAdapter;

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_erge;
    }

    @Override
    protected void initView(View view) {
        res = view.findViewById(R.id.rlv);
        res.setLayoutManager(new LinearLayoutManager(getActivity()));
        ergeAdapter = new ErgeAdapter(getActivity());
        res.setAdapter(ergeAdapter);
    }

    @Override
    protected void initData() {
        mPresenter.setErgeData();
    }

    @Override
    protected IPresenter<Erge.ErgeView> initPresenter() {
        return new IPresenter<>();
    }

    @Override
    public void onSuccess(List<ErgeBean> ergeBeanList) {
        ergeAdapter.setAlbumsBeans(ergeBeanList);
    }

    @Override
    public void onFailed(String error) {

    }
}
