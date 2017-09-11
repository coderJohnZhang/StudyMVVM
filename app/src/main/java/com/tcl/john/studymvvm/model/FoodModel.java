package com.tcl.john.studymvvm.model;

import com.tcl.john.studymvvm.bean.FoodBean;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Food 数据增删改查，一些网路请求和中间件调用都在这里完成
 * Created by ZhangJun on 2017/6/24.
 */

public class FoodModel {

    private OnUpdateFoodInfoCallBack mOnUpdateFoodInfoCallBack;

    private FoodModel() {

    }

    private static class FoodModelHolder {
        private static final FoodModel INSTANCE = new FoodModel();
    }

    public static final FoodModel getInstance() {
        return FoodModelHolder.INSTANCE;
    }

    public void requestFoodInfo() {
        OkHttpClient client = new OkHttpClient.Builder().build();
        Request request = new Request.Builder().url("http://www.tngou.net/api/food/list?id=1").build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    parseJson(response.body().string());
                }
            }
        });

    }

    private void parseJson(String jsonStr) {
        List<FoodBean> foodList = new ArrayList<>();
        try {
            JSONObject jo = new JSONObject(jsonStr);
            JSONArray tngou = jo.getJSONArray("tngou");
            for (int i = 0; i < tngou.length(); i++) {
                JSONObject item = tngou.getJSONObject(i);
                String description = item.getString("description");
                String img = "http://tnfs.tngou.net/image"+item.getString("img");
                String keywords = "【关键词】 "+item.getString("keywords");
                String summary = item.getString("summary");

                FoodBean food = new FoodBean();
                food.description.set(description);
                food.image.set(img);
                food.keywords.set(keywords);
                food.summary.set(summary);
                foodList.add(food);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (mOnUpdateFoodInfoCallBack != null) {
            mOnUpdateFoodInfoCallBack.updateFoodList(foodList);
        }
    }

    public interface OnUpdateFoodInfoCallBack {
        void updateFoodList(List<FoodBean> foodList);
    }

    public void setOnUpdateFoodInfoCallBack (OnUpdateFoodInfoCallBack onUpdateFoodInfoCallBack) {
        mOnUpdateFoodInfoCallBack = onUpdateFoodInfoCallBack;
    }
}