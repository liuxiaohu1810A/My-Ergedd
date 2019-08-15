package com.example.myergedd.fragment.hear.english;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.myergedd.DetailsActivity;
import com.example.myergedd.R;

import com.example.myergedd.adapter.HearEnglishAdapter;
import com.example.myergedd.base.BaseFragment;
import com.example.myergedd.base.SimpleFragment;
import com.example.myergedd.fragment.hear.english.bean.HearEnglishBean;
import com.example.myergedd.fragment.hear.english.contract.HearEnglish;
import com.example.myergedd.fragment.hear.english.presenter.IPresenter;

import java.util.List;

import butterknife.OnClick;

public class EnglishFragment extends BaseFragment<HearEnglish.HearEnglishView, IPresenter<HearEnglish.HearEnglishView>> implements HearEnglish.HearEnglishView {

        private RecyclerView res;
        private HearEnglishAdapter hearEnglishAdapter;


        @Override
        protected int getLayoutID() {
            return R.layout.fragment_english;
        }

        @Override
        protected void initView(View view) {

            res = view.findViewById(R.id.englishRes);
            res.setLayoutManager(new LinearLayoutManager(getActivity()));
            hearEnglishAdapter = new HearEnglishAdapter(getActivity());
            res.setAdapter(hearEnglishAdapter);

            hearEnglishAdapter.setOnclcik(new HearEnglishAdapter.OnClick() {
                @Override
                public void onClick(HearEnglishBean hearEnglishBean) {
                    Intent intent = new Intent(getContext(), DetailsActivity.class);
                    intent.putExtra("name",hearEnglishBean.getName());
                    intent.putExtra("desc",hearEnglishBean.getDescription());
                    intent.putExtra("count",hearEnglishBean.getCount());
                    intent.putExtra("img",hearEnglishBean.getSquare_image_url());
                    startActivity(intent);
                }
            });
        }

        @Override
        protected void initData() {

            mPresenter.setHearEnglishData();
        }

        @Override
        protected IPresenter<HearEnglish.HearEnglishView> initPresenter() {
            return new IPresenter<>();
        }

        @Override

        public void onSuccess(List<HearEnglishBean> hearEnglishBeanList) {
            hearEnglishAdapter.setMusicBeans(hearEnglishBeanList);
        }

        @Override
        public void onFailed(String error) {

        }

}
