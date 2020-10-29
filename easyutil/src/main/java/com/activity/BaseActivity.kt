package com.activity

import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.support.v7.app.AppCompatActivity
import android.view.KeyEvent
import android.view.View
import com.application.BaseApplication
import com.easyutil.toast.ToastUtil
import com.view.titlebar.OnTitleBarListener

open class BaseActivity : AppCompatActivity(), OnTitleBarListener {
    var isExit = false
    var isNeedExit = false
    private var exitHandler: ExitHandler? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        BaseApplication.allActivitys.add(this)
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        if (keyCode == 4 && this.isNeedExit) {
            this.exit()
            return false
        } else {
            return super.onKeyDown(keyCode, event)
        }
    }

    fun exit() {
        if (!this.isExit) {
            this.isExit = true
            ToastUtil.show(this,"再按一次退出程序")
            this.exitHandler?.sendEmptyMessageDelayed(0, 2000L)
        } else {
            this.exitAPP()
        }

    }

    fun setIsNeedExit(isNeedExit: Boolean) {
        this.isNeedExit = isNeedExit
        if (this.exitHandler == null) {
            this.exitHandler = ExitHandler()
        }

    }

    fun exitAPP() {
        for (i in 0 until BaseApplication.allActivitys.size) {
            BaseApplication.allActivitys[i].finish()
        }
    }

    internal inner class ExitHandler : Handler() {

        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
            when (msg.what) {
                0 -> this@BaseActivity.isExit = false
            }
        }
    }
    /**
     * titleBar 左中右监听事件
     */
    override fun onLeftClick(v: View?) {
        finish()
    }

    override fun onTitleClick(v: View?) {
    }

    override fun onRightClick(v: View?) {
    }
}
