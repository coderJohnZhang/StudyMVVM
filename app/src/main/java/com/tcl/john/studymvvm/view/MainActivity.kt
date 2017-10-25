package com.tcl.john.studymvvm.view

import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.databinding.ObservableField
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log

import com.tcl.john.studymvvm.R
import com.tcl.john.studymvvm.bean.FoodBean
import com.tcl.john.studymvvm.databinding.ActivityMainBinding
import com.tcl.john.studymvvm.utils.CallJavaUtils
import com.tcl.john.studymvvm.viewmodel.UserViewModel

/**
 * View层中的Activity
 * View层负责View的绘制以及与用户交互
 * Created by ZhangJun on 2017/6/27.
 */

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityMainBinding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        initUserInfo(activityMainBinding)
    }

    private fun initUserInfo(activityMainBinding: ActivityMainBinding) {
        val userViewModel = UserViewModel(this)
        activityMainBinding.model = userViewModel
        activityMainBinding.foodButton.setOnClickListener { userViewModel.onFoodBtnClick() }
    }

    override fun onResume() {
        super.onResume()
        var foodBean = FoodBean()
        if (null != intent.getSerializableExtra(KEY_EXTRA_FOOD)) {
            foodBean = intent?.getSerializableExtra(KEY_EXTRA_FOOD) as FoodBean
        }
        //测试Kotlin传递可变长参数给Java可变参数方法
        var numbers:IntArray = intArrayOf(1, 2, 3, 4, 5)
        CallJavaUtils.addNumbers("add", *numbers)
        Log.d(TAG, "food = " + foodBean)

    }

    companion object {
        private val TAG = MainActivity.javaClass.simpleName
        private val KEY_EXTRA_FOOD = "extraFood"

        fun navigateTo(mContext: Context, foodBean: FoodBean) {
            val intent = Intent(mContext, MainActivity::class.java)
            intent.putExtra(KEY_EXTRA_FOOD, foodBean)
            mContext.startActivity(intent)
        }
    }

}