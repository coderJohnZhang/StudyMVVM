package com.tcl.john.studymvvm.view.food

import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

import com.tcl.john.studymvvm.R
import com.tcl.john.studymvvm.databinding.ActivityFoodBinding
import com.tcl.john.studymvvm.event.FoodEvent
import com.tcl.john.studymvvm.viewmodel.food.FoodListViewModel
import com.tcl.john.studymvvm.widget.LoadingDialog

import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

/**
 * 食物列表界面，Activity或Fragment作为事件订阅者需要注册和取消注册事件
 * Created by ZhangJun on 2017/6/29.
 */

class FoodActivity : AppCompatActivity() {

    private var mFoodsRv: RecyclerView? = null
    private var mLoadingDialog: LoadingDialog? = null

    private var mFoodListViewModel: FoodListViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityFoodBinding = DataBindingUtil.setContentView<ActivityFoodBinding>(this, R.layout.activity_food)
        mLoadingDialog = LoadingDialog(this, R.style.LoadingDialog)
        initFoodList(activityFoodBinding)
    }

    override fun onStart() {
        super.onStart()
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this)
        }
        mFoodListViewModel!!.registerEvent()
    }

    override fun onStop() {
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this)
        }
        mFoodListViewModel!!.unregisterEvent()
        super.onStop()
    }

    override fun onDestroy() {
        mLoadingDialog!!.closeDialog()
        mLoadingDialog = null
        super.onDestroy()
    }

    private fun initFoodList(activityFoodBinding: ActivityFoodBinding) {
        mFoodListViewModel = FoodListViewModel(this)
        activityFoodBinding.model = mFoodListViewModel
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        mFoodsRv = activityFoodBinding.foodRv
        mFoodsRv!!.layoutManager = layoutManager
        mLoadingDialog!!.showDialog()
    }

    /**
     * 订阅者实现事件处理方法（也称为“订阅方法”），在事件发布时将被调用。 这些被定义为@Subscribe注解。

     * @param event
     */
    // Called in Android UI's main thread
    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onFoodListEvent(event: FoodEvent.FoodViewModelEvent) {
        mLoadingDialog!!.closeDialog()
        mFoodsRv!!.adapter = FoodDetailAdapter(event.foodList)
    }

    companion object {

        fun navigateTo(mContext: Context) {
            val intent = Intent(mContext, FoodActivity::class.java)
            mContext.startActivity(intent)
        }
    }

}