package com.tcl.john.studymvvm.widget

import android.app.Dialog
import android.content.Context

import com.tcl.john.studymvvm.R

/**
 * 自定义等待加载对话框
 * Created by ZhangJun on 2017/7/6.
 */

class LoadingDialog(context: Context, theme: Int) : Dialog(context, theme) {

    init {
        setContentView(R.layout.dialog_loading)
        setCanceledOnTouchOutside(false)
    }

    fun showDialog() {
        if (isShowing) {
            return
        }
        show()
    }

    fun closeDialog() {
        if (!isShowing) {
            return
        }
        dismiss()
    }

}
