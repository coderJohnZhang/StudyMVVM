package com.tcl.john.studymvvm.bean;

import android.databinding.ObservableArrayList;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableList;

/**
 * 食物列表对象
 * Created by ZhangJun on 2017/7/6.
 */

public class FoodListBean {

    public final ObservableList<FoodBean> foodList = new ObservableArrayList<>();
    public final ObservableBoolean isShowing = new ObservableBoolean(true);
}
