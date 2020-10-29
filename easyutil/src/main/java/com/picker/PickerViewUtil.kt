package com.picker

import android.content.Context
import android.text.TextUtils
import android.widget.TextView
import android.widget.Toast
import com.bigkoo.pickerview.builder.OptionsPickerBuilder
import com.bigkoo.pickerview.builder.TimePickerBuilder
import com.bigkoo.pickerview.listener.OnOptionsSelectListener
import com.bigkoo.pickerview.listener.OnTimeSelectListener
import com.easyutil.date.DateUtil


/**
 *@author：李佳模
 *ON：2020/10/29
 *description:
 */
object PickerViewUtil {
    /**
     *年月日时分秒
     */
    val ALL ="yyyy-MM-dd HH:mm:ss"
    /**
     * 年月日时分
     */
    val YEAR_MONTH_DAY_HOUR_MIN ="yyyy-MM-dd HH:mm"
    /**
     *年月日
     */
    val YEAR_MONTH_DAY ="yyyy-MM-dd"
    /**
     * 时分
     */
    val HOURS_MINS ="HH:mm"
    /**
     * 月日时分
     */
    val MONTH_DAY_HOUR_MIN ="MM-dd HH:mm"

    /**
     * 时间选择器
     * @param dateFormat 时间格式
     * @param textView 需要记录结果的控件
     */
    fun pickerDateUtil(context: Context,dateFormat:String,textView: TextView?) {
        var type = booleanArrayOf(true, true, true, false, false, false)
        if (dateFormat === ALL) {
            type= booleanArrayOf(true, true, true, true, true, true)
        } else if (dateFormat === YEAR_MONTH_DAY) {
            type= booleanArrayOf(true, true, true, false, false, false)
        } else if (dateFormat === YEAR_MONTH_DAY_HOUR_MIN) {
            type= booleanArrayOf(true, true, true, true, true, false)
        } else if (dateFormat === HOURS_MINS) {
            type= booleanArrayOf(false, false, false, false, true, true)
        } else if (dateFormat === MONTH_DAY_HOUR_MIN) {
            type= booleanArrayOf(false, true, true, true, true, false)
        }
        var pvTime = TimePickerBuilder(context,
            OnTimeSelectListener { date, v ->
                val str = DateUtil.getDateString(date,dateFormat)
                textView?.text = str
                Toast.makeText(context, str, Toast.LENGTH_SHORT).show()
            })
            .setType(type)
            .build()
        pvTime.show()
    }

    /**
     * 普通 条件选择器
     * @param context Context
     * @param data List<String> 选择项
     * @param textView TextView? 需要记录结果的控件
     */
    fun pickerNoramlUtil(context: Context,data:List<String>,textView: TextView?) {
        val pvOptions = OptionsPickerBuilder(context, OnOptionsSelectListener { options1, option2, options3, v ->
            textView?.text = data[options1]
            Toast.makeText(context, data[options1], Toast.LENGTH_SHORT).show()
        }).build<String>()
        pvOptions.setPicker(data)
        val selectText = textView?.text
        if (!TextUtils.isEmpty(selectText)) {
            val selectPotions = data.indexOf(selectText)
            pvOptions.setSelectOptions(selectPotions)
        }
        pvOptions.show()
    }
}