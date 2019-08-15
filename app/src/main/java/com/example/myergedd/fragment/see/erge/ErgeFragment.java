package com.example.myergedd.fragment.see.erge;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.myergedd.R;

import com.example.myergedd.adapter.see.ErgeAdapter;
import com.example.myergedd.base.BaseFragment;
import com.example.myergedd.bean.see.ErgeBean;


import com.example.myergedd.activity.CommonSeeActivity;

import com.example.myergedd.fragment.see.erge.contract.Erge;
import com.example.myergedd.fragment.see.erge.presenter.IPresenter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;


import java.util.List;

public class ErgeFragment extends BaseFragment<Erge.ErgeView, IPresenter<Erge.ErgeView>>implements Erge.ErgeView {

    private RecyclerView res;
    private ErgeAdapter ergeAdapter;
    private SmartRefreshLayout mSmart;
    private String str;

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
        mSmart = (SmartRefreshLayout) view.findViewById(R.id.smart);
    }

    @Override
    protected void initData() {
        mPresenter.setErgeData(str);
    }

    @Override
    protected void initListener() {
        ergeAdapter.setOnClickListener(new ErgeAdapter.onClickListener() {
            @Override
            public void onClick(View v, int position) {
                Intent intent = new Intent(getActivity(), CommonSeeActivity.class);
                ErgeBean bean = ergeAdapter.albumsBeans.get(position);
                intent.putExtra("id", bean.getId());
                intent.putExtra("title", bean.getName());
                startActivity(intent);
            }
        });
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
