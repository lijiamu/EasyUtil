package com.easyutil.dialog

import android.os.Bundle
import android.view.View
import com.activity.BaseActivity
import com.easyutil.R
import com.easyutil.toast.ToastUtil
import kotlinx.android.synthetic.main.activity_dialog_test.*

class DialogTestActivity : BaseActivity(), View.OnClickListener {
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnIosDialog -> {
                MyFIosDialog(this@DialogTestActivity, R.style.dialog, "标题", "内容", "确定", "取消",
                    MyFIosDialog.FIosDialogClick { which ->
                        when (which) {
                            MyFIosDialog.LeftButton -> {
                                ToastUtil.show(this, "左边按钮")
                            }
                            MyFIosDialog.RightButton -> {
                                ToastUtil.show(this, "右边按钮")
                            }
                        }
                    }).show()
            }
            R.id.btnLoading -> {
                val loadingDialog = LoadingDialog(
                    this,
                    R.style.dialog,
                    java.lang.Boolean.valueOf(false),
                    java.lang.Boolean.valueOf(true)
                )
                loadingDialog.show()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog_test)
        mTitleBar.setOnTitleBarListener(this)
    }
}
