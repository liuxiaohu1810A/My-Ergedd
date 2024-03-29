package com.example.myergedd.fragment.hear.sinology;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.myergedd.R;
import com.example.myergedd.activity.DetailsActivity;
import com.example.myergedd.adapter.SinologyAdapter;
import com.example.myergedd.base.BaseFragment;
import com.example.myergedd.base.SimpleFragment;
import com.example.myergedd.bean.SinologyBean;
import com.example.myergedd.fragment.hear.english.bean.HearEnglishBean;
import com.example.myergedd.fragment.hear.music.contract.Music;
import com.example.myergedd.fragment.hear.sinology.contract.Sinology;
import com.example.myergedd.fragment.hear.sinology.presenter.IPresenter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.List;

public class SinologyFragment extends BaseFragment<Sinology.SinologyView,IPresenter<Sinology.SinologyView>>implements Sinology.SinologyView {

    private RecyclerView res;
    private SinologyAdapter sinologyAdapter;
    private SmartRefreshLayout mSmart;
    private int page=0;

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_english;
    }

    @Override
    protected void initListener() {
        sinologyAdapter.setOnClickListener(new SinologyAdapter.onClickListener() {
            @Override
            public void onClick(View v, int position) {
                Intent intent = new Intent(getActivity(), DetailsActivity.class);
                SinologyBean sinologyBean = sinologyAdapter.sinologyBeans.get(position);
                intent.putExtra("id", sinologyBean.getId());
                intent.putExtra("name", sinologyBean.getName());
                intent.putExtra("count",sinologyBean.getCount());
                intent.putExtra("url",sinologyBean.getSquare_image_url());
                intent.putExtra("description",sinologyBean.getDescription());
                startActivity(intent);
            }
        });
    }

    @Override
    protected void initView(View view) {
        res = view.findViewById(R.id.englishRes);
        mSmart = (SmartRefreshLayout) view.findViewById(R.id.smart);
        res.setLayoutManager(new LinearLayoutManager(getActivity()));
        sinologyAdapter = new SinologyAdapter(getActivity());
        res.setAdapter(sinologyAdapter);
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
    protected IPresenter<Sinology.SinologyView> initPresenter() {
        return new IPresenter<>();
    }

    @Override
    protected void initData() {
        mPresenter.setSinologyData();
    }

    @Override
    public void onSuccess(List<SinologyBean> sinologyBeanList) {
        sinologyAdapter.setSinologyBeans(sinologyBeanList);
    }

    @Override
    public void onFailed(String error) {

    }
}
