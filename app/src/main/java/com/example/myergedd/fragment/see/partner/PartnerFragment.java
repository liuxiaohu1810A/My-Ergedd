package com.example.myergedd.fragment.see.partner;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.myergedd.R;
import com.example.myergedd.adapter.PartherAdapter;
import com.example.myergedd.base.SimpleFragment;
import com.example.myergedd.bean.PartnerBean;
import com.example.myergedd.utils.ToastUtils;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class PartnerFragment extends SimpleFragment {
    private View view;
    private RecyclerView mRlv;
    private PartherAdapter mAdapter;

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_partner;
    }

    @Override
    protected void initView(View view) {
        mRlv = (RecyclerView) view.findViewById(R.id.partner_rlv);
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 3);
        mRlv.setLayoutManager(layoutManager);
        mAdapter = new PartherAdapter(getActivity());
        mRlv.setAdapter(mAdapter);
    }

    @Override
    protected void initData() {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url("http://192.168.1.125:8080/json/partner.json")
                .build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("parther", "onFailure: " + e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String data = response.body().string();
                Log.e("parther", "run: " + data);
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        String borrowName = null;
                        try {/*"ISO-8859-1"*/
                            borrowName = new String(data.getBytes(), "GB2312");
                            PartnerBean bean = new Gson().fromJson(borrowName, PartnerBean.class);
                            mAdapter.setDataParther(bean);
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
    }
}
