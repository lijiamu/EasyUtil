package com.easyutil.md5

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.easyutil.R
import kotlinx.android.synthetic.main.activity_md5.*

/**
 * MD5测试类
 */
class MD5Activity : AppCompatActivity(),View.OnClickListener{
    override fun onClick(v: View?) {
        when(v?.id){
            R.id.button -> {
                textView.text=StringBuilder("加密结果：").append(MD5Util.md5(editText2.text.toString()))
            }

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_md5)

    }
}
