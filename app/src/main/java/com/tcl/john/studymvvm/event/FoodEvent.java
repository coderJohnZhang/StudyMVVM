package com.tcl.john.studymvvm.event;

import com.tcl.john.studymvvm.bean.FoodBean;

import java.util.List;

/**
 * Food的Message事件
 * Created by ZhangJun on 2017/7/6.
 */

public class FoodEvent {

    public static class FoodListEvent {
        public List<FoodBean> foodList;

        public FoodListEvent(List<FoodBean> foodList) {
            this.foodList = foodList;
        }
    }

    public static class FoodItemEvent {
        public FoodBean food;

        public FoodItemEvent(FoodBean food) {
            this.food = food;
        }
    }
}
