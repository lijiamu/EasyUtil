package com.easyutil.picker

import android.os.Bundle
import android.view.View
import com.activity.BaseActivity
import com.easyutil.R
import com.picker.PickerViewUtil
import kotlinx.android.synthetic.main.activity_picker_view.*

class PickerViewActivity : BaseActivity(), View.OnClickListener {
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnPickerViewDate -> {
                var dateFormat = PickerViewUtil.ALL
                when {
                    radio1.isChecked -> dateFormat = PickerViewUtil.ALL
                    radio2.isChecked -> dateFormat = PickerViewUtil.YEAR_MONTH_DAY_HOUR_MIN
                    radio3.isChecked -> dateFormat = PickerViewUtil.YEAR_MONTH_DAY
                    radio4.isChecked -> dateFormat = PickerViewUtil.HOURS_MINS
                    radio5.isChecked -> dateFormat = PickerViewUtil.MONTH_DAY_HOUR_MIN
                }
                PickerViewUtil.pickerDateUtil(this@PickerViewActivity,dateFormat,txResult)
            }
            R.id.btnPickerViewNormal ->{
                PickerViewUtil.pickerNoramlUtil(this@PickerViewActivity, listOf("A","B","C","D"),txResult)
            }
            R.id.btnPickerViewNorma2 ->{
                PickerViewUtil.pickerCityUtil(this@PickerViewActivity, txResult)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_picker_view)
        mTitleBar.setOnTitleBarListener(this)
    }
}
