package com.easyutil.date

import android.text.TextUtils
import java.text.SimpleDateFormat
import java.util.*
import java.util.regex.Pattern

/**
 *@author：李佳模
 *ON：2020/9/29
 *description:日期类工具
 */
object DateUtil {
    var YEAR_MONTH_DAY = "yyyy-MM-dd"
    var YEAR_MONTH_DAY_HHMMSS = "yyyy-MM-dd HH:mm:ss"
    var YEAR_MONTH_DAY_HHMM = "yyyy-MM-dd HH:mm"
    var HHMMSS = "HH:mm:ss"
    var HHMM = "HH:mm"
    /**
     * 根据传入的格式化类型来转换时间格式
     * @param time 时间
     * @param pattern 转化格式
     */
    fun getDateString(time: Long?,pattern:String?): String {
        val s = SimpleDateFormat(pattern,Locale.getDefault())
        val d5 = Date(time!!)
        return s.format(d5)
    }
    /**
     * 根据传入的格式化类型来转换时间格式
     * @param time 时间
     * @param pattern 转化格式
     */
    fun getDateString(time: Date?,pattern:String?): String {
        val s = SimpleDateFormat(pattern,Locale.getDefault())
        return s.format(time)
    }

    /**
     * 日期格式转换 如传入yyyy-MM-dd HH:mm:ss 输出 yyyy-MM-dd HH:mm
     * @param time 时间
     * @param inPattern 传入时间类型
     * @param outPattern 输出时间类型
     */
    fun getDateString(time: String?,inPattern:String?,outPattern:String?): String? {
        if (!isDate(time)) {
            return time
        } else {
            val inS = SimpleDateFormat(inPattern,Locale.US)
            var date = inS.parse(time)
            val outS = SimpleDateFormat(outPattern,Locale.US)
            return outS.format(date)
        }
    }

    /**
     * 获取当前时间
     * @param pattern 需要返回的时间格式
     */
    fun getNowDateString(pattern:String?): String {
        var time = System.currentTimeMillis()
        return getDateString(time,pattern)
    }
    /**
     * 判断日期格式是否正确
     * @param time
     * @return
     */
    fun isDate(time: String?): Boolean {
        var time = time
        if (TextUtils.isEmpty(time)) {
            return false
        }
        time = time?.trim { it <= ' ' }
        //yyyyMMddHHmmss
        val a1 = "[0-9]{4}[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}"
        //yyyyMMdd
        val a2 = "[0-9]{4}[0-9]{2}[0-9]{2}"
        //yyyy-MM-dd HH:mm:ss
        val a3 = "[0-9]{4}-[0-9]{2}-[0-9]{2} [0-9]{2}:[0-9]{2}:[0-9]{2}"
        //yyyy-MM-dd
        val a4 = "[0-9]{4}-[0-9]{2}-[0-9]{2}"
        //yyyy-MM-dd  HH:mm
        val a5 = "[0-9]{4}-[0-9]{2}-[0-9]{2} [0-9]{2}:[0-9]{2}"
        val datea1 = Pattern.compile(a1).matcher(time).matches()
        if (datea1) {
            return true
        }
        val datea2 = Pattern.compile(a2).matcher(time).matches()
        if (datea2) {
            return true
        }
        val datea3 = Pattern.compile(a3).matcher(time).matches()
        if (datea3) {
            return true
        }
        val datea4 = Pattern.compile(a4).matcher(time).matches()
        if (datea4) {
            return true
        }
        val datea5 = Pattern.compile(a5).matcher(time).matches()
        return datea5
    }
}