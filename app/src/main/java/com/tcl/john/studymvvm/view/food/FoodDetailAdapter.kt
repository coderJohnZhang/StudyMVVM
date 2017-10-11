package com.tcl.john.studymvvm.view.food

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

import com.tcl.john.studymvvm.bean.FoodBean
import com.tcl.john.studymvvm.databinding.FoodItemBinding
import com.tcl.john.studymvvm.viewmodel.food.FoodItemViewModel

import java.util.ArrayList

/**
 * Food 列表适配器
 * Created by ZhangJun on 2017/6/24.
 */

class FoodDetailAdapter(data: List<FoodBean>) : RecyclerView.Adapter<FoodDetailAdapter.FoodHolder>() {

    private var mFoods = ArrayList<FoodBean>()

    init {
        this.mFoods = data as ArrayList<FoodBean>
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodHolder {
        return FoodHolder.create(LayoutInflater.from(parent.context), parent)
    }

    override fun onBindViewHolder(holder: FoodHolder, position: Int) {
        holder.bindTo(mFoods[position])
    }

    override fun getItemCount(): Int {
        if (mFoods == null) {
            return 0
        }
        return mFoods.size
    }

    class FoodHolder private constructor(private val mFoodItemBinding: FoodItemBinding) : RecyclerView.ViewHolder(mFoodItemBinding.root) {

        fun bindTo(food: FoodBean) {
            val foodItemViewModel = FoodItemViewModel(food)
            mFoodItemBinding.model = foodItemViewModel
            mFoodItemBinding.executePendingBindings()
        }

        companion object {

            fun create(inflater: LayoutInflater, parent: ViewGroup): FoodHolder {
                val binding = FoodItemBinding.inflate(inflater, parent, false)
                return FoodHolder(binding)
            }
        }

    }
}