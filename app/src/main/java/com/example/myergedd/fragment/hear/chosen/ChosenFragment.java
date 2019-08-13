package com.example.myergedd.fragment.hear.chosen;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myergedd.R;
import com.example.myergedd.adapter.hear.ChosenAdapter;
import com.example.myergedd.adapter.hear.ChosenBeanAdapter;
import com.example.myergedd.base.BaseFragment;
import com.example.myergedd.base.SimpleFragment;
import com.example.myergedd.bean.hear.ChosenBean;
import com.example.myergedd.bean.hear.ChosenBeanBan;
import com.example.myergedd.bean.see.ChosenThree;
import com.example.myergedd.bean.see.ChosenTwoBean;
import com.example.myergedd.fragment.hear.chosen.contract.Chosen;
import com.example.myergedd.fragment.hear.chosen.presenter.IPresenter;


import java.util.List;


public class ChosenFragment<V extends Chosen.ChosenView> extends BaseFragment<Chosen.ChosenView,IPresenter<Chosen.ChosenView>> implements Chosen.ChosenView{


    /**
     * 精 选 专 辑
     */
    private TextView mJx;
    /**
     * 宝宝最爱·热门儿歌·精彩故事
     */
    private RecyclerView mRec;
    private RecyclerView mRlv;
    private ChosenAdapter chosenAdapter;

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_chosen_hear;
    }

    @Override
    protected void initData() {
        super.initData();
        mPresenter.setChosenData();
        mPresenter.setChosenDataB();
    }

    public void initView(View view) {
        mRlv = (RecyclerView) view.findViewById(R.id.rlv);

        //禁止滑动
     /*   LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false){
            @Override
            public boolean canScrollVertically() {
                return true;
            }
        };*/
        mRlv.setLayoutManager(new LinearLayoutManager(getActivity()));
        chosenAdapter = new ChosenAdapter(getActivity());
        mRlv.setAdapter(chosenAdapter);

    }


    @Override
    public void onSuccess(List<ChosenBeanBan> cartoonBeanList) {

    }

    @Override
    public void onSuccessB(List<ChosenBean> cartoonBeanList) {
        chosenAdapter.setChosen(cartoonBeanList);
    }

    private static final String TAG = "ChosenFragment";
    @Override
    public void onFailed(String error) {
        Log.d(TAG, "onFailed: "+error);
    }

    @Override
    protected IPresenter<Chosen.ChosenView> initPresenter() {
        return new IPresenter<>();
    }
}
