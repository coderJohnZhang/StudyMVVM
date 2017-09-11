package com.tcl.john.studymvvm.model;

import com.tcl.john.studymvvm.bean.UserBean;

/**
 * User 数据增删改查
 * Created by ZhangJun on 2017/6/24.
 */

public class UserModel {

    private UserModel() {

    }

    private static class UserModelHolder {
        private static final UserModel INSTANCE = new UserModel();
    }

    public static final UserModel getInstance() {
        return UserModelHolder.INSTANCE;
    }

    public UserBean getUserInfo() {
        UserBean user = new UserBean();
        user.userName.set("ZhangSan");
        user.nickName.set("XiaoZhang");
        user.age.set(26);
        user.avatar.set("http://img2.cache.netease.com/auto/2016/7/28/201607282215432cd8a.jpg");
        user.isStudent.set(false);

        return user;
    }

}