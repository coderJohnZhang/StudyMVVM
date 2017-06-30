package com.tcl.john.studymvvm.view.food;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.tcl.john.studymvvm.R;
import com.tcl.john.studymvvm.bean.FoodBean;
import com.tcl.john.studymvvm.databinding.ActivityFoodBinding;
import com.tcl.john.studymvvm.viewmodel.food.FoodListViewModel;

import java.util.List;

/**
 * 食物列表界面
 * Created by ZhangJun on 2017/6/29.
 */

public class FoodActivity extends AppCompatActivity implements FoodListViewModel.OnShowFoodListCallBack {

    private RecyclerView mFoodsRv;

    public static void navigateTo(Context mContext) {
        Intent intent = new Intent(mContext , FoodActivity.class);
        mContext.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityFoodBinding activityFoodBinding = DataBindingUtil.setContentView(this, R.layout.activity_food);

        initFoodList(activityFoodBinding);
    }

    private void initFoodList(ActivityFoodBinding activityFoodBinding) {
        FoodListViewModel foodListViewModel = new FoodListViewModel();
        activityFoodBinding.setModel(foodListViewModel);
        foodListViewModel.setOnShowFoodListCallBack(this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mFoodsRv = activityFoodBinding.foodRv;
        mFoodsRv.setLayoutManager(layoutManager);
    }

    @Override
    public void showFoodList(final List<FoodBean> foodList) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mFoodsRv.setAdapter(new FoodDetailAdapter(foodList));
            }
        });
    }

}