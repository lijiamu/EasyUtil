package com.easyutil

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.activity.BaseActivity
import com.easyutil.date.DateActivity
import com.easyutil.dialog.DialogTestActivity
import com.easyutil.math.MathActivity
import com.easyutil.md5.MD5Activity
import com.easyutil.picker.PickerViewActivity
import com.easyutil.titlebar.TitleBarActivity
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
                intent = Intent(this,MathActivity::class.java)
            }
            R.id.btnDate ->{
                intent = Intent(this,DateActivity::class.java)
            }
            R.id.btnMD5 ->{
                intent = Intent(this,MD5Activity::class.java)
            }
            R.id.btnDialog ->{
                intent = Intent(this,DialogTestActivity::class.java)
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
