package com.tcl.john.studymvvm.viewmodel.widget;

import android.content.Context;
import android.util.Log;

import com.tcl.john.studymvvm.R;
import com.tcl.john.studymvvm.widget.LoadingDialog;

/**
 * 加载框的ViewModel
 * Created by ZhangJun on 2017/7/6.
 */

public class LoadingDialogViewModel {

    private static final String TAG = LoadingDialogViewModel.class.getSimpleName();

    public LoadingDialog mLoadingDialog;

    private Context mContext;

    public LoadingDialogViewModel(Context context) {
        mContext = context;
        initLoadingDiaLog();
    }

    private void initLoadingDiaLog() {
        Log.d(TAG, "create loadingDialog");
        mLoadingDialog = new LoadingDialog(mContext, R.style.LoadingDialog, this);
        mLoadingDialog.message.set("正在加载...");
    }

    public void showLoadingDiaLog() {
        Log.d(TAG, "show loadingDialog");
        mLoadingDialog.showDialog();
    }

    public void dismissLoadingDiaLog() {
        Log.d(TAG, "dismiss loadingDialog");
        mLoadingDialog.closeDialog();
        mLoadingDialog = null;
    }

}
