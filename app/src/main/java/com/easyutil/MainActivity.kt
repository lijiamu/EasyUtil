package com.easyutil

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.easyutil.toast.ToastUtil

class MainActivity : AppCompatActivity(),View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    override fun onClick(view: View?) {
        when(view?.id){
            R.id.btnToast ->{
                ToastUtil.show(this,"吐司测试")
            }
        }
    }
}
