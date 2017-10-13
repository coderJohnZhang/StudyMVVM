package com.tcl.john.studymvvm.viewmodel.food

import android.databinding.BindingAdapter
import android.databinding.ObservableField
import android.view.View
import android.widget.ImageView
import android.widget.Toast

import com.squareup.picasso.Picasso
import com.tcl.john.studymvvm.bean.FoodBean
import com.tcl.john.studymvvm.view.MainActivity

/**
 * Food 的ViewModel
 * 一个ViewModel接口提供了两个东西：动作和数据。
 * 动作改变Model的下层（click listener，监听文字改变的listener等等），而数据则是Model的内容。
 * Created by ZhangJun on 2017/6/27.
 */

class FoodItemViewModel(var food: FoodBean) {

    fun onItemClick(view: View) {
        //Toast.makeText(view.getContext(), food.description.get(), Toast.LENGTH_SHORT).show();
        //测试传递序列化对象
        MainActivity.navigateTo(view.context, food)
    }

    companion object {

        @BindingAdapter("image")
        fun getInternetImage(iv: ImageView, image: String) {
            Picasso.with(iv.context).load(image).into(iv)
        }
    }
}