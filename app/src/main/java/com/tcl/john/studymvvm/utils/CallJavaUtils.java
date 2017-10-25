package com.tcl.john.studymvvm.utils;

/**
 * 调用Java方法的工具类
 * Created by ZhangJun on 2017/10/25.
 */

public class CallJavaUtils {

    public static int addNumbers(String name, int... args) {
        int result = 0;
        for (int i = 0; i < args.length; i++) {
            result += args[i];
        }
        return result;
    }
}
