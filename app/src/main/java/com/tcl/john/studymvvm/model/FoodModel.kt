package com.tcl.john.studymvvm.model

import com.tcl.john.studymvvm.bean.FoodBean
import com.tcl.john.studymvvm.event.FoodEvent

import org.greenrobot.eventbus.EventBus
import org.json.JSONException
import org.json.JSONObject

import java.io.IOException
import java.util.ArrayList

import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response

/**
 * Food 数据增删改查，一些网路请求和中间件调用都在这里完成
 * Created by ZhangJun on 2017/6/24.
 */

class FoodModel private constructor() {

    private class FoodModelHolder {
        companion object {
            val INSTANCE: FoodModel = FoodModel()
        }
    }

    companion object {
        fun getInstance(): FoodModel? {
            return FoodModelHolder.INSTANCE
        }
    }

    fun requestFoodInfo() {
        val client = OkHttpClient.Builder().build()
        val request = Request.Builder().url("http://www.tngou.net/api/food/list?id=1").build()
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                EventBus.getDefault().post(FoodEvent.FoodModelEvent(null))
            }

            @Throws(IOException::class)
            override fun onResponse(call: Call, response: Response) {
                if (response.isSuccessful) {
                    parseJson(response.body()!!.string())
                }
            }
        })

    }

    private fun parseJson(jsonStr: String) {
        val foodList = ArrayList<FoodBean>()
        try {
            val jo = JSONObject(jsonStr)
            val tngou = jo.getJSONArray("tngou")
            for (i in 0..tngou.length() - 1) {
                val item = tngou.getJSONObject(i)
                val description = item.getString("description")
                val img = "http://tnfs.tngou.net/image" + item.getString("img")
                val keywords = "【关键词】 " + item.getString("keywords")
                val summary = item.getString("summary")

                val food = FoodBean()
                food.description.set(description)
                food.image.set(img)
                food.keywords.set(keywords)
                food.summary.set(summary)
                foodList.add(food)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        EventBus.getDefault().post(FoodEvent.FoodModelEvent(foodList))
    }
}