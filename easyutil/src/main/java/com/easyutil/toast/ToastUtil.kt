package com.easyutil.toast

import android.content.Context
import android.widget.Toast

/**
 *@author：李佳模
 *ON：2020/9/28
 *description:吐司 Toast 工具类
 */
object ToastUtil {
    private var toast: Toast? = null
    @JvmStatic
    fun show(context: Context, msg: String) {
        if (toast == null) {
            toast = Toast.makeText(context, msg, Toast.LENGTH_SHORT)
        } else {
            toast!!.setText(msg)
        }
        toast!!.show()
    }
}