package com.tcl.john.studymvvm.viewmodel;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.tcl.john.studymvvm.bean.UserBean;
import com.tcl.john.studymvvm.model.UserModel;
import com.tcl.john.studymvvm.view.food.FoodActivity;

/**
 * User 的ViewModel
 * Created by ZhangJun on 2017/6/27.
 */

public class UserViewModel {

    public UserBean user;

    private Context mContext;

    public UserViewModel(Context context) {
        mContext = context;
        initUserInfo();
    }

    @BindingAdapter("avatar")
    public static void getInternetImage(ImageView iv, String avatar) {
        Picasso.with(iv.getContext()).load(avatar).into(iv);
    }

    /**
     * 初始化数据
     */
    private void initUserInfo() {
        UserModel userModel = UserModel.getInstance();
        user = userModel.getUserInfo();
    }

    public void onFoodBtnClick() {
        FoodActivity.navigateTo(mContext);
    }

    public void onStudentBtnClick(View v) {
        user.isStudent.set(!user.isStudent.get());
    }

}