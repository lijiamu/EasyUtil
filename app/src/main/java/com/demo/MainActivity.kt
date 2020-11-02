package com.demo

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.activity.BaseActivity
import com.demo.date.DateActivity
import com.demo.dialog.DialogTestActivity
import com.demo.math.MathActivity
import com.demo.md5.MD5Activity
import com.demo.picker.PickerViewActivity
import com.demo.titlebar.TitleBarActivity
import com.easyutil.demo.R
import com.easyutil.toast.ToastUtil

class MainActivity : BaseActivity(),View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setIsNeedExit(true)
    }
    override fun onClick(view: View?) {
        var intent: Intent? = null
        when(view?.id){
            R.id.btnToast ->{
                ToastUtil.show(this,"吐司测试")
            }
            R.id.btnMath ->{
                intent = Intent(this, MathActivity::class.java)
            }
            R.id.btnDate ->{
                intent = Intent(this, DateActivity::class.java)
            }
            R.id.btnMD5 ->{
                intent = Intent(this, MD5Activity::class.java)
            }
            R.id.btnDialog ->{
                intent = Intent(this, DialogTestActivity::class.java)
//                intent = Intent(this,TestActivity::class.java)
            }
            R.id.btnTitleBar ->{
                intent = Intent(this, TitleBarActivity::class.java)
            }
            R.id.btnPicker ->{
                intent = Intent(this, PickerViewActivity::class.java)
            }
        }
        if(intent!=null){
            startActivity(intent)
        }
    }
}
