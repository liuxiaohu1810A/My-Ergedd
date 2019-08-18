package com.example.myergedd.utils;

import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.example.myergedd.R;
import com.google.android.exoplayer2.C;


import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by maochen on 14-8-4.
 */

public class UnlockDialog extends Dialog {

    private View.OnClickListener mOkListener = null;
    private OnDismissListener mOnDismissListener;

    private String pv = "setting.lock";



    private int first = -1;
    private int second = -1;
    private Context context;
    private View tip;
    private TextView tipText;
    private TextView title;
    private RelativeLayout root;
    private TextView input;
    private TextView question;
    private ImageView close;
    private TextView btn_0;
    private TextView btn_1;
    private TextView btn_2;
    private TextView btn_3;
    private TextView btn_4;
    private TextView btn_5;
    private TextView btn_6;
    private TextView btn_7;
    private TextView btn_8;
    private TextView btn_9;
    private RelativeLayout btn_bg_0;
    private RelativeLayout btn_bg_1;
    private RelativeLayout btn_bg_2;
    private RelativeLayout btn_bg_3;
    private RelativeLayout btn_bg_4;
    private RelativeLayout btn_bg_5;
    private RelativeLayout btn_bg_6;
    private RelativeLayout btn_bg_7;
    private RelativeLayout btn_bg_8;
    private RelativeLayout btn_bg_9;

    public UnlockDialog(Context context, String titleString, String tipString, View.OnClickListener okListener) {
        super(context, R.style.ZZDialogDimEnabled);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.setCanceledOnTouchOutside(true);
        this.setContentView(R.layout.view_unlock_dialog);
        initView();
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

    private void initView() {
        tip = findViewById(R.id.tip_container);
        tipText = findViewById(R.id.tip_text);
        question = findViewById(R.id.unlock_question);
        title = findViewById(R.id.title);
        input = findViewById(R.id.unlock_input);
        root = findViewById(R.id.root);
        root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });


        close = findViewById(R.id.close);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TrackUtil.trackEvent(pv, "close.click");
                dismiss();
            }
        });
        btn_0 = findViewById(R.id.btn_0);
        btn_1 = findViewById(R.id.btn_1);
        btn_2 = findViewById(R.id.btn_2);
        btn_3 = findViewById(R.id.btn_3);
        btn_4 = findViewById(R.id.btn_4);
        btn_5 = findViewById(R.id.btn_5);
        btn_6 = findViewById(R.id.btn_6);
        btn_7 = findViewById(R.id.btn_7);
        btn_8 = findViewById(R.id.btn_8);
        btn_9 = findViewById(R.id.btn_9);
        btn_bg_0 = findViewById(R.id.btn_bg_0);
        btn_bg_1 = findViewById(R.id.btn_bg_1);
        btn_bg_2 = findViewById(R.id.btn_bg_2);
        btn_bg_3 = findViewById(R.id.btn_bg_3);
        btn_bg_4 = findViewById(R.id.btn_bg_4);
        btn_bg_5 = findViewById(R.id.btn_bg_5);
        btn_bg_6 = findViewById(R.id.btn_bg_6);
        btn_bg_7 = findViewById(R.id.btn_bg_7);
        btn_bg_8 = findViewById(R.id.btn_bg_8);
        btn_bg_9 = findViewById(R.id.btn_bg_9);
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
         TextView[] btn={btn_0,btn_1,btn_2,btn_3,btn_4,btn_5,btn_6,btn_7,btn_8,btn_9};
         RelativeLayout[] btn_bgs={btn_bg_0,btn_bg_1,btn_bg_2,btn_bg_3,btn_bg_4,btn_bg_5,btn_bg_6,btn_bg_7,btn_bg_8,btn_bg_9};

        for (RelativeLayout view : btn_bgs) {
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    disableFor1Second(v);
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

                private void disableFor1Second(View v) {
                    disable(v, 1000);
                }
                private void disable(final View v, long duration) {
                    if (v == null) {
                        return;
                    }

                    try {
                        v.setEnabled(false);
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                v.setEnabled(true);
                            }
                        }, duration);
                    } catch (Exception e) {
                        e.printStackTrace();
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




}
