package com.example.myergedd.fragment.see.english;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.myergedd.R;
import com.example.myergedd.activity.CommonSeeActivity;
import com.example.myergedd.adapter.EnglishAdapter;
import com.example.myergedd.base.BaseFragment;
import com.example.myergedd.bean.CartoonBean;
import com.example.myergedd.bean.EnglishBean;
import com.example.myergedd.fragment.see.english.contract.English;
import com.example.myergedd.fragment.see.english.presenter.IPresenter;

import java.util.List;

public class EnglishFragment extends BaseFragment<English.EnglishView,IPresenter<English.EnglishView>>implements English.EnglishView {

    private RecyclerView res;
    private EnglishAdapter englishAdapter;

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
        res.setLayoutManager(new LinearLayoutManager(getActivity()));
        englishAdapter = new EnglishAdapter(getActivity());
        res.setAdapter(englishAdapter);
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