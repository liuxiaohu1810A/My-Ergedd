package com.example.myergedd.fragment.hear.sinology;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.myergedd.DetailsActivity;
import com.example.myergedd.R;
import com.example.myergedd.adapter.SinologyAdapter;
import com.example.myergedd.base.BaseFragment;
import com.example.myergedd.base.SimpleFragment;
import com.example.myergedd.bean.SinologyBean;
import com.example.myergedd.fragment.hear.music.contract.Music;
import com.example.myergedd.fragment.hear.sinology.contract.Sinology;
import com.example.myergedd.fragment.hear.sinology.presenter.IPresenter;

import java.util.List;

public class SinologyFragment extends BaseFragment<Sinology.SinologyView,IPresenter<Sinology.SinologyView>>implements Sinology.SinologyView {

    private RecyclerView res;
    private SinologyAdapter sinologyAdapter;

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_english;
    }

    @Override
    protected void initView(View view) {
        res = view.findViewById(R.id.englishRes);
        res.setLayoutManager(new LinearLayoutManager(getActivity()));
        sinologyAdapter = new SinologyAdapter(getActivity());
        res.setAdapter(sinologyAdapter);

        sinologyAdapter.setOnclci(new SinologyAdapter.OnClick() {
            @Override
            public void onclcik(SinologyBean sinologyBean) {
                Intent intent = new Intent(getContext(), DetailsActivity.class);
                intent.putExtra("name",sinologyBean.getName());
                intent.putExtra("desc",sinologyBean.getDescription());
                intent.putExtra("count",sinologyBean.getCount());
                intent.putExtra("img",sinologyBean.getSquare_image_url());
                startActivity(intent);
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
