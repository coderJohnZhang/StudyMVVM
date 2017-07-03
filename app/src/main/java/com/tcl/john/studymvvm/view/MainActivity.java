package com.tcl.john.studymvvm.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.tcl.john.studymvvm.R;
import com.tcl.john.studymvvm.databinding.ActivityMainBinding;
import com.tcl.john.studymvvm.viewmodel.UserViewModel;

/**
 * View层中的Activity
 * View层负责View的绘制以及与用户交互
 * Created by ZhangJun on 2017/6/27.
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        initUserInfo(activityMainBinding);
    }

    private void initUserInfo(ActivityMainBinding activityMainBinding) {
        final UserViewModel userViewModel = new UserViewModel(this);
        activityMainBinding.setModel(userViewModel);
        activityMainBinding.foodButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userViewModel.onFoodBtnClick();
            }
        });
    }

}