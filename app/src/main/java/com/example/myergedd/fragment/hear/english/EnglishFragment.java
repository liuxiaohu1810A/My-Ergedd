package com.example.myergedd.fragment.hear.english;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.myergedd.R;

import com.example.myergedd.adapter.Listen_EnglishAdapter;
import com.example.myergedd.base.BaseFragment;
import com.example.myergedd.fragment.hear.english.contract.English;
import com.example.myergedd.fragment.hear.english.presenter.IPresenter;


import java.util.List;

public class EnglishFragment extends BaseFragment<English.Listen_EnglishView, IPresenter<English.Listen_EnglishView>> implements English.Listen_EnglishView {

    private Listen_EnglishAdapter Listen_Englishadapter;
    private static final String TAG = "EnglishFragment";
    private RecyclerView englishRes;

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_english;
    }

    @Override
    protected void initView(View view) {
        englishRes = view.findViewById(R.id.englishRes);


    }

    @Override
    protected void initData() {
        mPresenter.getListen_EnglishData();
    }

    @Override
    protected IPresenter<English.Listen_EnglishView> initPresenter() {
        return new IPresenter<>();
    }

    @Override
    public void OnSuccess(List<Listen_EnglishBean> listen_englishBeans) {

        Listen_Englishadapter.setList(listen_englishBeans);

        Log.i(TAG, "OnSuccess: "+listen_englishBeans.toString());
        Toast.makeText(getContext(), "1234567890", Toast.LENGTH_SHORT).show();



    }

    @Override
    public void OnFailed(String error) {
        Log.i(TAG, "OnFailed: "+error);
    }
}
