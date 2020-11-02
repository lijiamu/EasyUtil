package com.demo.math

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.easyutil.demo.R
import com.easyutil.math.MathUtil
import com.easyutil.toast.ToastUtil
import kotlinx.android.synthetic.main.activity_math.*

class MathActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_math)
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.btnIsNumeric -> {
                txResult.text =StringBuilder("是否是数字：").append(MathUtil.isNumeric(edValue.text.toString()))
            }
            R.id.btnIsNumericInt -> {
                txResult.text = StringBuilder("是否是整数：").append(MathUtil.isNumericInt(edValue.text.toString()))
            }
            R.id.btnNumericRounding -> {
                if(MathUtil.isNumeric(edValue.text.toString()) && MathUtil.isNumeric(
                        edScale.text.toString()
                    )
                ){
                    txResult.text = StringBuilder("四舍五入结果：").append(
                        MathUtil.numericRounding(
                            edValue.text.toString(),
                            Integer.parseInt(edScale.text.toString())
                        )
                    )
                }else{
                    ToastUtil.show(this,"请输入正确的值。")
                }

            }

        }
    }
}
