package com.tcl.john.studymvvm.view.food;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.tcl.john.studymvvm.bean.FoodBean;
import com.tcl.john.studymvvm.databinding.FoodItemBinding;
import com.tcl.john.studymvvm.viewmodel.food.FoodItemViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Food 列表适配器
 * Created by ZhangJun on 2017/6/24.
 */

public class FoodDetailAdapter extends RecyclerView.Adapter<FoodDetailAdapter.FoodHolder> {

    private List<FoodBean> mFoods = new ArrayList<>();

    public FoodDetailAdapter(List<FoodBean> data) {
        this.mFoods = data;
    }

    @Override
    public FoodHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return FoodHolder.create(LayoutInflater.from(parent.getContext()), parent);
    }

    @Override
    public void onBindViewHolder(FoodHolder holder, int position) {
        holder.bindTo(mFoods.get(position));
    }

    @Override
    public int getItemCount() {
        if (mFoods == null)
            return 0;
        return mFoods.size();
    }

    static class FoodHolder extends RecyclerView.ViewHolder {
        private FoodItemBinding mFoodItemBinding;

        static FoodHolder create(LayoutInflater inflater, ViewGroup parent) {
            FoodItemBinding binding = FoodItemBinding.inflate(inflater, parent, false);
            return new FoodHolder(binding);
        }

        private FoodHolder(FoodItemBinding binding) {
            super(binding.getRoot());
            this.mFoodItemBinding = binding;
        }

        void bindTo(FoodBean food) {
            FoodItemViewModel foodItemViewModel = new FoodItemViewModel(food);
            mFoodItemBinding.setModel(foodItemViewModel);
            mFoodItemBinding.executePendingBindings();
        }

    }
}