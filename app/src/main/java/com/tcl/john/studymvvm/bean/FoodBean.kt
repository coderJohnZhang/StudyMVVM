package com.tcl.john.studymvvm.bean

import android.databinding.ObservableField
import java.io.Serializable

/**
 * Food 实体类
 * Created by ZhangJun on 2017/6/24.
 */


class FoodBean : Serializable {

    companion object {
        private const val serialVersionUID = -8596689964326048249L
    }

    val description = ObservableField<String>()
    val image = ObservableField<String>()

    val keywords = ObservableField<String>()
    val summary = ObservableField<String>()
}
