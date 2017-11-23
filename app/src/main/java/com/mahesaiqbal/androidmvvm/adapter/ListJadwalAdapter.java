package com.mahesaiqbal.androidmvvm.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.mahesaiqbal.androidmvvm.BR;
import com.mahesaiqbal.androidmvvm.R;
import com.mahesaiqbal.androidmvvm.model.api.JadwalBioskop;
import com.mahesaiqbal.androidmvvm.model.view.ItemListJadwal;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mahesaiqbal on 11/23/2017.
 */

public class ListJadwalAdapter extends RecyclerView.Adapter<ListJadwalViewHolder> {

    private List<ItemListJadwal> itemListJadwals;

    public ListJadwalAdapter(List<JadwalBioskop.DataBean> data) {
        this.itemListJadwals = new ArrayList<>();
        for (JadwalBioskop.DataBean dataBean : data) {
            ItemListJadwal mList = new ItemListJadwal();
            List<ItemListJadwal.JadwalBean> listJadwal = null;

            mList.setDuration(dataBean.getDuration());
            mList.setGenre(dataBean.getGenre());
            mList.setMovie(dataBean.getMovie());
            mList.setPoster(dataBean.getPoster());

            for (JadwalBioskop.DataBean.JadwalBean jadwalBean : dataBean.getJadwal()) {
                listJadwal.add(new ItemListJadwal.JadwalBean(
                        jadwalBean.getBioskop(),
                        jadwalBean.getHarga(),
                        jadwalBean.getJam())
                );
            }

            mList.setJadwal(listJadwal);
            itemListJadwals.add(mList);
        }
    }

    @Override public ListJadwalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ViewDataBinding viewDataBinding = DataBindingUtil.inflate(inflater, R.layout.item_jadwal, parent, false);
        return new ListJadwalViewHolder(viewDataBinding);
    }

    @Override public void onBindViewHolder(ListJadwalViewHolder holder, int position) {
        ViewDataBinding viewDataBinding = holder.getViewDataBinding();
        viewDataBinding.setVariable(BR.listJadwal, itemListJadwals.get(position));
    }

    @Override public int getItemCount() {
        return (null != itemListJadwals ? itemListJadwals.size() : 0);
    }
}
