package com.tcl.john.studymvvm.event

import com.tcl.john.studymvvm.bean.FoodBean

/**
 * Food的Message事件
 * 1.kotlin默认的内部类是静态内部类，不能持有外部类的状态（属性、方法等）
 * 2.给内部类加上inner关键词之后，就会变成非静态内部类，可以访问外部类的属性和方法
 * 3.非静态内部类想访问外部类的属性，可以使用 this@外部类名.外部类属性名 的形式访问
 * 4.非静态内部类可以访问到外部静态内部类的方法和属性，静态内部类访问不到外部所有的属性和方法
 * Created by ZhangJun on 2017/7/6.
 */

class FoodEvent {

    class FoodModelEvent(var foodList: List<FoodBean>)

    class FoodViewModelEvent(var foodList: List<FoodBean>)
}
