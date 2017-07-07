package com.tcl.john.studymvvm.viewmodel.food;

import android.content.Context;

import com.tcl.john.studymvvm.bean.FoodBean;
import com.tcl.john.studymvvm.bean.FoodListBean;
import com.tcl.john.studymvvm.event.FoodEvent;
import com.tcl.john.studymvvm.model.FoodModel;
import com.tcl.john.studymvvm.viewmodel.widget.LoadingDialogViewModel;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

/**
 * FoodList 的ViewModel
 * Created by ZhangJun on 2017/6/27.
 */

public class FoodListViewModel implements FoodModel.OnUpdateFoodInfoCallBack {

    public FoodListBean mFoodList;

    private LoadingDialogViewModel mLoadingDialogViewModel;

    private Context mContext;

    public FoodListViewModel(Context context) {
        mContext = context;
        mFoodList = new FoodListBean();
        initFoodList();
    }

    /**
     * 初始化数据
     */
    private void initFoodList() {
        FoodModel foodModel = FoodModel.getInstance();
        foodModel.setOnUpdateFoodInfoCallBack(this);
        foodModel.requestFoodInfo();

        mLoadingDialogViewModel = new LoadingDialogViewModel(mContext);
        mLoadingDialogViewModel.showLoadingDiaLog();
    }

    /**
     * ViewModel从Model拿到数据后，通过EventBus的post方法发送消息，传递相应数据给View
     * @param foodList
     */
    @Override
    public void updateFoodList(List<FoodBean> foodList) {
        mLoadingDialogViewModel.dismissLoadingDiaLog();
        if (foodList != null && foodList.size() > 0) {
            mFoodList.foodList.addAll(foodList);
            mFoodList.isShowing.set(true);
        } else {
            mFoodList.isShowing.set(false);
        }
        EventBus.getDefault().post(new FoodEvent.FoodListEvent(mFoodList.foodList));
    }

}