package com.mahesaiqbal.androidmvvm.api;

import com.mahesaiqbal.androidmvvm.model.api.JadwalBioskop;
import com.mahesaiqbal.androidmvvm.model.api.ListKota;

import rx.Observable;

/**
 * Created by mahesaiqbal on 11/23/2017.
 */

public interface ApiInteractor {
    Observable<ListKota> getListKota();
    Observable<JadwalBioskop> getJadwalBioskop(int id);
}
