package com.mahesaiqbal.androidmvvm.model.view;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.mahesaiqbal.androidmvvm.BR;

/**
 * Created by mahesaiqbal on 11/23/2017.
 */

public class Jadwal extends BaseObservable {

    @Bindable
    public String kota;

    public Jadwal(String kota) {
        setKota(kota);
    }

    public String getKota() {
        return kota;
    }

    public void setKota(String kota) {
        this.kota = kota;
        notifyPropertyChanged(BR.jadwal);
    }
}
