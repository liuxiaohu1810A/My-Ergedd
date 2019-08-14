package com.example.myergedd.fragment.hear.erge;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.myergedd.R;
import com.example.myergedd.activity.DetailsActivity;
import com.example.myergedd.adapter.Listen_ErgeAdapter;
import com.example.myergedd.base.BaseFragment;
import com.example.myergedd.fragment.hear.erge.bean.Listen_ErgeBean;
import com.example.myergedd.fragment.hear.erge.contract.Erge;
import com.example.myergedd.fragment.hear.erge.presenter.IPresenter;

import java.util.ArrayList;
import java.util.List;

public class ErgeFragment extends BaseFragment<Erge.ErgeView, IPresenter<Erge.ErgeView>> implements Erge.ErgeView {


    private ArrayList<Listen_ErgeBean> list;
    private Listen_ErgeAdapter adapter;
    private static final String TAG = "ErgeFragment";
    private RecyclerView englishRes;

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_english;
    }

    @Override
    protected void initView(View view) {
        englishRes = view.findViewById(R.id.englishRes);

        englishRes.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new Listen_ErgeAdapter(getContext());
        englishRes.setAdapter(adapter);

    }

    @Override
    protected void initListener() {
        adapter.setOnClickListener(new Listen_ErgeAdapter.onClickListener() {
            @Override
            public void onClick(View v, int position) {
                Intent intent = new Intent(getActivity(), DetailsActivity.class);
                Listen_ErgeBean bean = adapter.ergeBeans.get(position);
                intent.putExtra("id", bean.getId());
                intent.putExtra("name", bean.getName());
                intent.putExtra("count",bean.getCount());
                intent.putExtra("url",bean.getSquare_image_url());
                intent.putExtra("description",bean.getDescription());
                startActivity(intent);
            }
        });
    }

    @Override
    protected void initData() {
        mPresenter.getListenErgeData();
    }

    @Override
    protected IPresenter<Erge.ErgeView> initPresenter() {
        return new IPresenter<>();
    }

    @Override
    public void OnSuccess(List<Listen_ErgeBean> listen_ergeBeans) {
        adapter.setList(listen_ergeBeans);
    }

    @Override
    public void OnFailed(String error) {
        Log.i(TAG, "OnFailed: " + error);
    }
}
