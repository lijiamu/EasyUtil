package com.easyutil.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.easyutil.R;


public class LoadingDialog extends AlertDialog {
    public TextView text_progress;
    public ProgressBar MyProgressBar;
    private Boolean isShowProgress = false;
    private String hint;
    /**
     * true 点击消失  false  点击不消失
     */
    private Boolean touchHide = true;

    public LoadingDialog(Context context, int theme) {
        super(context, theme);
        // TODO Auto-generated constructor stub
    }

    public LoadingDialog(Boolean touchHide, Context context, int theme) {
        super(context, theme);
        // TODO Auto-generated constructor stub
        this.touchHide = touchHide;
    }

    public LoadingDialog(Context context, int theme, Boolean isShowProgress) {
        super(context, theme);
        // TODO Auto-generated constructor
        this.isShowProgress = isShowProgress;
    }

    public LoadingDialog(Context context, int theme, String hint) {
        super(context, theme);
        // TODO Auto-generated constructor
        this.hint = hint;
    }

    public LoadingDialog(Context context, int theme, Boolean isShowProgress, Boolean touchHide) {
        super(context, theme);
        // TODO Auto-generated constructor
        this.isShowProgress = isShowProgress;
        this.touchHide = touchHide;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loading_dialog);
        LinearLayout myloadWait = findViewById(R.id.myload_wait);
        myloadWait.getBackground().setAlpha(197);
        text_progress = findViewById(R.id.text_progress);
        MyProgressBar = findViewById(R.id.MyProgressBar);
        if (isShowProgress) {
            text_progress.setVisibility(View.VISIBLE);
            MyProgressBar.setVisibility(View.VISIBLE);
        } else {
            MyProgressBar.setVisibility(View.VISIBLE);
            text_progress.setVisibility(View.GONE);
            if (!TextUtils.isEmpty(hint)) {
                text_progress.setText(hint);
            }
        }
        setCancelable(touchHide);
    }

    public void setProgress(int progress) {
        text_progress.setText(new StringBuffer(progress).append("%"));
    }

    public void setProgress(String progress) {
        text_progress.setText(progress);
    }
}
