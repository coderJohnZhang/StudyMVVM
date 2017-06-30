package com.tcl.john.studymvvm.bean;

import android.databinding.ObservableField;

/**
 * Food 实体类
 * Created by ZhangJun on 2017/6/24.
 */

public class FoodBean {

    public final ObservableField<String> description = new ObservableField<>();
    public final ObservableField<String> image = new ObservableField<>();
    public final ObservableField<String> keywords = new ObservableField<>();
    public final ObservableField<String> summary = new ObservableField<>();

}
