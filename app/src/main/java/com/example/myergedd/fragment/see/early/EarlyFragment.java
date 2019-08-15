package com.example.myergedd.fragment.see.early;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.myergedd.R;
import com.example.myergedd.activity.CommonSeeActivity;
import com.example.myergedd.adapter.EarlyAdapter;
import com.example.myergedd.base.BaseFragment;
import com.example.myergedd.bean.EarlyBean;
import com.example.myergedd.fragment.see.early.contract.Early;
import com.example.myergedd.fragment.see.early.presenter.IPresenter;

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
    protected void initListener() {
        earlyAdapter.setOnClickListener(new EarlyAdapter.onClickListener() {
            @Override
            public void onClick(View v, int position) {
                Intent intent = new Intent(getActivity(), CommonSeeActivity.class);
                EarlyBean bean = earlyAdapter.earlyBeans.get(position);
                intent.putExtra("id", bean.getId());
                intent.putExtra("title", bean.getName());
                startActivity(intent);
            }
        });
    }

    @Override
    public void onSuccess(List<EarlyBean> earlyBeanList) {
        earlyAdapter.setEarlyBeans(earlyBeanList);
    }

    @Override
    public void onFailed(String error) {

    }
}
