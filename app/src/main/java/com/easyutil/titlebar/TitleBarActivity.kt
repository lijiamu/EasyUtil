package com.easyutil.titlebar

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.easyutil.R
import com.easyutil.toast.ToastUtil
import com.view.titlebar.OnTitleBarListener
import kotlinx.android.synthetic.main.activity_title_bar.*

class TitleBarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_title_bar)
        titleBar.setOnTitleBarListener(object : OnTitleBarListener {
            override fun onRightClick(v: View?) {
            }

            override fun onTitleClick(v: View?) {
            }

            override fun onLeftClick(v: View) {
                finish()
            }
        })
        mTitleBar.setOnTitleBarListener(object : OnTitleBarListener {

            override fun onLeftClick(v: View) {
                ToastUtil.show(this@TitleBarActivity,"左项 View 被点击")
            }

            override fun onTitleClick(v: View) {
                ToastUtil.show(this@TitleBarActivity,"中间 View 被点击")
            }

            override fun onRightClick(v: View) {
                ToastUtil.show(this@TitleBarActivity,"右项 View 被点击")
            }
        })
    }
}
