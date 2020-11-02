package com.easyutil.dialog

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.TextView
import com.easyutil.R
import com.easyutil.toast.ToastUtil
import kotlinx.android.synthetic.main.dialog_radio.*
import kotlinx.android.synthetic.main.item_dialog_radio.view.*

/**
 *@author：李佳模
 *ON：2020/11/2
 *description:单选列表 对话框
 */
class RadioDialog(context: Context?, themeResId: Int, var listData: ArrayList<String>, private var titleText: String, private var leftText: String, private var rightText: String
,var outTextView:TextView?) : AlertDialog(context, themeResId),View.OnClickListener {
    var radioIndex = -1
    var beforRadio:RadioButton? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_radio)
        initView()
    }
    private fun initView() {
        var tempResult = outTextView?.text
        radioIndex = listData.indexOf(tempResult)
        titleView?.text = titleText
        leftButton?.text = leftText
        rightButton?.text = rightText
        leftButton.setOnClickListener(this)
        rightButton.setOnClickListener(this)
        recyclerView?.layoutManager = LinearLayoutManager(context)
        recyclerView?.adapter = RadioAdapter()
    }
    override fun onClick(v: View?) {
        when(v?.id){
            R.id.leftButton ->{ dismiss()}
            R.id.rightButton ->{
                if(radioIndex==-1){
                    ToastUtil.show("您未进行选择")
                }else{
                    outTextView?.text = listData[radioIndex]
                    dismiss()}
            }
        }
    }
    inner class RadioAdapter: RecyclerView.Adapter<RadioViewHolder>() {
        override fun onCreateViewHolder(p0: ViewGroup, p1: Int): RadioViewHolder {
            return  RadioViewHolder(LayoutInflater.from(context).inflate(R.layout.item_dialog_radio,p0,false))
        }

        override fun getItemCount(): Int {
           return listData.size
        }

        override fun onBindViewHolder(viewHoldr: RadioViewHolder, position: Int) {
            viewHoldr.view.radio.text = listData[position]
            if( radioIndex == position){
                beforRadio = viewHoldr.view.radio
                viewHoldr.view.radio.isChecked = true
            }
            viewHoldr.view.linearLayout.setOnClickListener {
                radioIndex = position
                beforRadio?.isChecked = false
                viewHoldr.view.radio.isChecked = true
                beforRadio = viewHoldr.view.radio
            }
        }

    }
    inner class RadioViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var view = view
    }
}