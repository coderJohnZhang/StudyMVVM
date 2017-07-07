package com.tcl.john.studymvvm.widget;

import android.app.Dialog;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableField;
import android.view.LayoutInflater;

import com.tcl.john.studymvvm.R;
import com.tcl.john.studymvvm.databinding.DialogLoadingBinding;
import com.tcl.john.studymvvm.viewmodel.widget.LoadingDialogViewModel;

/**
 * 自定义等待加载对话框
 * Created by ZhangJun on 2017/7/6.
 */

public class LoadingDialog extends Dialog {

    public final ObservableField<String> message = new ObservableField<>();

    private Context mContext;

    public LoadingDialog(Context context, int theme, LoadingDialogViewModel viewModel) {
        super(context, theme);
        mContext = context;

        DialogLoadingBinding dialogLoadingBinding = DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout.dialog_loading, null, false);
        dialogLoadingBinding.setModel(viewModel);

        setContentView(dialogLoadingBinding.getRoot());
        setCanceledOnTouchOutside(false);
    }

    public void showDialog(){
        if(isShowing())return;
        show();
    }

    public void closeDialog(){
        if(!isShowing())return;
        dismiss();
    }

}
