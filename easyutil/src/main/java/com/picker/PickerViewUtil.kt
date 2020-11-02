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
    const val ALL ="yyyy-MM-dd HH:mm:ss"
    /**
     * 年月日时分
     */
    const val YEAR_MONTH_DAY_HOUR_MIN ="yyyy-MM-dd HH:mm"
    /**
     *年月日
     */
    const val YEAR_MONTH_DAY ="yyyy-MM-dd"
    /**
     * 时分
     */
    const val HOURS_MINS ="HH:mm"
    /**
     * 月日时分
     */
    const val MONTH_DAY_HOUR_MIN ="MM-dd HH:mm"

    /**
     * 时间选择器
     * @param dateFormat 时间格式
     * @param textView 需要记录结果的控件
     */
    fun pickerDateUtil(context: Context,dateFormat:String,textView: TextView?) {
        var type = booleanArrayOf(true, true, true, false, false, false)
        when {
            dateFormat === ALL -> type= booleanArrayOf(true, true, true, true, true, true)
            dateFormat === YEAR_MONTH_DAY -> type= booleanArrayOf(true, true, true, false, false, false)
            dateFormat === YEAR_MONTH_DAY_HOUR_MIN -> type= booleanArrayOf(true, true, true, true, true, false)
            dateFormat === HOURS_MINS -> type= booleanArrayOf(false, false, false, false, true, true)
            dateFormat === MONTH_DAY_HOUR_MIN -> type= booleanArrayOf(false, true, true, true, true, false)
        }
        var pvTime = TimePickerBuilder(context,
            OnTimeSelectListener { date, _ ->
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
         var pvOptions = OptionsPickerBuilder(context, OnOptionsSelectListener { options1, option2, options3, v ->
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
    /**
     * 选择城市 -- 省市区
     * @param context Context
     * @param textView TextView
     */
    fun pickerCityUtil(context: Context, textView: TextView) {
        if (CityData.provinceList.size == 0 || CityData.cityList.size == 0 || CityData.areaList.size == 0) {
            CityData.initCity(context)
        }
        var pvOptions = OptionsPickerBuilder(context, OnOptionsSelectListener { options1, option2, options3, v ->
            var address = CityData.provinceList[options1] + "-" + CityData.cityList[options1][option2] + "-" + CityData.areaList[options1][option2][options3]
            textView.text = address
        }).build<String>()
        pvOptions.setPicker(CityData.provinceList, CityData.cityList, CityData.areaList)
        val selectText = textView.text.toString()
        if (!TextUtils.isEmpty(selectText)) {
            var options1 = 0
            var options2 = 0
            var options3 = 0
            val selectTextList = selectText.split("-".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
            if (selectTextList != null) {
                if (selectTextList.isNotEmpty()) {
                    options1 = CityData.provinceList.indexOf(selectTextList[0])
                    if (options1 >= 0 && selectTextList.size > 1) {
                        options2 = CityData.cityList[options1].indexOf(selectTextList[1])
                        if (options2 >= 0 && selectTextList.size > 2) {
                            options3 = CityData.areaList[options1][options2].indexOf(selectTextList[2])
                        }
                    }
                }
            }
            options1 = if (options1 >= 0) options1 else 0
            options2 = if (options2 >= 0) options2 else 0
            options3 = if (options3 >= 0) options3 else 0
            pvOptions.setSelectOptions(options1, options2, options3)
        }
        pvOptions.show()
    }
}