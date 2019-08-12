package com.example.myergedd.fragment.hear.english;

<<<<<<< HEAD
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.myergedd.R;
import com.example.myergedd.adapter.HearEnglishAdapter;
import com.example.myergedd.base.BaseFragment;
import com.example.myergedd.base.SimpleFragment;
import com.example.myergedd.fragment.hear.english.bean.HearEnglishBean;
import com.example.myergedd.fragment.hear.english.contract.HearEnglish;
import com.example.myergedd.fragment.hear.english.presenter.IPresenter;

import java.util.List;

public class EnglishFragment extends BaseFragment<HearEnglish.HearEnglishView,IPresenter<HearEnglish.HearEnglishView>>implements HearEnglish.HearEnglishView {

    private RecyclerView res;
    private HearEnglishAdapter hearEnglishAdapter;

=======
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

>>>>>>> origin/zhangyadan
    @Override
    protected int getLayoutID() {
        return R.layout.fragment_english;
    }

    @Override
    protected void initView(View view) {
<<<<<<< HEAD
        res = view.findViewById(R.id.englishRes);
        res.setLayoutManager(new LinearLayoutManager(getActivity()));
        hearEnglishAdapter = new HearEnglishAdapter(getActivity());
        res.setAdapter(hearEnglishAdapter);
=======
        englishRes = view.findViewById(R.id.englishRes);


>>>>>>> origin/zhangyadan
    }

    @Override
    protected void initData() {
<<<<<<< HEAD
        mPresenter.setHearEnglishData();
    }

    @Override
    protected IPresenter<HearEnglish.HearEnglishView> initPresenter() {
=======
        mPresenter.getListen_EnglishData();
    }

    @Override
    protected IPresenter<English.Listen_EnglishView> initPresenter() {
>>>>>>> origin/zhangyadan
        return new IPresenter<>();
    }

    @Override
<<<<<<< HEAD
    public void onSuccess(List<HearEnglishBean> hearEnglishBeanList) {
        hearEnglishAdapter.setMusicBeans(hearEnglishBeanList);
    }

    @Override
    public void onFailed(String error) {

=======
    public void OnSuccess(List<Listen_EnglishBean> listen_englishBeans) {

        Listen_Englishadapter.setList(listen_englishBeans);

        Log.i(TAG, "OnSuccess: "+listen_englishBeans.toString());
        Toast.makeText(getContext(), "1234567890", Toast.LENGTH_SHORT).show();



    }

    @Override
    public void OnFailed(String error) {
        Log.i(TAG, "OnFailed: "+error);
>>>>>>> origin/zhangyadan
    }
}
