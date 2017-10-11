package com.tcl.john.studymvvm.viewmodel.food

import android.content.Context

import com.tcl.john.studymvvm.bean.FoodBean
import com.tcl.john.studymvvm.bean.FoodListBean
import com.tcl.john.studymvvm.event.FoodEvent
import com.tcl.john.studymvvm.model.FoodModel

import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe

/**
 * FoodList 的ViewModel
 * Created by ZhangJun on 2017/6/27.
 */

class FoodListViewModel(context: Context) {

    var mFoodList: FoodListBean = FoodListBean()

    init {
        initFoodList()
    }

    /**
     * 初始化数据
     */
    private fun initFoodList() {
        val foodModel = FoodModel.getInstance()
        foodModel?.requestFoodInfo()
    }

    /**
     * ViewModel从Model拿到数据后，通过EventBus的post方法发送消息，传递相应数据给View

     * @param event
     */
    @Subscribe
    fun updateFoodList(event: FoodEvent.FoodModelEvent) {
        val foodList = event.foodList
        if (foodList != null && !foodList.isEmpty()) {
            mFoodList.foodList.addAll(foodList)
            mFoodList.isShowing.set(true)
        } else {
            mFoodList.isShowing.set(false)
        }
        EventBus.getDefault().post(FoodEvent.FoodViewModelEvent(mFoodList.foodList))
    }

    /**
     * ViewModel因为是个普通类，没有生命周期，所以我们要封装注册和反注册方法，在Activity的onStart()/onStop()里调用
     */
    fun registerEvent() {
        if (!EventBus.getDefault().isRegistered(this@FoodListViewModel)) {
            EventBus.getDefault().register(this@FoodListViewModel)
        }
    }

    fun unregisterEvent() {
        if (EventBus.getDefault().isRegistered(this@FoodListViewModel)) {
            EventBus.getDefault().unregister(this@FoodListViewModel)
        }
    }

}