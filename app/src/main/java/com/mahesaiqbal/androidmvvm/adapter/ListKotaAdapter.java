package com.mahesaiqbal.androidmvvm.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mahesaiqbal.androidmvvm.R;
import com.mahesaiqbal.androidmvvm.model.api.ListKota;
import com.mahesaiqbal.androidmvvm.model.view.ItemKota;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mahesaiqbal on 11/23/2017.
 */

public class ListKotaAdapter extends RecyclerView.Adapter<KotaViewHolder> {

    private List<ItemKota> kota;

    public ListKotaAdapter(List<ListKota.DataBean> data, OnClickImpl position_id) {

        kota = new ArrayList<>();

        for(ListKota.DataBean dataBean : data) {

            kota.add(new ItemKota("" + dataBean.getId() + ". " + dataBean.getKota()));

        }

    }

    @Override
    public KotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ViewDataBinding viewDataBinding = DataBindingUtil
                .inflate(layoutInflater, R.layout.item_list_kota, parent, false);

        return new KotaViewHolder(viewDataBinding);

    }

    @Override
    public void onBindViewHolder(KotaViewHolder holder, int position) {

        ViewDataBinding viewDataBinding = holder.getViewDataBinding();
        viewDataBinding.setVariable(com.mahesaiqbal.androidmvvm.BR.kota, kota.get(position));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                onClick(view);

            }
        });

    }

    @Override
    public int getItemCount() {
        return (null != kota ? kota.size() : 0);
    }

    public interface OnClickImpl{
        void onCLickView(int position);
    }

}
