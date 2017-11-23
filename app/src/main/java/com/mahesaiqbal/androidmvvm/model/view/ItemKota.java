package com.mahesaiqbal.androidmvvm.model.view;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.mahesaiqbal.androidmvvm.BR;

import java.util.Observable;

/**
 * Created by mahesaiqbal on 11/23/2017.
 */

public class ItemKota extends BaseObservable {

    @Bindable
    public String item;

    public ItemKota(String item) {
        setItem(item);
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
        notifyPropertyChanged(BR.kota);
    }

}
