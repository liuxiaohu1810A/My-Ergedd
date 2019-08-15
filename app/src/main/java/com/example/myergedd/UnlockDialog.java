package com.example.myergedd;

import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.example.myergedd.utils.TrackUtil;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by maochen on 14-8-4.
 */

//public class UnlockDialog extends Dialog {

  /*  private View.OnClickListener mOkListener = null;
    private OnDismissListener mOnDismissListener;

    private String pv = "setting.lock";*/
/*

    @Bind(R.id.tip_container)
    View tip;

    @Bind(R.id.tip_text)
    TextView tipText;

    @Bind(R.id.unlock_question)
    TextView question;

    @Bind(R.id.unlock_input)
    TextView input;

    @Bind({R.id.btn_0, R.id.btn_1, R.id.btn_2, R.id.btn_3, R.id.btn_4, R.id.btn_5, R.id.btn_6, R.id.btn_7, R.id.btn_8, R.id.btn_9,})
    TextView[] btns;

    @Bind({R.id.btn_bg_0, R.id.btn_bg_1, R.id.btn_bg_2, R.id.btn_bg_3, R.id.btn_bg_4, R.id.btn_bg_5, R.id.btn_bg_6, R.id.btn_bg_7, R.id.btn_bg_8, R.id.btn_bg_9,})
    RelativeLayout[] btn_bgs;

    @Bind(R.id.root)
    View root;

    @Bind(R.id.title)
    TextView title;

    private int first = -1;
    private int second = -1;
    private Context context;

    public UnlockDialog(Context context, String titleString, String tipString, View.OnClickListener okListener) {
        super(context, R.style.ZZDialogDimEnabled);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.setCanceledOnTouchOutside(true);
        this.setContentView(R.layout.view_unlock_dialog);
        mOkListener = okListener;
        TrackUtil.trackEvent(pv, "view");
        ButterKnife.bind(this);
        this.context = context;

        if (TextUtils.isEmpty(tipString)) {
            tip.setVisibility(View.GONE);
        } else {
            tipText.setText(tipString);
        }
        title.setText(titleString);
        createQuestion();
        bindEvent();
    }

    public UnlockDialog(Context context, String titleString, String tipString, View.OnClickListener okListener, OnDismissListener onDismissListener) {
        super(context, R.style.ZZDialogDimEnabled);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.setCanceledOnTouchOutside(true);
        this.setContentView(R.layout.view_unlock_dialog);
        mOkListener = okListener;
        mOnDismissListener = onDismissListener;
        TrackUtil.trackEvent(pv, "view");
        ButterKnife.bind(this);

        if (TextUtils.isEmpty(tipString)) {
            tip.setVisibility(View.GONE);
        } else {
            tipText.setText(tipString);
        }
        title.setText(titleString);
        createQuestion();
        bindEvent();
    }

    private void createQuestion() {
        int left = 0;
        int right = 0;

        while (left * right < 10) {
            left = (int) (Math.random() * 10);
            right = (int) (Math.random() * 10);
        }

        if (left > right) {
            int temp = left;
            left = right;
            right = temp;
        }

        int result = left * right;
        first = result / 10;
        second = result % 10;
        question.setText(left + " x " + right + " = ");
    }

    private void bindEvent() {
        for (RelativeLayout view : btn_bgs) {
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Utility.disableFor1Second(v);
                    TextView tv = (TextView) ((RelativeLayout) v).getChildAt(0);
                    int number = Integer.parseInt(tv.getText().toString());

                    if (TextUtils.isEmpty(input.getText())) {
                        if (number == first) {
                            input.setText(String.valueOf(number));
                        } else {
                            TrackUtil.trackEvent(pv, "unlock.fail");
                            reset();
                        }
                    } else {
                        if (number == second) {
                            input.setText(input.getText() + String.valueOf(second));
                            new Handler().postDelayed(() -> {
                                if (mOkListener != null) {
                                    mOkListener.onClick(v);
                                    TrackUtil.trackEvent(pv, "unlock.success");
                                }
                                dismiss();
                            }, 100);
                        } else {
                            TrackUtil.trackEvent(pv, "unlock.fail");
                            reset();
                        }
                    }
                }
            });
        }


    }

    private void reset() {
        input.setText("");
        shake();
        first = -1;
        second = -1;
        createQuestion();
    }

    @Override
    public void show() {
        super.show();
    }


    @Override
    public void dismiss() {
        if (isShowing()) {
            super.dismiss();
            if (mOnDismissListener != null) {
                mOnDismissListener.onDismiss(this);
            }
        }
    }

    public void shake() {
        ObjectAnimator.ofFloat(root, "translationX", 0, 25, -25, 25, -25, 15, -15, 6, -6, 0).start();
    }

    @OnClick(R.id.root)
    public void rootClick() {
        dismiss();
    }

    @OnClick(R.id.container)
    public void containerClick() {

    }

    @OnClick(R.id.close)
    public void closeClick() {
        TrackUtil.trackEvent(pv, "close.click");
        dismiss();
    }
*/

//}
