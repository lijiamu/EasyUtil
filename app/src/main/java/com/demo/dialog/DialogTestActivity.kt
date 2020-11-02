package com.demo.dialog

import android.os.Bundle
import android.view.View
import com.activity.BaseActivity
import com.easyutil.demo.R
import com.easyutil.dialog.CheckBoxDialog
import com.easyutil.dialog.FIosDialog
import com.easyutil.dialog.LoadingDialog
import com.easyutil.dialog.RadioDialog
import com.easyutil.toast.ToastUtil
import kotlinx.android.synthetic.main.activity_dialog_test.*
import java.lang.Boolean


class DialogTestActivity : BaseActivity(), View.OnClickListener {
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnIosDialog -> {
                FIosDialog(this@DialogTestActivity, R.style.dialog, "标题", "内容", "确定", "取消",
                    FIosDialog.FiosDialogClick { which ->
                        when (which) {
                            FIosDialog.LeftButton -> {
                                ToastUtil.show(this, "左边按钮")
                            }
                            FIosDialog.RightButton -> {
                                ToastUtil.show(this, "右边按钮")
                            }
                        }
                    }).show()
            }
            R.id.btnLoading -> {
                val loadingDialog = LoadingDialog(
                    this,
                    R.style.dialog,
                    Boolean.valueOf(false),
                    Boolean.valueOf(true)
                )
                loadingDialog.show()
            }
            R.id.btnRadio -> {
                val items = arrayListOf("单选1", "单选2", "单选3", "单选4","单选5", "单选6", "单选7", "单选8","单选9", "单选10", "单选11", "单选12")
                val radioDialog =
                    RadioDialog(this, R.style.dialog, items, "标题A", "取消", "确定", textResult)
                radioDialog.show()
//                val alertBuilder = AlertDialog.Builder(this)
//                alertBuilder.setTitle("这是单选框")
//                alertBuilder.setSingleChoiceItems(arrayOf("aa","bb"), 0,
//                    DialogInterface.OnClickListener { dialogInterface, i ->
//                        Toast.makeText(
//                            this@DialogTestActivity,
//                            items[i],
//                            Toast.LENGTH_SHORT
//                        ).show()
//                    })
//
//                alertBuilder.setPositiveButton("确定",
//                    DialogInterface.OnClickListener { dialogInterface, i -> ToastUtil.show("确定") })
//
//                alertBuilder.setNegativeButton("取消",
//                    DialogInterface.OnClickListener { dialogInterface, i ->  ToastUtil.show("取消")})
//                var alertDialog2 = alertBuilder.create()
//                alertDialog2.show()

            }
            R.id.btnCheckBox ->{
                val items = arrayListOf("单选1", "单选2", "单选3", "单选4","单选5", "单选6", "单选7", "单选8","单选9", "单选10", "单选11", "单选12")
               var checkBoxDialog =
                   CheckBoxDialog(this, R.style.dialog, items, "标题A", "取消", "确定", textResult)
                checkBoxDialog.show()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog_test)
        mTitleBar.setOnTitleBarListener(this)
    }
}
