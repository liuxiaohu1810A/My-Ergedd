package com.example.myergedd.fragment.see.chosen;


import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.myergedd.R;
import com.example.myergedd.base.BaseFragment;
import com.example.myergedd.bean.see.ChosenThree;
import com.example.myergedd.bean.see.ChosenTwoBean;
import com.example.myergedd.utils.ToastUtils;

import java.util.List;

public class ChosenFragment extends BaseFragment<Chosen.ChosenView, ChosenPresenter<Chosen.ChosenView>> implements Chosen.ChosenView {

    private RecyclerView mRlv;
    private ChosenAdapter mAdapter;

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_chosen;
    }

    @Override
    protected void initView(View view) {
        mRlv = view.findViewById(R.id.chosen_rlv);
        mRlv.setLayoutManager(new LinearLayoutManager(getActivity()));
        mAdapter = new ChosenAdapter(getActivity());
        mRlv.setAdapter(mAdapter);
    }

    @Override
    protected void initData() {
        mPresenter.setDataTwo();
        mPresenter.setDataThree();
    }

    @Override
    protected ChosenPresenter<Chosen.ChosenView> initPresenter() {
        return new ChosenPresenter<>();
    }

    @Override
    public void onSuccessTwo(List<ChosenTwoBean> twoBeans) {
        if (twoBeans.size() > 0) {
            mAdapter.setDataTwo(twoBeans);
        }
    }

    @Override
    public void onSuccessThree(List<ChosenThree> threes) {
        if (threes.size() > 0) {
            mAdapter.setDataThree(threes);
        }
    }

    @Override
    public void onFailed(String error) {
        if (error != null) {
            ToastUtils.ShowToast(error);
        }
    }
}
