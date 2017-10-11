package com.tcl.john.studymvvm.viewmodel

import android.content.Context
import android.databinding.BindingAdapter
import android.view.View
import android.widget.ImageView

import com.squareup.picasso.Picasso
import com.tcl.john.studymvvm.bean.UserBean
import com.tcl.john.studymvvm.model.UserModel
import com.tcl.john.studymvvm.view.food.FoodActivity

/**
 * User 的ViewModel
 * ViewModel里面的内容有：context（view）、field(bean)、model、childViewModel、Message(Command、Event)
 * Created by ZhangJun on 2017/6/27.
 */

class UserViewModel(private val mContext: Context) {

    var user: UserBean = UserBean()

    init {
        initUserInfo()
    }

    /**
     * 初始化数据
     */
    private fun initUserInfo() {
        val userModel = UserModel.getInstance()
        user = userModel?.userInfo!!
    }

    fun onFoodBtnClick() {
        FoodActivity.navigateTo(mContext)
    }

    fun onStudentBtnClick(v: View) {
        user.isStudent.set(!user.isStudent.get())
    }

    companion object {

        @JvmStatic
        @BindingAdapter("avatar")
        fun getInternetImage(iv: ImageView, avatar: String) {
            Picasso.with(iv.context).load(avatar).into(iv)
        }
    }

}