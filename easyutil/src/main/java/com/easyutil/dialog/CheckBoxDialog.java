package com.easyutil.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.StyleRes;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.easyutil.R;
import com.easyutil.density.DensityUtil;
import com.easyutil.toast.ToastUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by Andy on 2017/8/29.
 * 弹框 回调
 *
 * @author ljm
 */

public class CheckBoxDialog extends AlertDialog implements View.OnClickListener {
    private TextView txTitle;
    private LinearLayout linearContent;
    private Context context;
    private String titleText;
    private String leftText;
    private String rightText;
    private TextView outTextView;
    private List<String> listData;
    private List<CheckBox> checkBoxes = new ArrayList<>();
    private int dip10;
    private int sp13;
    public CheckBoxDialog(Context context, @StyleRes int themeResId,  List<String> listData, String titleText, String leftText, String rightText,TextView outTextView) {
        super(context, themeResId);
        this.context = context;
        this.titleText = titleText;
        this.leftText = leftText;
        this.rightText = rightText;
        this.outTextView = outTextView;
        this.listData = listData;
        dip10 = DensityUtil.dipToPixels(context,10);
        sp13 = DensityUtil.sp2px(context,6.5f);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getWindow()).clearFlags(WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);
        setContentView(R.layout.dialog_checkbox);
        txTitle =  findViewById(R.id.titleView);
        Button leftButton = findViewById(R.id.leftButton);
        Button rightButton = findViewById(R.id.rightButton);
        linearContent = findViewById(R.id.linearContent);
        leftButton.setOnClickListener(this);
        rightButton.setOnClickListener(this);
        if (!TextUtils.isEmpty(titleText)) {
            txTitle.setText(titleText);
        }
        txTitle.setSingleLine(false);
        leftButton.setText(leftText);
        rightButton.setText(rightText);
        setCheckDataList(listData);
    }

    @Override
    public void show() {
        super.show();

    }

    @Override
    public void onClick(View v) {
        int i1 = v.getId();
        if (i1 == R.id.leftButton) {
            dismiss();

        } else if (i1 == R.id.rightButton) {
            if (checkBoxes != null && checkBoxes.size() > 0) {
                List<String> checkList = new ArrayList<>();
                for (int i = 0; i < checkBoxes.size(); i++) {
                    CheckBox checkBox = checkBoxes.get(i);
                    if (checkBox.isChecked()) {
                        checkList.add(checkBox.getText().toString());
                    }
                }
                String result = checkList.toString().replace("[", "").replace("]", "");
                outTextView.setText(result);
            }
            dismiss();
        }
    }
    public void setTitle(String title) {
        this.titleText = title;
        if (!TextUtils.isEmpty(title)) {
            txTitle.setText(title);
        }
    }

    /**
     * 设置最终 输出值填写的TextView
     *
     * @param outTextView 输出textView
     */
    public void setOutTextView(TextView outTextView) {
        this.outTextView = outTextView;
    }

    private void setCheckDataList(List<String> checkDataList) {
        if(checkDataList==null||checkDataList.size()==0){
            ToastUtil.show(context,"选择列表不能为空");
            return;
        }
        this.listData = checkDataList;
        linearContent.removeAllViews();
        checkBoxes.clear();
        for (int i = 0;i<checkDataList.size();i++){
            CheckBox checkBox = new CheckBox(context);
            checkBox.setPadding(0,dip10,0,dip10);
            checkBox.setTextSize(sp13);
            checkBox.setTextColor(ContextCompat.getColor(context,R.color.contentColor));
            checkBox.setText(checkDataList.get(i));
            checkBoxes.add(checkBox);
            linearContent.addView(checkBox);
        }
    }
}
