package com.mahesaiqbal.androidmvvm.model.viewmodel;

import com.mahesaiqbal.androidmvvm.api.ApiInteractor;
import com.mahesaiqbal.androidmvvm.model.api.JadwalBioskop;

import rx.Observable;
import rx.Scheduler;
/**
 * Created by mahesaiqbal on 11/23/2017.
 */

public class JadwalViewModel {

    private ApiInteractor interactor;
    private Scheduler scheduler;

    public JadwalViewModel(ApiInteractor interactor, Scheduler scheduler) {
        this.interactor = interactor;
        this.scheduler = scheduler;
    }

    public Observable<JadwalBioskop> getJadwalBioskop(int id){
        return interactor.getJadwalBioskop(id).observeOn(scheduler);
    }
}
