package com.tcl.john.studymvvm.viewmodel.food;

import android.content.Context;

import com.tcl.john.studymvvm.bean.FoodBean;
import com.tcl.john.studymvvm.bean.FoodListBean;
import com.tcl.john.studymvvm.event.FoodEvent;
import com.tcl.john.studymvvm.model.FoodModel;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;

/**
 * FoodList 的ViewModel
 * Created by ZhangJun on 2017/6/27.
 */

public class FoodListViewModel {

    public FoodListBean mFoodList;

    public FoodListViewModel(Context context) {
        mFoodList = new FoodListBean();
        initFoodList();
    }

    /**
     * 初始化数据
     */
    private void initFoodList() {
        FoodModel foodModel = FoodModel.getInstance();
        foodModel.requestFoodInfo();
    }

    /**
     * ViewModel从Model拿到数据后，通过EventBus的post方法发送消息，传递相应数据给View
     *
     * @param event
     */
    @Subscribe
    public void updateFoodList(FoodEvent.FoodModelEvent event) {
        List<FoodBean> foodList = event.foodList;
        if (foodList != null && !foodList.isEmpty()) {
            mFoodList.foodList.addAll(foodList);
            mFoodList.isShowing.set(true);
        } else {
            mFoodList.isShowing.set(false);
        }
        EventBus.getDefault().post(new FoodEvent.FoodViewModelEvent(mFoodList.foodList));
    }

    /**
     * ViewModel因为是个普通类，没有生命周期，所以我们要封装注册和反注册方法，在Activity的onStart()/onStop()里调用
     */
    public void registerEvent() {
        if (!EventBus.getDefault().isRegistered(FoodListViewModel.this)) {
            EventBus.getDefault().register(FoodListViewModel.this);
        }
    }

    public void unregisterEvent() {
        if (EventBus.getDefault().isRegistered(FoodListViewModel.this)) {
            EventBus.getDefault().unregister(FoodListViewModel.this);
        }
    }

}