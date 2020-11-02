package com.easyutil.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.StyleRes;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.easyutil.R;

/**
 *
 * @author Andy
 * @date 2017/8/29
 * 仿IOS对话框
 */

public class FIosDialog extends AlertDialog implements View.OnClickListener{

    private Button alertDialogLeftBtn;
    private Button alertDialogRightBtn;
    private TextView titleTv,contentTv;
    private String title;
    private String hint;
    private String leftBtnText;
    private String rightBtnText;
    private FiosDialogClick onClickListener;
    public static final int LeftButton = -1;
    public static final int RightButton = -2;
    private boolean isShowRight=true;
    public FIosDialog(Context context, @StyleRes int themeResId, String title, String hint, String leftBtnText, String rightBtnText, FiosDialogClick onClickListener) {
        super(context, themeResId);
        this.title = title;
        this.hint = hint;
        this.leftBtnText = leftBtnText;
        this.rightBtnText = rightBtnText;
        this.onClickListener =onClickListener;
    }
    public FIosDialog(Context context, @StyleRes int themeResId, String title, String hint, String leftBtnText, String rightBtnText, FiosDialogClick onClickListener, boolean isShowRight) {
        super(context, themeResId);
        this.title = title;
        this.hint = hint;
        this.leftBtnText = leftBtnText;
        this.rightBtnText = rightBtnText;
        this.onClickListener =onClickListener;
        this.isShowRight= isShowRight;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // getWindow().clearFlags(WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);//加焦点
        setContentView(R.layout.f_ios_dialog);
         titleTv = findViewById(R.id.alert_dialog_title_tv);
         contentTv = findViewById(R.id.alert_dialog_content_tv);
        alertDialogLeftBtn=  findViewById(R.id.alert_dialog_left_btn);
        alertDialogRightBtn= findViewById(R.id.alert_dialog_right_btn);
        titleTv.setText(title);
        contentTv.setText(hint);
        alertDialogLeftBtn.setText(leftBtnText);
        alertDialogRightBtn.setText(rightBtnText);
        alertDialogLeftBtn.setOnClickListener(this);
        alertDialogRightBtn.setOnClickListener(this);
        if(!isShowRight){
            alertDialogRightBtn.setVisibility(View.GONE);
        }
    }

    public interface  FiosDialogClick{
        /**
         *
         * @param which
         */
        void fIosDialogClick(int which);
    }
    public  void setText( String title, String hint,String leftBtnText,String rightBtnText){
        titleTv.setText(title);
        contentTv.setText(hint);
        alertDialogLeftBtn.setText(leftBtnText);
        alertDialogRightBtn.setText(rightBtnText);
    }
    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.alert_dialog_left_btn) {
            if (onClickListener != null) {
                onClickListener.fIosDialogClick(LeftButton);
            }
            dismiss();

        } else if (i == R.id.alert_dialog_right_btn) {
            if (onClickListener != null) {
                onClickListener.fIosDialogClick(RightButton);
            }
            dismiss();

        }
    }
}
