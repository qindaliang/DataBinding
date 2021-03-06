package com.qin.databinding;

import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Create by qindl
 * on 2018/11/7
 */
public class BindingViewHolder<T extends ViewDataBinding> extends RecyclerView.ViewHolder {

    private T mBinding;

    public BindingViewHolder(@NonNull T binding) {
        super(binding.getRoot());
        mBinding = binding;
    }

    public T getBinding() {
        return mBinding;
    }
}
