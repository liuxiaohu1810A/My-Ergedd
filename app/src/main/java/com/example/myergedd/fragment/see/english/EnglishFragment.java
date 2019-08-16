package com.example.myergedd.fragment.see.english;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.myergedd.R;
import com.example.myergedd.activity.CommonSeeActivity;
import com.example.myergedd.adapter.EnglishAdapter;
import com.example.myergedd.base.BaseFragment;
import com.example.myergedd.bean.EnglishBean;
import com.example.myergedd.bean.CartoonBean;
import com.example.myergedd.bean.EnglishBean;
import com.example.myergedd.fragment.see.english.contract.English;
import com.example.myergedd.fragment.see.english.presenter.IPresenter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.List;

public class EnglishFragment extends BaseFragment<English.EnglishView,IPresenter<English.EnglishView>>implements English.EnglishView {

    private RecyclerView res;
    private EnglishAdapter englishAdapter;
    public SmartRefreshLayout mSmart;
    private int page;

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_english;
    }

    @Override
    protected IPresenter<English.EnglishView> initPresenter() {
        return new IPresenter<>();
    }

    @Override
    protected void initView(View view) {
        res = view.findViewById(R.id.englishRes);
        mSmart = (SmartRefreshLayout) view.findViewById(R.id.smart);
        res.setLayoutManager(new LinearLayoutManager(getActivity()));
        englishAdapter = new EnglishAdapter(getActivity());
        res.setAdapter(englishAdapter);
        mSmart.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                mSmart.finishLoadMore();
            }

            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                mSmart.finishRefresh();
            }
        });
    }

    @Override
    protected void initData() {
        mPresenter.setEnglishData();
    }

    @Override
    protected void initListener() {
        englishAdapter.setOnClickListener(new EnglishAdapter.onClickListener() {
            @Override
            public void onClick(View v, int position) {
                Intent intent = new Intent(getActivity(), CommonSeeActivity.class);
                EnglishBean bean = englishAdapter.englishBeans.get(position);
                intent.putExtra("id", bean.getId());
                intent.putExtra("title", bean.getName());
                startActivity(intent);
            }
        });
    }

    @Override
    public void onSuccess(List<EnglishBean> englishBeanList) {
        englishAdapter.setEnglishBeans(englishBeanList);
    }

    @Override
    public void onFailed(String error) {

    }
}
