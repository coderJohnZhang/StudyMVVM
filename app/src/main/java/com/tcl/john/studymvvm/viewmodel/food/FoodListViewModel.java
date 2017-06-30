package com.tcl.john.studymvvm.viewmodel.food;

import com.tcl.john.studymvvm.bean.FoodBean;
import com.tcl.john.studymvvm.model.FoodModel;

import java.util.List;

/**
 * FoodList 的ViewModel
 * Created by ZhangJun on 2017/6/27.
 */

public class FoodListViewModel implements FoodModel.OnUpdateFoodInfoCallBack {

    private OnShowFoodListCallBack mOnShowFoodListCallBack;

    public FoodListViewModel() {
        initFoodList();
    }

    /**
     * 初始化数据
     */
    private void initFoodList() {
        FoodModel foodModel = FoodModel.getInstance();
        foodModel.setOnUpdateFoodInfoCallBack(this);
        foodModel.requestFoodInfo();
    }

    @Override
    public void updateFoodList(List<FoodBean> foodList) {
        if (mOnShowFoodListCallBack != null) {
            mOnShowFoodListCallBack.showFoodList(foodList);
        }
    }

    public interface OnShowFoodListCallBack {
        void showFoodList(List<FoodBean> foodList);
    }

    public void setOnShowFoodListCallBack (OnShowFoodListCallBack onShowFoodListCallBack) {
        mOnShowFoodListCallBack = onShowFoodListCallBack;
    }
}