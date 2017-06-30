package com.tcl.john.studymvvm.model;

import com.tcl.john.studymvvm.bean.UserBean;

/**
 * User 数据增删改查
 * Created by ZhangJun on 2017/6/24.
 */

public class UserModel {

    private static UserModel sUserModel; // 防止创建多次，设置为单例

    private UserModel() {
        // 通过getInstance()方法获取实例
    }

    /**
     * 获取当前类示例
     */
    public synchronized static UserModel getInstance() {
        if (sUserModel == null) {
            sUserModel = new UserModel();
        }
        return sUserModel;
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