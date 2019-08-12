package com.example.myergedd.fragment.see.synthesize;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.myergedd.R;
import com.example.myergedd.adapter.SynthesizeAdapter;
import com.example.myergedd.base.BaseFragment;
import com.example.myergedd.bean.SynthesizeBean;
import com.example.myergedd.fragment.see.synthesize.contract.Synthesize;
import com.example.myergedd.fragment.see.synthesize.presenter.IPresenter;

import java.util.List;

public class SynthesizeFragment extends BaseFragment<Synthesize.SynthesizeView,IPresenter<Synthesize.SynthesizeView>>implements Synthesize.SynthesizeView {

    private RecyclerView res;
    private SynthesizeAdapter synthesizeAdapter;

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_synthesize;
    }

    @Override
    protected IPresenter<Synthesize.SynthesizeView> initPresenter() {
        return new IPresenter<>();
    }

    @Override
    protected void initView(View view) {
        res = view.findViewById(R.id.synthesizeRes);
        res.setLayoutManager(new LinearLayoutManager(getActivity()));
        synthesizeAdapter = new SynthesizeAdapter(getActivity());
        res.setAdapter(synthesizeAdapter);
    }

    @Override
    protected void initData() {
        mPresenter.setSynthesizeData();
    }

    @Override
    public void onSuccess(List<SynthesizeBean> synthesizeBeanList) {
        synthesizeAdapter.setSynthesizeBeans(synthesizeBeanList);
    }

    @Override
    public void onFailed(String error) {

    }
}
