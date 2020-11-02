package com.demo.date

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.easyutil.date.DateUtil
import com.easyutil.demo.R
import kotlinx.android.synthetic.main.activity_date.*
import java.util.*

class DateActivity : AppCompatActivity(),View.OnClickListener {
   var checkId:Int =0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_date)
        radioGroup.setOnCheckedChangeListener{ radioGroup, i ->
            checkId = i

        }
    }
    override fun onClick(view: View?) {
        when(view?.id){
            R.id.btnDate ->{
                when(checkId){
                    R.id.radioButtonLong ->{
                        txResult.text = StringBuilder("转换结果(Long)：").append(
                            DateUtil.getDateString(
                                System.currentTimeMillis(),
                                DateUtil.ALL
                            )
                        )
                    }
                    R.id.radioButtonDate ->{
                        txResult.text = StringBuilder("转换结果(Date)：").append(
                            DateUtil.getDateString(
                                Date(),
                                DateUtil.ALL
                            )
                        )
                    }
                    R.id.radioButtonString ->{
                        txResult.text = StringBuilder("转换结果(String)：").append(
                            DateUtil.getDateString(
                                editText.text.toString(),
                                DateUtil.ALL,
                                DateUtil.YEAR_MONTH_DAY
                            )
                        )
                    }
                }
            }
        }
    }
}
