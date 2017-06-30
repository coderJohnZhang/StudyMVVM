package com.tcl.john.studymvvm.viewmodel.food;

import android.databinding.BindingAdapter;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.tcl.john.studymvvm.bean.FoodBean;

/**
 * Food 的ViewModel
 * 一个ViewModel接口提供了两个东西：动作和数据。
 * 动作改变Model的下层（click listener，监听文字改变的listener等等），而数据则是Model的内容。
 * Created by ZhangJun on 2017/6/27.
 */

public class FoodItemViewModel {

    public FoodBean food;

    public FoodItemViewModel(FoodBean food) {
        this.food = food;
    }

    @BindingAdapter("image")
    public static void getInternetImage(ImageView iv, String image) {
        Picasso.with(iv.getContext()).load(image).into(iv);
    }

    public void onItemClick(View view) {
        Toast.makeText(view.getContext(), food.description.get(), Toast.LENGTH_SHORT).show();
    }
}