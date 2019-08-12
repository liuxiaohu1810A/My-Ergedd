package com.example.myergedd.fragment.erge;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myergedd.R;
import com.example.myergedd.adapter.ErgeAdapter;
import com.example.myergedd.base.BaseFragment;
import com.example.myergedd.bean.ErgeBean;
import com.example.myergedd.fragment.erge.contact.MyContact;
import com.example.myergedd.fragment.erge.presenter.MyPresenter;

import java.util.List;

public class ErgeFragment extends BaseFragment<MyContact.MainView, MyPresenter<MyContact.MainView>> implements MyContact.MainView {
    private ErgeAdapter myAdapter;
    private RecyclerView mRlv;

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_erge;
    }

    @Override
    protected void initData() {
        super.initData();
        mPresenter.getDataP();
    }

    @Override
    protected void initView(View view) {
        super.initView(view);
        mRlv = (RecyclerView) view.findViewById(R.id.rlv);
        mRlv.setLayoutManager(new LinearLayoutManager(getActivity()));
        myAdapter = new ErgeAdapter(getActivity());
        mRlv.setAdapter(myAdapter);
    }

    @Override
    protected MyPresenter<MyContact.MainView> initPresenter() {
        return new MyPresenter<>();
    }

    @Override
    public void onSuccess(List<ErgeBean> songBean) {
        myAdapter.setAlbumsBeans(songBean);
    }


    private static final String TAG = "ErgeFragment";

    @Override
    public void onFail(String fail) {
        Log.d(TAG, "onFail: " + fail);
    }


}
