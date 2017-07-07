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
import com.tcl.john.studymvvm.databinding.ActivityFoodBinding;
import com.tcl.john.studymvvm.event.FoodEvent;
import com.tcl.john.studymvvm.viewmodel.food.FoodListViewModel;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * 食物列表界面，Activity或Fragment作为事件订阅者需要注册和取消注册事件
 * Created by ZhangJun on 2017/6/29.
 */

public class FoodActivity extends AppCompatActivity {

    private RecyclerView mFoodsRv;

    private FoodListViewModel mFoodListViewModel;

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

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private void initFoodList(ActivityFoodBinding activityFoodBinding) {
        mFoodListViewModel = new FoodListViewModel(this);
        activityFoodBinding.setModel(mFoodListViewModel);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mFoodsRv = activityFoodBinding.foodRv;
        mFoodsRv.setLayoutManager(layoutManager);
    }

    /**
     * 订阅者实现事件处理方法（也称为“订阅方法”），在事件发布时将被调用。 这些被定义为@Subscribe注解。
     * @param event
     */
    // Called in Android UI's main thread
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onFoodListEvent(FoodEvent.FoodListEvent event){
        mFoodsRv.setAdapter(new FoodDetailAdapter(event.foodList));
    }

}