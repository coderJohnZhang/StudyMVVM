package com.tcl.john.studymvvm.bean;

import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;

/**
 * User 实体类
 * Created by ZhangJun on 2017/6/24.
 */

public class UserBean {

    public final ObservableField<String> userName = new ObservableField<>();
    public final ObservableField<String> nickName = new ObservableField<>();
    public final ObservableInt age = new ObservableInt();
    public final ObservableBoolean isStudent = new ObservableBoolean();
    public final ObservableField<String> avatar = new ObservableField<>();

}