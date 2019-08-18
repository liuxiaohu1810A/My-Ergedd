package com.example.myergedd.fragment;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.myergedd.Preferences;
import com.example.myergedd.R;
import com.example.myergedd.activity.SettingActivity;
import com.example.myergedd.base.SimpleFragment;
import com.example.myergedd.utils.Constants;
import com.example.myergedd.utils.RestUtil;
import com.example.myergedd.utils.UnlockDialog;


public class CacheFragment extends SimpleFragment {
    private View view;
    private ImageView mSetting;
    /**
     * 清理缓存
     */
    private TextView mCacheClean;
    private RelativeLayout mTopBar;
    private ViewPager mCacheVp;
    /**
     * 关注微信好礼
     */
    private TextView mCacheGift;
    private static final int MODE_NONE=0;
    public static final int MODE_REST = 1;
    public static final int MODE_SLEEP = 2;


    private int sMode = MODE_NONE;

    public static void start(Context context, int mode) {
        if (context != null) {
            Intent it = new Intent();
            it.putExtra("mode",mode);
            context.startActivity(it);
        }
    }
    @Override
    protected int getLayoutID() {
        return R.layout.fragment_cache;
    }

    public void initView(View view) {
        mSetting = (ImageView) view.findViewById(R.id.setting);
        mCacheClean = (TextView) view.findViewById(R.id.cache_clean);
        mTopBar = (RelativeLayout) view.findViewById(R.id.top_bar);
        mCacheVp = (ViewPager) view.findViewById(R.id.cache_vp);
        mCacheGift = (TextView) view.findViewById(R.id.cache_gift);

        mSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UnlockDialog dialog = new UnlockDialog(getActivity(), "请确认您是家长", null, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                       // finishActivity();
                        Intent intent = new Intent(getActivity(), SettingActivity.class);
                        startActivity(intent);
                    }
                });
                dialog.show();

            }
        });

    }
   /* private void finishActivity() {

        Preferences.getPreferences(getActivity()).setPlayControlStrategy(Constants.PLAY_STRATEGY_TIME);
        long timeCount = Preferences.getPreferences(getActivity()).getVideoControlTime();
        Preferences.getPreferences(getActivity()).setVideoControlResetTime(System.currentTimeMillis());
        Preferences.getPreferences(getActivity()).setVideoControlRemainTime(timeCount);

        if (sMode == MODE_SLEEP)
            Utility.resetLastSleepCheckTime(getActivity());

        if (sMode == MODE_REST) {
            RestUtil.getInstance().reset();
        }
        getActivity().finish();
    }
*/
}
