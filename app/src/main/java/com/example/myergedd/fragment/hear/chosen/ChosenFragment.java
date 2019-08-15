package com.example.myergedd.fragment.hear.chosen;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myergedd.R;
import com.example.myergedd.adapter.hear.ChosenAdapter;
import com.example.myergedd.base.BaseFragment;
import com.example.myergedd.bean.hear.ChosenBean;
import com.example.myergedd.bean.hear.ChosenBeanBan;
import com.example.myergedd.fragment.hear.HearFragment;
import com.example.myergedd.fragment.hear.chosen.contract.Chosen;
import com.example.myergedd.fragment.hear.chosen.presenter.IPresenter;
import com.example.myergedd.fragment.hear.english.EnglishFragment;
import com.example.myergedd.fragment.hear.erge.ErgeFragment;
import com.example.myergedd.fragment.hear.music.MusicFragment;
import com.example.myergedd.fragment.hear.sinology.SinologyFragment;
import com.example.myergedd.fragment.see.story.StoryFragment;
import com.example.myergedd.utils.FragmentUtils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.List;


public class ChosenFragment<V extends Chosen.ChosenView> extends BaseFragment<Chosen.ChosenView, IPresenter<Chosen.ChosenView>> implements Chosen.ChosenView {
    /*private CallbackAFragment mCallbackAFragment;

    public interface CallbackAFragment {
        void skipToBFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mCallbackAFragment = (CallbackAFragment) context;
    }*/

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
    private View view;
    private SmartRefreshLayout mSmart;
    private int page = 0;
    private BroadClass broadClass;
    private FragmentTransaction transaction;

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
        transaction = getChildFragmentManager().beginTransaction();
        mRlv = (RecyclerView) view.findViewById(R.id.rlv);

        //禁止滑动
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false) {
            @Override
            public boolean canScrollVertically() {
                return true;
            }
        };
        mRlv.setLayoutManager(linearLayoutManager);
        chosenAdapter = new ChosenAdapter(getActivity());
        mRlv.setAdapter(chosenAdapter);

        mSmart = (SmartRefreshLayout) view.findViewById(R.id.smart);

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
        Log.d(TAG, "onFailed: " + error);
    }

    @Override
    protected IPresenter<Chosen.ChosenView> initPresenter() {
        return new IPresenter<>();
    }

    class BroadClass extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            int english = intent.getIntExtra("ge", 0);
               /* Intent in = new Intent("erge");
                in.putExtra("EG",english);
                getActivity().sendBroadcast(in);*/
              if (english==0) FragmentUtils.addFragment(getChildFragmentManager(), ErgeFragment.class,R.id.hear_vp);
              else if (english==1)FragmentUtils.addFragment(getChildFragmentManager(), StoryFragment.class,R.id.hear_vp);
              else if (english==2)FragmentUtils.addFragment(getChildFragmentManager(), EnglishFragment.class,R.id.hear_vp);
              else if (english==3)FragmentUtils.addFragment(getChildFragmentManager(), SinologyFragment.class,R.id.hear_vp);
              else if (english==4)FragmentUtils.addFragment(getChildFragmentManager(), MusicFragment.class,R.id.hear_vp);
       /*     HearFragment hearFragment = new HearFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("EG",english);
            hearFragment.setArguments(bundle);*/
               /* Intent in = new Intent("gushi");
                in.putExtra("GS",english);
                getActivity().sendBroadcast(in);

                Intent in = new Intent("English");
                in.putExtra("EN",english);
                getActivity().sendBroadcast(in);

                Intent in = new Intent("guoxue");
                in.putExtra("GX",english);
                getActivity().sendBroadcast(in);

                Intent in = new Intent("music");
                in.putExtra("YY",english);
                getActivity().sendBroadcast(in);*/

            Toast.makeText(context, "发送广播", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        broadClass = new BroadClass();
        IntentFilter english = new IntentFilter("ge");
        getActivity().registerReceiver(broadClass, english);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        getActivity().unregisterReceiver(broadClass);
    }
}
