package com.example.myergedd.fragment.see.cartoon;

import android.content.Intent;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.myergedd.R;
import com.example.myergedd.activity.CommonSeeActivity;
import com.example.myergedd.adapter.CartoonAdapter;
import com.example.myergedd.base.BaseFragment;
import com.example.myergedd.bean.CartoonBean;
import com.example.myergedd.fragment.see.cartoon.contract.Cartoon;
import com.example.myergedd.fragment.see.cartoon.presenter.IPresenter;

import java.util.List;

public class CartoonFragment extends BaseFragment<Cartoon.CartoonView, IPresenter<Cartoon.CartoonView>> implements Cartoon.CartoonView {

    private RecyclerView rec;
    private CartoonAdapter cartoonAdapter;

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_carton;
    }

    @Override
    protected void initView(View view) {
        rec = view.findViewById(R.id.cartoonRec);
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
    public void onSuccess(List<CartoonBean> cartoonBeanList) {
        cartoonAdapter.setAlbumsBeans(cartoonBeanList);
    }

    @Override
    public void onFailed(String error) {

    }
}
