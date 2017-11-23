package com.mahesaiqbal.androidmvvm.adapter;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by mahesaiqbal on 11/23/2017.
 */

public class KotaViewHolder extends RecyclerView.ViewHolder {

    private ViewDataBinding viewDataBinding;

    public KotaViewHolder(ViewDataBinding viewDataBinding) {

        super(viewDataBinding.getRoot());
        this.viewDataBinding = viewDataBinding;
        viewDataBinding.executePendingBindings();

    }

    public ViewDataBinding getViewDataBinding() {

        return viewDataBinding;

    }

}
