package com.example.myergedd.fragment.erge;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.myergedd.R;
import com.example.myergedd.adapter.MyAdapter;
import com.example.myergedd.base.BaseFragment;
import com.example.myergedd.base.SimpleFragment;
import com.example.myergedd.bean.SongBean;
import com.example.myergedd.contact.MyContact;
import com.example.myergedd.presenter.MyPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class ErgeFragment<V extends MyContact.MainView> extends BaseFragment<MyContact.MainView, MyPresenter<MyContact.MainView>> implements MyContact.MainView<List<SongBean>>{
    @BindView(R.id.rlv)
    RecyclerView rlv;
    private MyAdapter myAdapter;


    @Override
    protected int getLayoutID() {
        return R.layout.fragment_erge;
    }

    @Override
    protected void initData() {
        mPresenter.getDataP();
    }

    @Override
    protected void initView(View view) {
        super.initView(view);
        rlv.setLayoutManager(new LinearLayoutManager(getContext()));
        myAdapter = new MyAdapter(getContext());
        rlv.setAdapter(myAdapter);
    }

    @Override
    protected MyPresenter<MyContact.MainView> initPresenter() {
        return new MyPresenter<>();
    }

    @Override
    public void onSuccess(List<SongBean> songBean) {
        myAdapter.TextData(songBean);
    }


    private static final String TAG = "ErgeFragment";
    @Override
    public void onFail(String fail) {
        Log.d(TAG, "onFail: "+fail);
    }
}
