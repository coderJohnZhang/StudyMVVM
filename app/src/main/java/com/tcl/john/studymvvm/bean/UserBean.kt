package com.tcl.john.studymvvm.bean

import android.databinding.ObservableBoolean
import android.databinding.ObservableField
import android.databinding.ObservableInt

/**
 * User 实体类
 * Created by ZhangJun on 2017/6/24.
 */

class UserBean {

    val userName = ObservableField<String>()
    val nickName = ObservableField<String>()
    val age = ObservableInt()
    val isStudent = ObservableBoolean()
    val avatar = ObservableField<String>()

}