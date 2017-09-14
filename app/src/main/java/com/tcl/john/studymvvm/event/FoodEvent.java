package com.tcl.john.studymvvm.event;

import com.tcl.john.studymvvm.bean.FoodBean;

import java.util.List;

/**
 * Food的Message事件
 * Created by ZhangJun on 2017/7/6.
 */

public class FoodEvent {

    public static class FoodModelEvent {
        public List<FoodBean> foodList;

        public FoodModelEvent(List<FoodBean> foodList) {
            this.foodList = foodList;
        }
    }

    public static class FoodViewModelEvent {
        public List<FoodBean> foodList;

        public FoodViewModelEvent(List<FoodBean> foodList) {
            this.foodList = foodList;
        }
    }
}
