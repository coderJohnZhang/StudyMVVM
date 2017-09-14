package com.tcl.john.studymvvm.widget;

import android.app.Dialog;
import android.content.Context;

import com.tcl.john.studymvvm.R;

/**
 * 自定义等待加载对话框
 * Created by ZhangJun on 2017/7/6.
 */

public class LoadingDialog extends Dialog {

    public LoadingDialog(Context context, int theme) {
        super(context, theme);
        setContentView(R.layout.dialog_loading);
        setCanceledOnTouchOutside(false);
    }

    public void showDialog() {
        if (isShowing()) {
            return;
        }
        show();
    }

    public void closeDialog() {
        if (!isShowing()) {
            return;
        }
        dismiss();
    }

}
