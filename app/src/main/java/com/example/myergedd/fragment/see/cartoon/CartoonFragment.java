package com.example.myergedd.fragment.see.cartoon;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myergedd.R;
import com.example.myergedd.activity.CommonSeeActivity;
import com.example.myergedd.adapter.CartoonAdapter;
import com.example.myergedd.base.BaseFragment;
import com.example.myergedd.bean.CartoonBean;
import com.example.myergedd.fragment.see.cartoon.contract.Cartoon;
import com.example.myergedd.fragment.see.cartoon.presenter.IPresenter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.List;

public class CartoonFragment extends BaseFragment<Cartoon.CartoonView, IPresenter<Cartoon.CartoonView>> implements Cartoon.CartoonView {

    private RecyclerView rec;
    private CartoonAdapter cartoonAdapter;
    private View view;
    public SmartRefreshLayout mSmart;
    private int page;

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_carton;
    }

    @Override
    protected void initView(View view) {
        rec = view.findViewById(R.id.cartoonRec);
        mSmart = (SmartRefreshLayout) view.findViewById(R.id.smart);
        rec.setLayoutManager(new LinearLayoutManager(getActivity()));
        cartoonAdapter = new CartoonAdapter(getActivity());
        rec.setAdapter(cartoonAdapter);


    }

    @Override
    protected void initData() {
        mPresenter.setCartoonData();
    }

    @Override
    protected void initListener() {
        cartoonAdapter.setOnClickListener(new CartoonAdapter.onClickListener() {
            @Override
            public void onClick(View v, int position) {
                Intent intent = new Intent(getActivity(), CommonSeeActivity.class);
                CartoonBean bean = cartoonAdapter.albumsBeans.get(position);
                intent.putExtra("id", bean.getId());
                intent.putExtra("title", bean.getName());
                startActivity(intent);
            }
        });
    }

    @Override
    protected IPresenter<Cartoon.CartoonView> initPresenter() {
        return new IPresenter<>();
    }

    @Override
    public void onSuccess(final List<CartoonBean> cartoonBeanList) {
        cartoonAdapter.setAlbumsBeans(cartoonBeanList);
        mSmart.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                mSmart.finishLoadMore();
            }

            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                cartoonBeanList.clear();
                mSmart.finishRefresh();
            }
        });
    }

    @Override
    public void onFailed(String error) {

    }
}
