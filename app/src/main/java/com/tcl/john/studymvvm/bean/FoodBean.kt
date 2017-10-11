package com.tcl.john.studymvvm.bean

import android.databinding.ObservableField

/**
 * Food 实体类
 * Created by ZhangJun on 2017/6/24.
 */

class FoodBean {

    val description = ObservableField<String>()
    val image = ObservableField<String>()
    val keywords = ObservableField<String>()
    val summary = ObservableField<String>()

}
