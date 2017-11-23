package com.mahesaiqbal.androidmvvm.adapter;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;

/**
 * Created by mahesaiqbal on 11/23/2017.
 */

public class ListJadwalViewHolder extends RecyclerView.ViewHolder{

    private ViewDataBinding viewDataBinding;

    public ListJadwalViewHolder(ViewDataBinding viewDataBinding) {
        super(viewDataBinding.getRoot());
        this.viewDataBinding = viewDataBinding;
    }

    public ViewDataBinding getViewDataBinding() {
        return viewDataBinding;
    }
}
