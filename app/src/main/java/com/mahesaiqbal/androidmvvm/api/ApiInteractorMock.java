package com.mahesaiqbal.androidmvvm.api;

import com.mahesaiqbal.androidmvvm.model.api.JadwalBioskop;
import com.mahesaiqbal.androidmvvm.model.api.ListKota;

import rx.Observable;

/**
 * Created by mahesaiqbal on 11/23/2017.
 */

public class ApiInteractorMock implements ApiInteractor{
    @Override public Observable<ListKota> getListKota() {
        return Observable.just(getMockListKota());
    }

    @Override public Observable<JadwalBioskop> getJadwalBioskop(int id) {
        return Observable.just(getMockJadwalBioskop());
    }

    private JadwalBioskop getMockJadwalBioskop() {
        return new JadwalBioskop();
    }

    private ListKota getMockListKota(){
        return new ListKota();
    }
}